package NettyServerDemo.module;

/**
 * 推送消息类型
 *
 * @author zkq
 * @version 2017/12/11 14:11
 */
public class PushMsg extends BaseMsg {

    private String title;
    private String content;

    public PushMsg() {
        super();
        setType(MsgType.PUSH);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
