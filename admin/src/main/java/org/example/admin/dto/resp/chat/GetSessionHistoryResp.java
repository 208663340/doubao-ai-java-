package org.example.admin.dto.resp.chat;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 获取会话历史响应
 */
@Data
public class GetSessionHistoryResp {

    /**
     * 消息列表
     */
    private List<MessageInfo> messages;

    /**
     * 总记录数
     */
    private Long total;

    @Data
    public static class MessageInfo {
        /**
         * 消息ID
         */
        private Integer messageId;

        /**
         * 消息类型（user/ai）
         */
        private String type;

        /**
         * 消息内容
         */
        private String content;

        /**
         * 发送时间
         */
        private Date createdTime;

        /**
         * 附加信息
         */
        private Object metadata;
    }
}