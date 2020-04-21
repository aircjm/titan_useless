package com.aircjm.titan.service.system.impl;

import com.aircjm.titan.mapper.system.SysConfigMapper;
import com.aircjm.titan.model.system.SysConfig;
import com.aircjm.titan.service.system.SysConfigService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author aircjm
 */
@Service
public class SysConfigServiceImpl implements SysConfigService {


    @Resource
    private SysConfigMapper sysConfigMapper;

    @Override
    public SysConfig getSystemConfigByKey(String key) {
        Wrapper<SysConfig> tWrapper = new QueryWrapper<SysConfig>().lambda().eq(SysConfig::getConfigKey, key).eq(SysConfig::getDeleted, 0);
        return sysConfigMapper.selectOne(tWrapper);
    }
}
