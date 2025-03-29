package org.example.admin.userLoginTest;


// region 基础类导入
import org.example.admin.controller.UserLoginController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
// endregion

// region 被测类相关导入
import org.example.admin.comon.convention.result.Result;
import org.example.admin.dto.resp.user.UserRespDTO;
import org.example.admin.service.SysUserService;
// endregion

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserLoginControllerTest {

    @Mock
    private SysUserService userService;

    @InjectMocks
    private UserLoginController userLoginController;

    // 测试场景：用户存在时的正常查询
    @Test
    void getUserByUsername_WhenUserExists_ShouldReturnSuccessResult() {
        // 1. 准备测试数据
        String username = "testUser";
        UserRespDTO mockUser = new UserRespDTO();
        mockUser.setId(1L);
        mockUser.setUsername(username);

        // 2. 配置 Mock 行为
        when(userService.getUserByUsername(username)).thenReturn(mockUser);

        // 3. 执行被测方法
        Result<UserRespDTO> result = userLoginController.getUserByUsername(username);

        // 4. 验证结果
        assertAll(
                () -> assertEquals(Result.SUCCESS_CODE, result.getCode(), "响应码应为成功码"),
                () -> assertEquals(mockUser, result.getData(), "返回的用户数据应与预期一致"),
                () -> verify(userService, times(1)).getUserByUsername(username)
        );
    }

    // 测试场景：用户不存在时的查询
    @Test
    void getUserByUsername_WhenUserNotExists_ShouldReturnNullData() {
        // 1. 准备测试数据
        String username = "nonExistingUser";

        // 2. 配置 Mock 行为
        when(userService.getUserByUsername(username)).thenReturn(null);

        // 3. 执行被测方法
        Result<UserRespDTO> result = userLoginController.getUserByUsername(username);

        // 4. 验证结果
        assertAll(
                () -> assertEquals(Result.SUCCESS_CODE, result.getCode(), "响应码应为成功码"),
                () -> assertNull(result.getData(), "用户不存在时应返回 null"),
                () -> verify(userService, times(1)).getUserByUsername(username)
        );
    }

    // 测试场景：服务层抛出异常
    @Test
    void getUserByUsername_WhenServiceThrowsException_ShouldPropagateException() {
        // 1. 准备测试数据
        String username = "errorUser";
        RuntimeException expectedException = new RuntimeException("Service Error");

        // 2. 配置 Mock 行为
        when(userService.getUserByUsername(username)).thenThrow(expectedException);

        // 3. 执行验证
        Exception exception = assertThrows(RuntimeException.class, () ->
                userLoginController.getUserByUsername(username)
        );

        // 4. 验证异常
        assertEquals(expectedException, exception, "应正确传播服务层异常");
    }
}
