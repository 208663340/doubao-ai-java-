package org.example.admin.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;


public class IdGeneratorTest {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    private static final Pattern ORDER_ID_PATTERN = Pattern.compile("^ORD\\d{14}\\d{6}$");
    private static final Pattern CHAT_SESSION_ID_PATTERN = Pattern.compile("^CHAT[0-9a-fA-F]{32}$");

    @Test
    public void testGenerateOrderId() {
        // 调用被测试的方法
        String orderId = IdGenerator.generateOrderId();
        System.out.println(orderId);
        // 验证订单号不为空
        assertNotNull(orderId, "订单号不应为空");

        // 验证订单号格式是否正确
        assertTrue(ORDER_ID_PATTERN.matcher(orderId).matches(), "订单号格式不正确");

        // （可选）更详细的验证，比如检查前缀和时间部分
        String prefix = orderId.substring(0, 3);
        assertEquals("ORD", prefix, "订单号前缀应为 'ORD'");

        String timestampPart = orderId.substring(3, 17);
        try {
            LocalDateTime.parse(timestampPart, DATE_FORMATTER);
        } catch (Exception e) {
            fail("时间戳部分格式不正确，应为 yyyyMMddHHmmss");
        }

        String randomNum = orderId.substring(17);
        try {

            Integer.parseInt(randomNum);
            assertTrue(randomNum.length() == 6, "随机数部分应为6位数字");
            System.out.println(randomNum);
        } catch (NumberFormatException e) {
            fail("随机数部分应为数字");
        }
    }

    @Test
    public void testGenerateChatSessionId() {
        // 调用被测试的方法
        String chatSessionId = IdGenerator.generateChatSessionId();
        System.out.println(chatSessionId);
        // 验证会话ID不为空
        assertNotNull(chatSessionId, "会话ID不应为空");

        // 验证会话ID格式是否正确
        assertTrue(CHAT_SESSION_ID_PATTERN.matcher(chatSessionId).matches(), "会话ID格式不正确");

        // （可选）验证前缀
        String prefix = chatSessionId.substring(0, 4);
        assertEquals("CHAT", prefix, "会话ID前缀应为 'CHAT'");
        System.out.println(prefix);
    }

    // 如果确实需要 mock 静态方法（例如，为了隔离测试环境），可以使用以下示例
    /*
    @Test
    public void testGenerateOrderIdWithMockedStatic() {
        String expectedPrefix = "MOCK";
        String expectedTimestamp = "20230427123456";
        String expectedRandomNum = "123456";
        String expectedOrderId = expectedPrefix + expectedTimestamp + expectedRandomNum;

        try (MockedStatic<IdGenerator> mockedStatic = Mockito.mockStatic(IdGenerator.class)) {
            // 注意：静态 mock 需要 Mockito-inline
            mockedStatic.when(IdGenerator::generateOrderId).thenReturn(expectedOrderId);

            String actualOrderId = IdGenerator.generateOrderId();

            assertEquals(expectedOrderId, actualOrderId, "生成的订单号应与 mock 的值相同");

            mockedStatic.verify(() -> IdGenerator.generateOrderId(), Mockito.times(1));
        }
    }
    */

    /*
     * 注意：上述 mock 静态方法的示例仅用于展示如何使用 Mockito-inline。
     * 然而，对于像 generateOrderId 这样的纯函数，通常不建议进行静态 mock，
     * 因为它违背了单元测试的最佳实践（即测试实际的行为而不是模拟行为）。
     */
}
