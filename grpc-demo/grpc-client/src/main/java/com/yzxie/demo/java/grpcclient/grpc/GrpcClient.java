package com.yzxie.demo.java.grpcclient.grpc;

import com.yzxie.demo.java.grpc.rpc.HelloRequest;
import com.yzxie.demo.java.grpc.rpc.HelloResponse;
import com.yzxie.demo.java.grpc.rpc.RpcHelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author xieyizun
 * @date 19/7/2019 14:59
 * @description:
 */
@Component
public class GrpcClient {
    private static Logger LOG = LoggerFactory.getLogger(GrpcClient.class);

    @Value("${grpc.serverHost}")
    private String host;

    @Value("${grpc.serverPort}")
    private int port;

    private ManagedChannel channel;
    private RpcHelloServiceGrpc.RpcHelloServiceBlockingStub blockingStub;

//    public GrpcClient() {
//        channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext(true).build();
//        blockingStub = RpcHelloServiceGrpc.newBlockingStub(channel);
//    }

    @PostConstruct
    public void init() {
        channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext(true).build();
        blockingStub = RpcHelloServiceGrpc.newBlockingStub(channel);
    }

    @PreDestroy
    public void destroy() {
        channel.shutdown();
    }

    public String getHello(String userName) {
        try {
            HelloRequest request = HelloRequest.newBuilder().setUserName(userName).build();
            HelloResponse response = blockingStub.sayHello(request);
            return response.getMessage();
        } catch (StatusRuntimeException e) {
            LOG.error("getHello {}", userName, e);
        }

        return "";
    }
}
