package com.aircjm.titan.mapper.auth;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.aircjm.titan.model.auth.User;
import com.aircjm.titan.model.params.QueryParam;
import org.apache.ibatis.annotations.Param;

/**
 * User Mapper
 *
 * @author aircjm
 * @since 2017/7/12 21:34
 */
public interface UserMapper extends BaseMapper<User> {

    IPage<User> queryByParam(@Param("pg") Page<User> page, @Param("queryParam") QueryParam queryParam);

}
