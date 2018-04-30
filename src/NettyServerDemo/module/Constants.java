package NettyServerDemo.module;

/**
 * 消息基本信息
 *
 * @author zkq
 * @version 2017/12/11 14:11
 */
public class Constants {
    private static String clientId;

    public static String getClientId() {
        return clientId;
    }

    public static void setClientId(String clientId) {
        Constants.clientId = clientId;
    }
}
