package com.yzxie.demo.springdemo.context;

import org.springframework.stereotype.Component;

/**
 * Author: xieyizun
 * Version: 1.0
 * Date: 2019-08-03
 * Description:
 **/
@Component
public class ObjectB {
    private String name = "B";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
