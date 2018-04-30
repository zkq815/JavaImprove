package ACMPractice.ACM1000;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/3/16.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a+b);
        }
    }
}
