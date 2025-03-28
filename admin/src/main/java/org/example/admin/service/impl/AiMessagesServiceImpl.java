package org.example.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.admin.dao.entity.AiMessages;
import org.example.admin.service.AiMessagesService;
import org.example.admin.dao.mapper.AiMessagesMapper;
import org.springframework.stereotype.Service;

/**
* @author 20866
* @description 针对表【ai_messages(存储AI生成的回复消息)】的数据库操作Service实现
* @createDate 2025-03-28 11:07:30
*/
@Service
public class AiMessagesServiceImpl extends ServiceImpl<AiMessagesMapper, AiMessages>
    implements AiMessagesService{

}




