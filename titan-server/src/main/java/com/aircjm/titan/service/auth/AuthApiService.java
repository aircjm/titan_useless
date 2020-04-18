package com.aircjm.titan.service.auth;

import com.aircjm.titan.model.auth.AuthApi;


/**
 * @author haseochen
 */
public interface AuthApiService {

    /**
     * 增加 api
     * @param authApi
     * @return
     */
    void add(AuthApi authApi);

    AuthApi update(AuthApi authApi);
}
