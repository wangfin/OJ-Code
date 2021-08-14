package xiecheng;

import java.util.Arrays;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        // 个数
        int n = sc.nextInt();
        // 预期售价和运费
        int[] p = new int[n];
        int[] c = new int[n];
        for (int i = 0; i < n; i++){
            p[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++){
            c[i] = sc.nextInt();
        }
        // 贪心
        int min = Arrays.stream(c).min().getAsInt();
        int max = Arrays.stream(p).min().getAsInt();





    }
}
