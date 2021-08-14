package Ali05;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    /**
     * 第二题
     */

    static int[] res;
    static void f(int n, int x){
        long mod = n % x;
        for (int i = 0; i < mod; i++){
            res[n-1-i] += 1;
        }
    }
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        BigInteger n = scanner.nextBigInteger();
//        int l = scanner.nextInt();
//        int r = scanner.nextInt();
//        res = new int[n];
//
//        for (int i = l; i <= r; i++){
//            f(n, i);
//        }
//        System.out.println(Arrays.toString(res));
//    }
}
