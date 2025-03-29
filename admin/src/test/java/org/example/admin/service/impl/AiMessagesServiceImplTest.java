package org.example.admin.service.impl;


import org.example.admin.dto.req.chat.ChatStreamReq;
import org.example.admin.service.impl.AiMessagesServiceImpl;
import org.example.admin.utils.ai.ArkClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

class AiMessagesServiceImplTest {

    @Mock
    private ArkClient arkClient;

    private SseEmitter emitter;

    private AiMessagesServiceImpl aiMessagesService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        emitter = new SseEmitter();
        aiMessagesService = new AiMessagesServiceImpl(arkClient);
    }

    @Test
    void testStreamChat_Success() {
        // 准备测试数据
        ChatStreamReq req = new ChatStreamReq();
        req.setMessage("你好你是谁？");

        // 执行测试
        aiMessagesService.streamChat(req, emitter);

    }
}