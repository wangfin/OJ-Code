package PDD;

import java.util.Arrays;
import java.util.Scanner;

public class Solution1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++){
            // T组数据
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[m];
            for (int i = 0; i < n; i++){
                a[i] = sc.nextInt();
            }
            for (int i = 0; i < m; i++){
                b[i] = sc.nextInt();
            }
            // 贪心，优先满足相差最接近K的
            // 对a和b进行升序排序
            Arrays.sort(a);
            Arrays.sort(b);
            // 尝试了多少的a
            int num_a = 0;
            // 满足了b
            int num_b = 0;

            // a和b的其中一个需要全部尝试完
            while (num_b < b.length && num_a < a.length){
                // 糖果满足孩子的需求
                if (Math.abs(a[num_a] - b[num_b]) <= k){
                    // 满足的孩子数量+1
                    num_b++;
                }
                // 糖果只遍历一遍，无论成功失败
                num_a++;
            }

            System.out.println(num_b);
        }

    }
}
