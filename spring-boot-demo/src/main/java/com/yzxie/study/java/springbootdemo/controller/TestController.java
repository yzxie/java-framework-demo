package com.yzxie.study.java.springbootdemo.controller;

import com.yzxie.study.java.springbootdemo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Author: xieyizun
 * Version: 1.0
 * Date: 2019-09-08
 * Description:
 **/
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/redis", method = RequestMethod.GET)
    @ResponseBody
    public String testRedis(@RequestParam String redisKey) {
        return testService.getRedisStrValue(redisKey);
    }
}
