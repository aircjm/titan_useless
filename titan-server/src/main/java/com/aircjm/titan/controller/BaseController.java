package com.aircjm.titan.controller;

import com.aircjm.titan.model.auth.User;
import com.aircjm.titan.security.context.SecurityContextHolder;
import com.aircjm.titan.utils.CacheUtil;
import com.aircjm.titan.enums.ErrorCode;
import com.aircjm.titan.vo.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * 公共类 Controller
 *
 * @author aircjm
 */
public abstract class BaseController {

    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected CacheUtil cacheUtil;

    protected User user() {
        return Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getDetail().getUser();
    }

    protected RestResponse error404() {
        return RestResponse.fail(ErrorCode.NOT_FOUND.getCode(), ErrorCode.NOT_FOUND.getMsg());
    }
}
