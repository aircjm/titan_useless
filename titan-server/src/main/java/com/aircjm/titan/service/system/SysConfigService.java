package com.aircjm.titan.service.system;

import com.aircjm.titan.model.system.SysConfig;

public interface SysConfigService {


    /**
     * @param key key
     * @return 系统配置
     */
    SysConfig getSystemConfigByKey(String key);


}