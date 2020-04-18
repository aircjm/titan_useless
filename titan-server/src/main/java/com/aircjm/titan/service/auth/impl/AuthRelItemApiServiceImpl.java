package com.aircjm.titan.service.auth.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.aircjm.titan.mapper.auth.AuthRelItemApiMapper;
import com.aircjm.titan.model.auth.AuthRelItemApi;
import com.aircjm.titan.service.auth.AuthRelItemApiService;
import org.springframework.stereotype.Service;

/**
 * @author haseochen
 */
@Service
public class AuthRelItemApiServiceImpl extends ServiceImpl<AuthRelItemApiMapper, AuthRelItemApi> implements AuthRelItemApiService {
}
