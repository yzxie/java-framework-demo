package com.yzxie.demo.java.thriftclient.service;

import com.yzxie.demo.java.thriftclient.thrift.ThriftClientWrapper;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xieyizun
 * @date 18/7/2019 16:48
 * @description:
 */
@Service
public class HelloService {
    private static Logger LOG = LoggerFactory.getLogger(HelloService.class);

    private ThriftClientWrapper thriftClient;

    @Autowired
    public HelloService(ThriftClientWrapper thriftClient) {
        this.thriftClient = thriftClient;
    }

    public String sayHello(String userName) {
        try {
            // 建立socket连接
            thriftClient.open();
            // 发起RPC方法调用请求
            return thriftClient.getHelloClient().getHello(userName);
        } catch (TException e) {
            LOG.error("sayHello {}", userName, e);
        } finally {
            // 关闭socket连接
            thriftClient.close();
        }

        return "";
    }
}
