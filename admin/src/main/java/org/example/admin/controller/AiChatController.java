package org.example.admin.controller;

import lombok.RequiredArgsConstructor;
import org.example.admin.comon.convention.result.Result;
import org.example.admin.dto.req.chat.*;
import org.example.admin.dto.resp.chat.*;
import org.example.admin.service.AiMessagesService;
import org.example.admin.service.UserMessagesService;
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

         aiMessagesService.streamChat(req, emitter);
        
        return emitter;
    }


    /**
     * 获取会话历史消息
     */
    @GetMapping("/chat/history/{sessionId}")
    public Result<GetSessionHistoryResp> getSessionHistory(
            @PathVariable String sessionId,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "1") Integer pageNum) {
        return null; // TODO: 实现获取历史消息逻辑
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