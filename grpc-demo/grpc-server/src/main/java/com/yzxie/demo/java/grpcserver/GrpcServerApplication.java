package com.yzxie.demo.java.grpcserver;

import com.yzxie.demo.java.grpcserver.grpc.GrpcServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource({"grpc.properties"})
public class GrpcServerApplication {

    public static void main(String[] args) {
        ApplicationContext iocContainer = SpringApplication.run(GrpcServerApplication.class, args);
        GrpcServer grpcServer = iocContainer.getBean(GrpcServer.class);
        grpcServer.start();
    }
}
