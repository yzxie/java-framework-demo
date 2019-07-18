package com.yzxie.demo.java.thriftclient.thrift;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xieyizun
 * @date 18/7/2019 16:34
 * @description:
 */
@Configuration
public class ThriftClientConfig {

    @Value("${thrift.serverHost}")
    private String host;

    @Value("${thrift.serverPort}")
    private int port;

    @Bean
    public ThriftClientWrapper thriftClient() {
        ThriftClientWrapper thriftClientWrapper = new ThriftClientWrapper();
        thriftClientWrapper.init(host, port);
        return thriftClientWrapper;
    }
}
