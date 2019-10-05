package com.yzxie.study.java.demo.weatherstarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: xieyizun
 * Version: 1.0
 * Date: 2019-09-29
 * Description:
 **/
@Configuration
@ConditionalOnClass(WeatherTemplate.class)
// 引入属性配置类 WeatherProperties
@EnableConfigurationProperties(WeatherProperties.class)
public class WeatherAutoConfiguration {

    @Autowired
    private WeatherProperties weatherProperties;

    @Bean
    @ConditionalOnMissingBean
    public WeatherTemplate weatherTemplate() {
        // 如果用户配置了其他API，则使用用户配置的，否则使用默认的。
        WeatherTemplate weatherTemplate = weatherProperties.getUrl()==null ? new WeatherTemplate() :
                new WeatherTemplate(weatherProperties.getUrl());
        return weatherTemplate;
    }
}
