package org.example.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.admin.comoon.convention.exception.ServiceException;
import org.example.admin.comoon.enums.UserErrorCodeEnum;
import org.example.admin.dao.entity.UserDO;
import org.example.admin.dto.req.UserLoginReqDTO;
import org.example.admin.dto.req.UserRegisterReqDTO;
import org.example.admin.dto.req.UserUpdateReqDTO;
import org.example.admin.dto.resp.UserLoginRespDTO;
import org.example.admin.dto.resp.UserRespDTO;
import org.example.admin.service.UserService;
import org.example.admin.dao.mapper.UserMapper;
import org.redisson.api.RedissonClient;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
* @author 20866
* @description 针对表【user】的数据库操作Service实现
* @createDate 2025-03-15 13:27:42
*/
@RequiredArgsConstructor
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO>
    implements UserService{


    private final RedissonClient redissonClient;

    @Override
    public UserRespDTO getUserByUsername(String username) {
        LambdaQueryWrapper<UserDO> queryWrapper = new LambdaQueryWrapper<>(UserDO.class)
                .eq(UserDO::getUsername, username);
        UserDO userDO = getOne(queryWrapper);
        if (userDO == null) {
            throw new ServiceException(UserErrorCodeEnum.USER_NULL);
        }
        UserRespDTO result = new UserRespDTO();
        BeanUtils.copyProperties(userDO, result);
        return result;
    }

    @Override
    public Boolean hasUsername(String username) {
        return null;
    }

    @Override
    public void register(UserRegisterReqDTO requestParam) {

    }

    @Override
    public void update(UserUpdateReqDTO requestParam) {

    }

    @Override
    public UserLoginRespDTO login(UserLoginReqDTO requestParam) {
        return null;
    }

    @Override
    public Boolean checkLogin(String username, String token) {
        return null;
    }

    @Override
    public void logout(String username, String token) {

    }
}




