package com.yzxie.demo.java.grpcclient.service;

import com.yzxie.demo.java.grpcclient.grpc.GrpcClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xieyizun
 * @date 18/7/2019 23:33
 * @description:
 */
@Service
public class HelloService {
    private static Logger LOG = LoggerFactory.getLogger(HelloService.class);

    private GrpcClient grpcClient;

    @Autowired
    public HelloService(GrpcClient grpcClient) {
        this.grpcClient = grpcClient;
    }

    public String sayHello(String userName) {
        try {
            return grpcClient.getHello(userName);
        } catch (Exception e) {
            LOG.error("sayHello {}", userName, e);
        }

        return "";
    }
}
