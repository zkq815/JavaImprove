package ACMPractice.ACM1001;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/3/16.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a =0,sum = 0;
        while (in.hasNextInt()) {
            a = in.nextInt();
            for (int i = 1; i <= a; i++) {
                sum += i;
            }
            System.out.println(sum);
            System.out.println();
            sum=0;
        }
    }
}
