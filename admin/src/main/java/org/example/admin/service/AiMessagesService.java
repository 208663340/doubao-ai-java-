package org.example.admin.service;

import org.example.admin.dao.entity.AiMessages;
import org.example.admin.dto.req.chat.ChatStreamReq;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

/**
* @author 20866
* @description 针对表【ai_messages(存储AI生成的回复消息)】的数据库操作Service
* @createdTimee 2025-03-28 11:07:30
*/
public interface AiMessagesService extends IService<AiMessages> {

    /**
     * 处理流式对话请求
     * @param req 对话请求参数
     * @param emitter SSE发射器
     */
    void streamChat(ChatStreamReq req, SseEmitter emitter);
}
