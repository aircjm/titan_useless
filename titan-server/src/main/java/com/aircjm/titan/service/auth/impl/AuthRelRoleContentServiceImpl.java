package com.aircjm.titan.service.auth.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.aircjm.titan.mapper.auth.AuthRelRoleContentMapper;
import com.aircjm.titan.model.auth.AuthRelRoleContent;
import com.aircjm.titan.service.auth.AuthRelRoleContentService;
import org.springframework.stereotype.Service;

/**
 * @author haseochen
 */
@Service
public class AuthRelRoleContentServiceImpl extends ServiceImpl<AuthRelRoleContentMapper, AuthRelRoleContent> implements AuthRelRoleContentService {
}
