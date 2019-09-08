package com.yzxie.demo.springwebdemo.java.grpcserver.service;

import com.yzxie.demo.java.grpc.rpc.HelloRequest;
import com.yzxie.demo.java.grpc.rpc.HelloResponse;
import com.yzxie.demo.java.grpc.rpc.RpcHelloServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Component;

/**
 * @author xieyizun
 * @date 18/7/2019 23:18
 * @description: https://grpc.io/docs/tutorials/basic/java/
 */
@Component
public class RpcHelloServiceImpl extends RpcHelloServiceGrpc.RpcHelloServiceImplBase {

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        HelloResponse response = HelloResponse.newBuilder()
                .setMessage("Hello, " + request.getUserName())
                .build();
        // 响应RPC客户端的RPC调用请求
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
