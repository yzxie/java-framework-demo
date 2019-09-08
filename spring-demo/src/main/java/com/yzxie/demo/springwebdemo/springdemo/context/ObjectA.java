package com.yzxie.demo.springwebdemo.springdemo.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Author: xieyizun
 * Version: 1.0
 * Date: 2019-08-03
 * Description:
 **/
@Component
public class ObjectA {

    @Autowired
    private ObjectB objectB;

    public ObjectB getObjectB() {
        return objectB;
    }

    public void setObjectB(ObjectB objectB) {
        this.objectB = objectB;
    }
}
