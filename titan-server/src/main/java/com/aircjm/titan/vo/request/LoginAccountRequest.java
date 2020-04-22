package com.aircjm.titan.vo.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 登录入参
 *
 * @author aircjm
 */
@Data
public class LoginAccountRequest {

    @NotNull(message = "userName 用户名 不能为空")
    private String userName;

    @NotNull(message = "password 密码 不能为空")
    private String password;

    private String type;

}
