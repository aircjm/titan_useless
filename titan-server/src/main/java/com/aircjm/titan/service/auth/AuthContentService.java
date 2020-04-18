package com.aircjm.titan.service.auth;

import com.aircjm.titan.model.auth.AuthContent;

/**
 * @author haseochen
 */
public interface AuthContentService {

    AuthContent save(AuthContent authContent);

    AuthContent update(AuthContent authContent) ;
}
