package ACMPractice.ACM1003;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/3/16.
 */
public class Main {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int lines = in.nextInt();
//        int templines = lines;
//        System.out.println("行数=" + lines);
//        ArrayList<ArrayList<Integer>> numbers = new ArrayList<ArrayList<Integer>>();
//        ArrayList<Integer> number;
//        for (int i = 0; i < lines; i++) {
//            number = new ArrayList<Integer>();
//            int columns = in.nextInt();
//            System.out.println("列数=" + columns);
//            number.add(columns);
//            if (templines > 0) {
//
//                for (int j = 0; j <columns; j++) {
//                    number.add(in.nextInt());
//                }
//                numbers.add(number);
//            }
//            templines--;
//        }
//
//        for (int i = 0; i < numbers.size(); i++) {
//            for (int j = 0; j < numbers.get(i).size(); j++) {
//                System.out.println("输入的内容==" + numbers.get(i).get(j));
//            }
//        }

        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int i = 0; i < T; i++) {
            int n = s.nextInt();
            int sum = 0, max = -1001;
            int start = 0, end = 0, z = 0;
            for (int j = 0; j < n; j++) {
                int a = s.nextInt();
                sum = sum + a;
                if (max < sum) {
                    max = sum;
                    end = j;
                    start = z;
                }
                if (sum < 0) {
                    sum = 0;
                    z = j + 1;
                }
            }
            System.out.println("Case " + (i + 1) + ":");
            System.out.println(max + " " + (start + 1) + " " + (end + 1));
            if (i < T - 1)
                System.out.println();
        }
    }
}
