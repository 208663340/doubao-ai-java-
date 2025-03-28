package org.example.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.admin.dao.entity.UserMessages;
import org.example.admin.service.UserMessagesService;
import org.example.admin.dao.mapper.UserMessagesMapper;
import org.springframework.stereotype.Service;

/**
* @author 20866
* @description 针对表【user_messages(存储用户发送的消息)】的数据库操作Service实现
* @createDate 2025-03-28 11:07:52
*/
@Service
public class UserMessagesServiceImpl extends ServiceImpl<UserMessagesMapper, UserMessages>
    implements UserMessagesService{

}




