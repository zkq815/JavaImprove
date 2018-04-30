package DesignPattern.TemplatePattern;

/**
 * Created by zkq on 2017/2/1.
 */
public class Tea extends Muban {

    @Override
    protected void brew() {
        System.out.println("将水冷到80度，冲泡茶叶");
    }

    @Override
    protected void addThings() {
        System.out.println("加入两个小番茄");
    }

    @Override
    protected boolean isNeeded() {
        return false;
    }
}
