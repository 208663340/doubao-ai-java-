package org.example.admin.utils;

import cn.hutool.core.util.RandomUtil;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.HexFormat;

/**
 * ID生成器工具类
 * 用于生成订单号和会话ID
 */
public class IdGenerator {
    private static final String ORDER_PREFIX = "ORD";
    private static final String CHAT_PREFIX = "CHAT";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    /**
     * 生成订单号
     * 格式：ORD + 时间戳 + 6位随机数
     * @return 订单号
     */
    public static String generateOrderId() {
        String timestamp = LocalDateTime.now().format(DATE_FORMATTER);
        String randomNum = RandomUtil.randomNumbers(6);
        return ORDER_PREFIX + timestamp + randomNum;
    }

    /**
     * 生成会话ID
     * 格式：CHAT + UUID(无横线)
     * @return 会话ID
     */
    public static String generateChatSessionId() {
        String timestamp = LocalDateTime.now().format(DATE_FORMATTER);
        String input = timestamp + UUID.randomUUID().toString();
        
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            String hashHex = HexFormat.of().formatHex(hash);
            return CHAT_PREFIX + hashHex.substring(0, 32);
        } catch (NoSuchAlgorithmException e) {
            // 如果SHA-256不可用，回退到原始UUID方案
            return CHAT_PREFIX + UUID.randomUUID().toString().replace("-", "");
        }
    }
}