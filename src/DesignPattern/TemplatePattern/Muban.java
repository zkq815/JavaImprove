package DesignPattern.TemplatePattern;

/**
 * Created by zkq on 2017/2/1.
 */
public abstract class Muban {

    public final void allStep(){

        boilWater();
        brew();
        pourInCup();
        if(isNeeded()){
            addThings();
        }

    }

    private void boilWater(){
        System.out.println("将水煮沸");
    }

    protected abstract void brew();

    private void pourInCup(){
        System.out.println("将饮料倒入杯中");
    }

    protected abstract void addThings();

    protected boolean isNeeded(){
        return true;
    }
}
