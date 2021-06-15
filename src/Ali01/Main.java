package Ali01;

import java.util.Arrays;
import java.util.Scanner;

public class Main{
    /**
     * 贪心
     * 求载重最大的和最小的差，并让差最小，平均分配
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;

        int n = sc.nextInt();
        int[] a = new int[2*n];
        for (int i = 0; i < 2*n; i ++){
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        int[] res = new int[n+1];
        res[0] = a[2*n-1];
        res[1] = a[2*n-2];
        for (int i = 2; i < n+1; i ++){
            res[i] = a[i-2] + a[2*n-1-i];
        }

        Arrays.sort(res);
        System.out.println(res[n] - res[0]);
    }

}
