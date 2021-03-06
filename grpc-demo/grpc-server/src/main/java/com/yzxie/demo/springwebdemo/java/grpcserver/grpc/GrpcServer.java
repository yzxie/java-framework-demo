package com.yzxie.demo.springwebdemo.java.grpcserver.grpc;

import com.yzxie.demo.springwebdemo.java.grpcserver.service.RpcHelloServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author xieyizun
 * @date 18/7/2019 23:12
 * @description:
 */
@Component
public class GrpcServer {
    private static Logger LOG = LoggerFactory.getLogger(GrpcServer.class);

    // @Value在构造函数之后处理，故不能在构造函数内部使用port
    @Value("${grpc.port}")
    private int port;
    private RpcHelloServiceImpl rpcHelloService;

    private Server server;

    @Autowired
    public GrpcServer(RpcHelloServiceImpl rpcHelloServiceImpl) {
        this.rpcHelloService = rpcHelloServiceImpl;
    }

    @PostConstruct
    public void init() {
        // 指定监听端口和RPC服务的业务逻辑实现类rpcHelloService
        server = ServerBuilder.forPort(port).addService(rpcHelloService).build();
    }

    // 开启在指定端口监听Grpc客户端的RPC方法调用请求
    public void start() {
        try {
            server.start();
            LOG.info("GrpcServer listen on {}", port);
            server.awaitTermination();
        } catch (Exception e) {
            LOG.error("GrpcServer listen on {}", port, e);
        }

        // 关闭回调hook
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                LOG.info("GrpcServer shutdown {}", port);
                GrpcServer.this.stop();
            }
        });
    }

    public void stop() {
        server.shutdown();
    }

}
