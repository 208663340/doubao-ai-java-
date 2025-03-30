package org.example.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.volcengine.ark.runtime.model.completion.chat.ChatCompletionRequest;
import com.volcengine.ark.runtime.model.completion.chat.ChatMessage;
import com.volcengine.ark.runtime.model.completion.chat.ChatMessageRole;
import com.volcengine.ark.runtime.service.ArkService;
import lombok.RequiredArgsConstructor;
import org.example.admin.comon.enums.AiModelTypeEnum;
import org.example.admin.dao.entity.AiMessages;
import org.example.admin.dao.entity.UserMessages;
import org.example.admin.dao.mapper.AiMessagesMapper;
import org.example.admin.dto.req.chat.ChatStreamReq;
import org.example.admin.dto.resp.chat.ChatStreamResp;
import org.example.admin.service.AiMessagesService;
import org.example.admin.service.UserMessagesService;
import org.example.admin.utils.ai.ArkClient;
import org.example.admin.utils.chatsessionid.ChatSessionManager;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
* @author 20866
* @description 针对表【ai_messages(存储AI生成的回复消息)】的数据库操作Service实现
* @createdTimee 2025-03-28 11:07:30
*/
@Service
@RequiredArgsConstructor
public class AiMessagesServiceImpl extends ServiceImpl<AiMessagesMapper, AiMessages>
    implements AiMessagesService {


    private final UserMessagesService userMessagesService;
    
    private static final Logger logger = LoggerFactory.getLogger(AiMessagesServiceImpl.class);

    private final ArkClient arkClient;

    private final ChatSessionManager ChatSessionManager;

    //todo 测试数据
    private final long userid = 12345677;
    @Override
    public void streamChat(ChatStreamReq req, SseEmitter emitter) {
        try {
            // 生成会话ID
            String sessionId = ChatSessionManager.generateId(userid);
//            String sessionId = ChatSessionManager.generateId(req.getUserId());

            // 保存用户消息
            UserMessages userMessage = new UserMessages();
            userMessage.setSessionId(sessionId);
//            userMessage.setUserId(req.getUserId());
            userMessage.setMessageText(req.getMessage());
            userMessage.setCreatedTime(new Date());
            userMessagesService.save(userMessage);

            // 构建消息列表
            List<ChatMessage> messages = new ArrayList<>();
            messages.add(ChatMessage.builder()
                    .role(ChatMessageRole.USER)
                    .content(req.getMessage())
                    .build());

            // 创建请求
            ChatCompletionRequest chatRequest = ChatCompletionRequest.builder()
                    .model(AiModelTypeEnum.Doubao_1_5_vision_pro_32k.type())
                    .messages(messages)
                    .build();

            // 获取ArkService实例
            ArkService service = arkClient.getArkService();

            // 初始化AI消息
            AiMessages aiMessages = new AiMessages();
            aiMessages.setSessionId(sessionId);
            aiMessages.setCreatedTime(new Date());
            StringBuilder messageBuilder = new StringBuilder();

            // 发起流式请求
            service.streamChatCompletion(chatRequest)
                    .doOnError(throwable -> {
                        logger.error("Stream chat error", throwable);
                        try {
                            ChatStreamResp errorResp = new ChatStreamResp();
                            errorResp.setError(throwable.getMessage());
                            errorResp.setEnd(true);
                            emitter.send(errorResp);
                            emitter.complete();
                        } catch (IOException e) {
                            logger.error("Error sending error response", e);
                            emitter.completeWithError(e);
                        }
                    })
                    .blockingForEach(choice -> {
                        try {
                            if (!choice.getChoices().isEmpty()) {
                                ChatStreamResp resp = new ChatStreamResp();
                                resp.setContent((String) choice.getChoices().get(0).getMessage().getContent());
                                resp.setEnd(choice.getChoices().get(0).getFinishReason() != null);
                                // 在第一条消息时设置sessionId
                                if (messageBuilder.isEmpty()) {
                                    resp.setSessionId(sessionId);
                                }
                                emitter.send(resp);

                                // 累积AI回复内容
                                messageBuilder.append(resp.getContent());

                                if (resp.isEnd()) {
                                    // 保存AI回复消息到数据库
                                    aiMessages.setMessageText(messageBuilder.toString());
                                    save(aiMessages);
                                    emitter.complete();
                                }
                            }
                        } catch (IOException e) {
                            logger.error("Error sending stream response", e);
                            emitter.completeWithError(e);
                        }
                    });
        } catch (Exception e) {
            logger.error("Stream chat processing error", e);
            try {
                ChatStreamResp errorResp = new ChatStreamResp();
                errorResp.setError("处理请求时发生错误");
                errorResp.setEnd(true);
                emitter.send(errorResp);
            } catch (IOException ex) {
                logger.error("Error sending error response", ex);
            } finally {
                emitter.complete();
            }
        }
    }
}




