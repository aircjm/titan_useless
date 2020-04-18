package com.aircjm.titan.service.auth.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.aircjm.titan.mapper.auth.AuthRelRoleItemMapper;
import com.aircjm.titan.model.auth.AuthRelRoleItem;
import com.aircjm.titan.service.auth.AuthRelRoleItemService;
import org.springframework.stereotype.Service;

/**
 * @author haseochen
 */
@Service
public class AuthRelRoleItemServiceImpl extends ServiceImpl<AuthRelRoleItemMapper, AuthRelRoleItem> implements AuthRelRoleItemService {
}
