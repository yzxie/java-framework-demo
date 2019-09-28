package com.yzxie.demo.springdemo.context.condition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Author: xieyizun
 * Version: 1.0
 * Date: 2019-09-28
 * Description:
 **/
@Configuration
@Conditional(PropertyCondition.class)
public class ConditionConfig {

    @Autowired
    private Environment environment;

    @Bean
    public String propertyData() {
        String data = environment.getProperty("property.test");
        return data;
    }
}
