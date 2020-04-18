package com.aircjm.titan.service.auth;

import com.aircjm.titan.model.auth.User;
import com.aircjm.titan.model.params.LoginParam;
import com.aircjm.titan.model.params.QueryParam;
import com.aircjm.titan.security.AuthToken;
import com.aircjm.titan.vo.response.UserInfoResponse;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.lang.NonNull;

/**
 * User Service 接口
 *
 * @author aircjm
 * @since 2017/7/12 21:25
 */
public interface UserService extends IService<User> {

    void addUser(User user);

    void updateUser(User user);

    User getUserSingle(Integer id);

    /**
     * 修改用户密码
     *
     * @param username    用户名
     * @param oldPassword 原密码
     * @param newPassword 新密码
     * @return boolean
     */
    boolean resetPassword(String username, String oldPassword, String newPassword);

    /**
     * 修改用户信息
     *
     * @param oldUsername 原用户名
     * @param newUsername 新用户名
     * @param email       邮箱
     * @return boolean
     */
    boolean resetUser(String oldUsername, String newUsername, String email);

    /**
     * Authenticates.
     *
     * @param loginParam login param must not be null
     * @return authentication token
     */
    @NonNull
    AuthToken authenticate(@NonNull LoginParam loginParam);

    /**
     * Clears authentication.
     */
    void clearToken();

    /**
     * 获取用户列表
     *
     * @return
     */
    IPage<User> getUserList(QueryParam queryParam);

    void assignRole(User user);

    UserInfoResponse getUserInfo(String token);
}
