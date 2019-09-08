package com.yzxie.study.java.springbootautoconfiguredemo.controller;

import com.yzxie.study.java.springbootautoconfiguredemo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Author: xieyizun
 * Version: 1.0
 * Date: 2019-09-08
 * Description:
 **/
@Controller("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/redis", method = RequestMethod.GET)
    @ResponseBody
    public String testRedis(@RequestParam String redisKey) {
        return testService.getRedisStrValue(redisKey);
    }
}
