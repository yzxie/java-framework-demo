namespace java com.yzxie.demo.java.thrift.api
service RpcHelloService {
    // 返回Hello, userName
    string getHello(1:string userName)
}
