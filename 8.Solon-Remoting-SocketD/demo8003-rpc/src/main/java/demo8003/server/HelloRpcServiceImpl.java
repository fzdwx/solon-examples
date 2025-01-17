package demo8003.server;

import demo8003.service.HelloRpcService;
import demo8003.service.NameRpcService;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.annotation.Remoting;
import org.noear.solon.annotation.Socket;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.MethodType;
import org.noear.solon.socketd.SocketD;

@Mapping(value = "/demoe/rpc", method = MethodType.SOCKET)
@Remoting
public class HelloRpcServiceImpl implements HelloRpcService {
    //@Socket
    public String hello(String name) {
        //
        //[服务端] 调用 [客户端] 的 rpc
        //
        NameRpcService rpc = SocketD.create(Context.current(), NameRpcService.class);
        name = rpc.name(name);

        return "name=" + name;
    }
}
