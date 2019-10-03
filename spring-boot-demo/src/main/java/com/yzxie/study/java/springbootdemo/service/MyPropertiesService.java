package com.yzxie.study.java.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 * Author: xieyizun
 * Version: 1.0
 * Date: 2019-10-02
 * Description:
 **/
@Service
public class MyPropertiesService {

    @Value("${my-key}")
    private String myValue;

    @Autowired
    private Environment environment;

    public String getMyValue() {
        return "my-properties: " + myValue + ", custom value: " + environment.getProperty("my-custom-key");
    }

    public String getMyValue2() {
        return environment.getProperty("my-key");
    }
}
