package com.aircjm.titan.service.auth;

import com.aircjm.titan.model.auth.AuthItem;

/**
 * @author haseochen
 */
public interface AuthItemService {

    /**
     * @param authItem
     * @return
     */
    AuthItem save(AuthItem authItem);

    AuthItem update(AuthItem authItem) ;

    void assignApi(AuthItem authItem);
}
