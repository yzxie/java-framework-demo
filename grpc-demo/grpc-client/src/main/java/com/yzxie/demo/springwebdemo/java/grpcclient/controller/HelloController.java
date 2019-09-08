package com.yzxie.demo.springwebdemo.java.grpcclient.controller;

import com.yzxie.demo.springwebdemo.java.grpcclient.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xieyizun
 * @date 18/7/2019 23:32
 * @description:
 */

@RestController
public class HelloController {

    private HelloService helloService;

    @Autowired
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public String hello(@RequestParam String userName) {
        return helloService.sayHello(userName);
    }
}
