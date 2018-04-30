package NettyServerDemo;

import org.netty.module.BaseMsg;
import org.netty.module.LoginMsg;
import org.netty.module.MsgType;
import org.netty.module.PingMsg;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.SocketChannel;
import io.netty.util.ReferenceCountUtil;

/**
 * @author zkq
 * @version 2017/12/11 14:11
 */
public class NettyServerHandler extends SimpleChannelInboundHandler<BaseMsg> {

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        //channel失效，从Map中移除
        NettyChannelMap.remove((SocketChannel) ctx.channel());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        System.out.println("服务器端出现异常！");
    }

    //这里是从客户端过来的消息
    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, BaseMsg baseMsg) throws Exception {
        if (MsgType.LOGIN.equals(baseMsg.getType())) {
            LoginMsg loginMsg = (LoginMsg) baseMsg;
            if (isLogin(loginMsg)) {
                //登录成功,把channel存到服务端的map中
                NettyChannelMap.add(loginMsg.getClientId(), (SocketChannel) channelHandlerContext.channel());
                System.out.println("client" + loginMsg.getClientId() + " 登录成功");
            }
        } else {
            if (NettyChannelMap.get(baseMsg.getClientId()) == null) {
                //说明未登录，或者连接断了，服务器向客户端发起登录请求，让客户端重新登录
                LoginMsg loginMsg = new LoginMsg();
                channelHandlerContext.channel().writeAndFlush(loginMsg);
            }
        }
        switch (baseMsg.getType()) {
            case PING:
                PingMsg pingMsg = (PingMsg) baseMsg;
                PingMsg replyPing = new PingMsg();
                NettyChannelMap.get(pingMsg.getClientId()).writeAndFlush(replyPing);
                System.out.println("收到PING类型");
                break;
            case LOGIN:
                break;
            case PUSH:
                break;
            default:
                System.out.println("default。。");
                break;
        }
        ReferenceCountUtil.release(baseMsg);
    }

    private boolean isLogin(LoginMsg loginMsg) {
        String[] userNames = new String[]{"test1", "test2", "test3"};
        String[] passwords = new String[]{"test1", "test2", "test3"};
        for (int i = 0; i < userNames.length; i++) {
            try {
                if (userNames[i].equals(loginMsg.getUserName()) && passwords[i].equals(loginMsg.getPassword())) {
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return false;
    }
}