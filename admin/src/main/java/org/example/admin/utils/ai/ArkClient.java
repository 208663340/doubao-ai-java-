package org.example.admin.utils.ai;

import com.volcengine.ark.runtime.service.ArkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ArkClient {
    private static final Logger logger = LoggerFactory.getLogger(ArkClient.class);

    @Value("${huoshan.ark-api-key}")
    private String apiKey;

    private volatile ArkService arkService;

    /**
     * 单例模式生成 ArkService供全局访问
     * @return
     */
    public ArkService getArkService() {
        if (arkService == null) {
            synchronized (this) {
                if (arkService == null) {
                    try {
                        arkService = ArkService.builder()
                                .apiKey(apiKey)
                                .build();
                        logger.info("ArkService initialized successfully");
                    } catch (Exception e) {
                        logger.error("Failed to initialize ArkService", e);
                        throw new RuntimeException("Failed to initialize ArkService", e);
                    }
                }
            }
        }
        return arkService;
    }

}