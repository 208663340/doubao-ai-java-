package org.example.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.admin.dao.entity.User;
import org.example.admin.service.UserService;
import org.example.admin.dao.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author 20866
* @description 针对表【user】的数据库操作Service实现
* @createDate 2025-03-15 13:27:42
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




