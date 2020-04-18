package com.aircjm.titan.mapper.auth;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.aircjm.titan.model.auth.AuthClasses;
import java.util.List;

/**
 *
 * @author aircjm
 * @since 2017/7/12 21:34
 */
public interface AuthClassesMapper extends BaseMapper<AuthClasses> {

    /**
     * 通过 GroupId 获取菜单项
     * @param groupId
     * @return
     */
    List<AuthClasses> queryByGroupId(Integer groupId);

}
