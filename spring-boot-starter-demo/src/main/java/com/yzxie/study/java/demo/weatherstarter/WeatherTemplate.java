package com.yzxie.study.java.demo.weatherstarter;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

/**
 * Author: xieyizun
 * Version: 1.0
 * Date: 2019-09-29
 * Description:
 **/
public class WeatherTemplate {

    /**
     * 国家气象局天气查询接口
     */
    private static String DEFAULT_QUERY_API = "http://www.weather.com.cn/data/cityinfo/";
    private static String WEATHER_QUERY_API_TYPE = ".html";

    private String queryUrl;

    public WeatherTemplate() {
        this.queryUrl = DEFAULT_QUERY_API;
    }

    public WeatherTemplate(String url) {
        this.queryUrl = url;
    }

    /**
     * 根据给定的地区代号，查询天气情况
     * 代号查询：https://www.cnblogs.com/wangjingblogs/p/3192953.html
     * @param areaCode
     * @return
     */
    public String query(String areaCode) {
        String url = queryUrl + areaCode + WEATHER_QUERY_API_TYPE;
        RestTemplate restTemplate=new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        String strbody=restTemplate.exchange(url, HttpMethod.GET, entity,String.class).getBody();
        try {
            // 解决中文乱码问题
            return new String(strbody.getBytes("ISO-8859-1"),"UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        WeatherTemplate weatherTemplate = new WeatherTemplate();
        String str = weatherTemplate.query("101310101");
        System.out.println(str);
    }
}
