package com.yzxie.study.java.demo.weatherstarter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
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
public class WeatherAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public WeatherTemplate weatherTemplate() {
        WeatherTemplate weatherTemplate = new WeatherTemplate();
        return weatherTemplate;
    }
}
