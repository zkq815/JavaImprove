package ACMPractice.ACM1002;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * Created by Administrator on 2017/3/16.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        BigInteger[][] numArray = new BigInteger[t][2];
        for (int i = 0; i < t; i++) {
            int number = 1;
            while (number > 0) {
                numArray[i][0] = scanner.nextBigInteger();
                numArray[i][1] = scanner.nextBigInteger();
                number--;
            }
        }
        for (int i = 0; i < numArray.length; i++) {
            System.out.println("Case " + (i + 1) + ":");
            System.out.println(numArray[i][0] + " + " + numArray[i][1] + " = " + (numArray[i][0].add(numArray[i][1])));
            if (i!=numArray.length-1)
                System.out.println();
        }
    }
}
