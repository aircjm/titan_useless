package com.aircjm.titan.security.authentication;


import com.aircjm.titan.security.UserDetail;

/**
 * Authentication implementation.
 *
 * @author johnniang
 */
public class AuthenticationImpl implements Authentication {

    private final UserDetail userDetail;

    public AuthenticationImpl(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    @Override
    public UserDetail getDetail() {
        return userDetail;
    }
}
