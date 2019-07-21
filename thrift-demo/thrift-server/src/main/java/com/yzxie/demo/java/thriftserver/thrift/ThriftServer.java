package com.yzxie.demo.java.thriftserver.thrift;

import com.yzxie.demo.java.thrift.api.RpcHelloService;
import com.yzxie.demo.java.thriftserver.service.RpcHelloServiceImpl;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author xieyizun
 * @date 18/7/2019 15:36
 * @description:
 */
@Component
public class ThriftServer {

    private Logger LOG = LoggerFactory.getLogger(ThriftServer.class);

    @Value("${thrift.port}")
    private int port;

    private RpcHelloServiceImpl rpcHelloService;

    @Autowired
    public ThriftServer(RpcHelloServiceImpl rpcHelloServiceImpl) {
        this.rpcHelloService = rpcHelloServiceImpl;
    }

    public void start() {
        try {
            // 非阻塞NIO通信
            TNonblockingServerTransport serverTransport = new TNonblockingServerSocket(port);
            // 参数设置
            TNonblockingServer.Args serverArgs = new TNonblockingServer.Args(serverTransport);
            serverArgs.protocolFactory(new TBinaryProtocol.Factory());
            // 可以不指定，TNonblockingServer默认为TFramedTransport
            serverArgs.transportFactory(new TFramedTransport.Factory());

            // RPC请求处理器，需要指定提供RPC方法的服务类对象
            RpcHelloService.Processor processor = new RpcHelloService.Processor<RpcHelloService.Iface>(rpcHelloService);
            serverArgs.processor(processor);
            // NIO服务器监听thrift客户端的连接请求和后续的RPC方法调用请求
            TNonblockingServer server = new TNonblockingServer(serverArgs);
            LOG.info("TNonblockingServer listen on: {}", port);
            // 阻塞等待客户端连接到来
            server.serve();
        } catch (Exception e) {
            LOG.error("start {}", port, e);
        }
    }
}
