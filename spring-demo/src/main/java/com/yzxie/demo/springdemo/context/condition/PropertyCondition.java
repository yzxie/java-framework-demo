package com.yzxie.demo.springdemo.context.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Author: xieyizun
 * Version: 1.0
 * Date: 2019-09-28
 * Description:
 **/
public class PropertyCondition implements Condition {
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment environment = context.getEnvironment();
        if (environment.getProperty("property.test") != null) {
            return true;
        }
        return false;
    }
}
