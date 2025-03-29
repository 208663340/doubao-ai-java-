package org.example.admin.controller;

import lombok.RequiredArgsConstructor;
import org.example.admin.comon.convention.result.Result;
import org.example.admin.dto.req.chat.*;
import org.example.admin.dto.resp.chat.*;
import org.example.admin.service.AiMessagesService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

/**
 * AI聊天控制器
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class AiChatController {

    private final AiMessagesService aiMessagesService;

    /**
     * 流式对话接口
     */
    @PostMapping("/chat/stream")
    public SseEmitter streamChat(@RequestBody ChatStreamReq req) {
        SseEmitter emitter = new SseEmitter();
        
        // 设置超时回调
        emitter.onTimeout(() -> {
            try {
                ChatStreamResp resp = new ChatStreamResp();
                resp.setError("连接超时");
                resp.setEnd(true);
                emitter.send(resp);
                emitter.complete();
            } catch (IOException e) {
                emitter.completeWithError(e);
            }
        });

        // 设置错误回调
        emitter.onError((throwable) -> {
            try {
                ChatStreamResp resp = new ChatStreamResp();
                resp.setError(throwable.getMessage());
                resp.setEnd(true);
                emitter.send(resp);
                emitter.complete();
            } catch (IOException e) {
                emitter.completeWithError(e);
            }
        });

        // TODO: 实现实际的流式对话逻辑
         aiMessagesService.streamChat(req, emitter);
        
        return emitter;
    }

    /**
     * 创建新会话
     */
    @PostMapping("/sessions")
    public Result<CreateSessionResp> createSession(@RequestBody CreateSessionReq req) {
        return null; // TODO: 实现创建会话逻辑
    }

    /**
     * 获取会话历史消息
     */
    @GetMapping("/sessions/{sessionId}/messages")
    public Result<GetSessionHistoryResp> getSessionHistory(
            @PathVariable Integer sessionId,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "1") Integer pageNum) {
        return null; // TODO: 实现获取历史消息逻辑
    }

    /**
     * 发送用户消息并获取AI回复
     */
    @PostMapping("/sessions/{sessionId}/messages")
    public Result<SendMessageResp> sendMessage(
            @PathVariable Integer sessionId,
            @RequestBody SendMessageReq req) {
        return null; // TODO: 实现发送消息逻辑
    }

    /**
     * 获取可用的AI模型配置列表
     */
    @GetMapping("/model-configs")
    public Result<GetModelConfigsResp> getModelConfigs() {
        return null; // TODO: 实现获取模型配置列表逻辑
    }

    /**
     * 更新AI模型配置
     */
    @PutMapping("/model-configs/{configId}")
    public Result<UpdateModelConfigResp> updateModelConfig(
            @PathVariable Integer configId,
            @RequestBody UpdateModelConfigReq req) {
        return null; // TODO: 实现更新模型配置逻辑
    }
}