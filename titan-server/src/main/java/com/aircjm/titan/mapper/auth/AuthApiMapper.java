package com.aircjm.titan.mapper.auth;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.aircjm.titan.model.auth.AuthApi;
import com.aircjm.titan.model.params.QueryParam;
import org.apache.ibatis.annotations.Param;

/**
 * @author aircjm
 * @since 2017/7/12 21:34
 */
public interface AuthApiMapper extends BaseMapper<AuthApi> {

    /**
     * 查询 Api 列表
     * @param page
     * @param queryParam
     * @return
     */
    IPage<AuthApi> queryByParam(@Param("pg") Page<AuthApi> page, @Param("queryParam") QueryParam queryParam);

}
