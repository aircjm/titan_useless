package com.aircjm.titan.mapper.auth;

import com.aircjm.titan.vo.response.GroupInfoResponse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.aircjm.titan.model.auth.AuthRole;
import com.aircjm.titan.model.params.QueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 *
 * @author aircjm
 * @since 2017/7/12 21:34
 */
public interface AuthRoleMapper extends BaseMapper<AuthRole> {


    /**
     * 查询 role 列表
     * @param page
     * @param queryParam
     * @return
     */
    IPage<AuthRole> queryByParam(@Param("pg") Page<AuthRole> page, @Param("queryParam") QueryParam queryParam);



    List<GroupInfoResponse> getGroupInfo(@Param(value = "userId") Integer userId, @Param(value = "projectType") String projectType);

}
