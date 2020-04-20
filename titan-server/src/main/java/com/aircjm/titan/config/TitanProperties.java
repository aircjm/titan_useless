package com.aircjm.titan.config;

import com.aircjm.titan.mapper.system.SysConfigMapper;
import com.aircjm.titan.model.blog.Comment;
import com.aircjm.titan.model.system.SysConfig;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.julienvey.trello.Trello;
import com.julienvey.trello.impl.TrelloImpl;
import com.julienvey.trello.impl.http.ApacheHttpClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Dice configuration properties.
 *
 * @author haseochen
 */
@Data
@ConfigurationProperties("titan")
public class TitanProperties {
    /**
     * Doc api disabled. (Default is true)
     */
    private boolean docDisabled = true;



    @Resource
    private SysConfigMapper sysConfigMapper;


    @Bean
    public Trello getTrelloApi() {
        SysConfig sysConfig = new SysConfig();
        sysConfig.setConfigKey("trello");
        List<SysConfig> trelloConfig = sysConfigMapper.selectList(new QueryWrapper<SysConfig>());
        if (CollectionUtils.isNotEmpty(trelloConfig)) {
            Map<String, String> map = trelloConfig.stream().collect(Collectors.toMap(SysConfig::getConfigKey, SysConfig::getConfigValue));
            return new TrelloImpl(map.get("trello.dev.api.applicationKey"), map.get("trello.dev.api.accessToken"), new ApacheHttpClient());
        } else {
            return new TrelloImpl(null, null, new ApacheHttpClient());
        }
    }

}
