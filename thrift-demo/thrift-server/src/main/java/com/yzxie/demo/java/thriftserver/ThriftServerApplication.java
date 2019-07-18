package com.yzxie.demo.java.thriftserver;

import com.yzxie.demo.java.thriftserver.thrift.ThriftServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource({"thrift.properties"})
public class ThriftServerApplication {

    public static void main(String[] args) {
        ApplicationContext iocContainer = SpringApplication.run(ThriftServerApplication.class, args);
        ThriftServer thriftServer = iocContainer.getBean(ThriftServer.class);
        thriftServer.start();
    }

}
