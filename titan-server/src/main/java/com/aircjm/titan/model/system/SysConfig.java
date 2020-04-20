package com.aircjm.titan.model.system;

import com.aircjm.titan.model.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 参数配置属性 model
 *
 * @author aircjm
 */
@EqualsAndHashCode(callSuper = false)
@Data
@Accessors(chain = true)
public class SysConfig extends BaseEntity<SysConfig> {

    /**
     * 参数主键
     */
    @TableId
    private Long id;

    /**
     * 参数名称
     */
    private String configName;

    /**
     * 参数键名
     */
    private String configKey;

    /**
     * 参数键值
     */
    private String configValue;

    /**
     * 系统内置（Y是 N否）
     */
    private Integer configType;


}
