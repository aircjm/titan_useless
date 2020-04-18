package com.aircjm.titan.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Dice configuration.
 *
 * @author johnniang
 */
@Configuration
@EnableConfigurationProperties(TitanProperties.class)
@Slf4j
@MapperScan("com.aircjm.titan.mapper")
public class TitanConfiguration {

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
