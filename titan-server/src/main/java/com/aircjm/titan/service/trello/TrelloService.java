package com.aircjm.titan.service.trello;

import com.julienvey.trello.domain.Member;

/**
 * @author aircjm
 */
public interface TrelloService {

    /**
     * 创建对应的token
     */
    void createMyWebHook();

    /**
     * 获取用户信息
     * @return 用户信息
     */
    Member getMyMemberInfo();

}
