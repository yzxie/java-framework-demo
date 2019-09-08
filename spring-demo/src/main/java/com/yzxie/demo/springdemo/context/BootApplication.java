package com.yzxie.demo.springdemo.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Author: xieyizun
 * Version: 1.0
 * Date: 2019-08-03
 * Description:
 **/

public class BootApplication {

    public static void main(String[] args) {
        // IOC容器对象
        AnnotationConfigApplicationContext iocContainer = new AnnotationConfigApplicationContext();
        // Java类配置
        iocContainer.register(ApplicationConfig.class);
        // 创建IOC容器与初始化IOC容器
        iocContainer.refresh();

        // 验证IOC容器对Java对象的创建与依赖注入
        ObjectA objectA = iocContainer.getBean(ObjectA.class);
        System.out.println("ObjectB's name is " + objectA.getObjectB().getName());
    }
}
