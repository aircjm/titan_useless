package com.aircjm.titan.service;

import com.aircjm.titan.model.params.LoginParam;
import com.aircjm.titan.security.AuthToken;
import com.aircjm.titan.service.auth.UserService;
import com.aircjm.titan.utils.JsonUtil;
import com.aircjm.titan.vo.response.UserInfoResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserServiceTests {

    @Autowired
    private UserService userService;



    @Test
    public void resetPassword(){
        userService.resetPassword("dice","123456","123456");
    }

    @Test
    public void resetUser(){
        userService.resetUser("dice","dice","tpxcer@outlook.com");
    }

    @Test
    public void getUserInfo() throws JsonProcessingException {
        LoginParam loginParam = new LoginParam();
        loginParam.setUsername("admin");
        loginParam.setPassword("123456");
        AuthToken authenticate = userService.authenticate(loginParam);
        UserInfoResponse userInfo = userService.getUserInfo(authenticate.getAccessToken());

        log.info(JsonUtil.objectToJson(userInfo));
    }

}
