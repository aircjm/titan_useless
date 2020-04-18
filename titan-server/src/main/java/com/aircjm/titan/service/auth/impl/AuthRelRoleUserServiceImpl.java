package com.aircjm.titan.service.auth.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.aircjm.titan.mapper.auth.AuthRelRoleUserMapper;
import com.aircjm.titan.model.auth.AuthRelRoleUser;
import com.aircjm.titan.service.auth.AuthRelRoleUserService;
import org.springframework.stereotype.Service;

/**
 * @author haseochen
 */
@Service
public class AuthRelRoleUserServiceImpl extends ServiceImpl<AuthRelRoleUserMapper, AuthRelRoleUser> implements AuthRelRoleUserService {
}
