package com.aircjm.titan.service.auth.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.aircjm.titan.mapper.auth.AuthRelRoleApiMapper;
import com.aircjm.titan.model.auth.AuthRelRoleApi;
import com.aircjm.titan.service.auth.AuthRelRoleApiService;
import org.springframework.stereotype.Service;

/**
 * @author haseochen
 */
@Service
public class AuthRelRoleApiServiceImpl extends ServiceImpl<AuthRelRoleApiMapper, AuthRelRoleApi> implements AuthRelRoleApiService {
}
