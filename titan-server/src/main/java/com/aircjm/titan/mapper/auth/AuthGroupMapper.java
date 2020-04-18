package com.aircjm.titan.mapper.auth;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.aircjm.titan.model.auth.AuthGroup;
import com.aircjm.titan.model.params.QueryParam;

import java.util.List;

/**
 *
 * @author aircjm
 * @since 2017/7/12 21:34
 */
public interface AuthGroupMapper extends BaseMapper<AuthGroup> {

    /**
     * @param param
     * @return
     */
    List<AuthGroup> queryByParam(QueryParam param);

}
