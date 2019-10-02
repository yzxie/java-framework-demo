package com.yzxie.study.java.demo.weatherstarter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Author: xieyizun
 * Version: 1.0
 * Date: 2019-10-02
 * Description:
 **/
@ConfigurationProperties(prefix = "weather.query")
public class WeatherProperties {
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
