package NettyServerDemo;

import io.netty.channel.socket.SocketChannel;
import org.netty.module.PushMsg;

/**
 * netty推送服务端
 *
 * @author zkq
 * @version 2017/12/11 14:11
 */
public class PushServer {

    public static void start(){
        try {
            new NettyServerBootstrap(9999);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }

    public static void push(){
        for (int i = 0; i < 2; i++) {
            SocketChannel channel = (SocketChannel) NettyChannelMap.get("00"+(i+1));
            if (channel != null) {
                PushMsg pushMsg = new PushMsg();
                pushMsg.setTitle("这是推送的标题！");
                pushMsg.setContent("这是推送的内容！");
                channel.writeAndFlush(pushMsg);
            }
        }

    }
}
