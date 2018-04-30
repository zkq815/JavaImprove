package NettyServerDemo.module;

/**
 * 心跳检测消息类型
 *
 * @author zkq
 * @version 2017/12/11 14:11
 */
public class PingMsg extends BaseMsg {
    public PingMsg() {
        super();
        setType(MsgType.PING);
    }
}
