package com.aircjm.titan.service.auth;

import com.aircjm.titan.model.auth.AuthGroup;
import com.aircjm.titan.model.params.QueryParam;

import java.util.List;

/**
 * @author haseochen
 */
public interface AuthGroupService {

    /**
     * @param param 查询参数
     * @return List<AuthGroup>
     */
    List<AuthGroup> getGroupList(QueryParam param);
}
