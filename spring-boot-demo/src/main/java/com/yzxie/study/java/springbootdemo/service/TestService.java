package com.yzxie.study.java.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Author: xieyizun
 * Version: 1.0
 * Date: 2019-09-08
 * Description:
 **/
@Service
public class TestService {

    @Autowired
    private RedisTemplate redisTemplate;

    public String getRedisStrValue(String key) {
        return (String)redisTemplate.opsForValue().get(key);
    }


}
