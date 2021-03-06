package com.yzxie.demo.springdemo.context;

import com.yzxie.demo.springdemo.context.condition.ConditionConfig;
import com.yzxie.demo.springdemo.context.xml.DemoModel;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Service;

/**
 * Author: xieyizun
 * Version: 1.0
 * Date: 2019-08-03
 * Description:
 **/
@Configuration // 相对于 <beans> 标签
@ComponentScan(basePackages = "com.yzxie.demo.springdemo.context", useDefaultFilters = false,
    includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Service.class})
    }) // 相当于 <context:component-scan /> 标签
@PropertySource("classpath:application.properties")
@Import(ConditionConfig.class)
public class ApplicationConfig {

    @Bean // 相当于 <bean> 标签
    public DemoModel demoModel() {
        DemoModel demoModel = new DemoModel();
        demoModel.setName("xyz");
        return demoModel;
    }
}
