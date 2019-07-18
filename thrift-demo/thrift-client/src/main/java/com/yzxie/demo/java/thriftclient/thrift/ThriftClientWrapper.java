package com.yzxie.demo.java.thriftclient.thrift;

import com.yzxie.demo.java.thrift.api.RpcHelloService;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
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
        tTransport = new TFramedTransport(new TSocket(host, port));
        helloClient = new RpcHelloService.Client(new TBinaryProtocol(tTransport));
    }

    public void open() throws TTransportException {
        this.tTransport.open();
    }

    public void close() {
        this.tTransport.close();
    }

    public RpcHelloService.Client getHelloClient() {
        return this.helloClient;
    }
}
