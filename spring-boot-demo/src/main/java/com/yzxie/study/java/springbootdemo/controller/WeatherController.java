package com.yzxie.study.java.springbootdemo.controller;

import com.yzxie.study.java.demo.weatherstarter.WeatherTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Author: xieyizun
 * Version: 1.0
 * Date: 2019-09-30
 * Description:
 **/
@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherTemplate weatherTemplate;

    @GetMapping("/query")
    public String query(@RequestParam("areaCode") String areaCode) {
        return weatherTemplate.query(areaCode);
    }
}
