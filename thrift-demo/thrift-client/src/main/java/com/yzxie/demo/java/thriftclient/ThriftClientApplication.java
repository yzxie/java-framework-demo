package com.yzxie.demo.java.thriftclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource({"thrift.properties"})
public class ThriftClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThriftClientApplication.class, args);
    }

}
