package DesignPattern.TemplatePattern;

/**
 * Created by zkq on 2017/2/1.
 */
public class Main {
    public static void main(String[] args){
        Cofe cofe = new Cofe();
        cofe.allStep();
        System.out.println("------------------------");
        Tea tea = new Tea();
        tea.allStep();
    }
}
