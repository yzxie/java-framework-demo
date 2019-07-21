package com.yzxie.demo.java.thriftclient.thrift;

import com.yzxie.demo.java.thrift.api.RpcHelloService;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.*;

/**
 * @author xieyizun
 * @date 18/7/2019 15:37
 * @description:
 */
public class ThriftClientWrapper {

    private TTransport tTransport;
    private RpcHelloService.Client helloClient;

    public void init(String host, int port){
        // 指定需要连接的thrift服务端的域名host与port来创建对应的通信socket
        tTransport = new TFramedTransport(new TSocket(host, port));
        // RPC服务调用代理
        helloClient = new RpcHelloService.Client(new TBinaryProtocol(tTransport));
    }

    public void open() throws TTransportException {
        // 建立socket连接
        this.tTransport.open();
    }

    public void close() {
        // 关闭socket连接
        this.tTransport.close();
    }

    // 业务方法调用该方法获取RPC服务调用代理对象来发起RPC方法调用请求
    public RpcHelloService.Client getHelloClient() {
        return this.helloClient;
    }
}
