package com.yzxie.study.java.springbootdemo.controller;

import com.yzxie.study.java.springbootdemo.service.MyPropertiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: xieyizun
 * Version: 1.0
 * Date: 2019-10-02
 * Description:
 **/
@RestController
@RequestMapping("/properties")
public class MyPropertiesController {

    @Autowired
    private MyPropertiesService myPropertiesService;

    @GetMapping("/my-key")
    public String getMyKey() {
        return myPropertiesService.getMyValue();
    }
}
