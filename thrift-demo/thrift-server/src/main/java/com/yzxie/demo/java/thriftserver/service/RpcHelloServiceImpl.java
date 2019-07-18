package com.yzxie.demo.java.thriftserver.service;

import com.yzxie.demo.java.thrift.api.RpcHelloService;
import org.apache.thrift.TException;
import org.springframework.stereotype.Component;

/**
 * @author xieyizun
 * @date 18/7/2019 15:21
 * @description:
 */
@Component
public class RpcHelloServiceImpl implements RpcHelloService.Iface {

    @Override
    public String getHello(String userName) throws TException {
        return "Hello, " + userName;
    }
}
