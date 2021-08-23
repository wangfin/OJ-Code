package Meituan;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution2 {
    // 小美当会计
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        ArrayList<int[]> opts = new ArrayList<>();
        for (int i = 0; i < m; i++){
            int[] op = new int[]{sc.nextInt(), sc.nextInt(), sc.nextInt()};
            opts.add(op);
        }
        for(int i = 0; i < opts.size(); i ++){
            // 遍历操作
            int opt = opts.get(i)[0];
            int L = opts.get(i)[1] - 1;
            int R = opts.get(i)[2];
            if (opt == 1){
                // 求和
                int sum = 0;
                for (int j = L; j < R; j++){
                    sum += a[j];
                }
                System.out.println(sum);
            }else if (opt == 2){
                // 有效值
                int sum = 0;
                for (int j = L; j < R; j++){
                    sum += a[j];
                }
                int res = 0;
                for (int j = L; j < R; j++){
                    res += Math.pow(sum-a[j], 2);
                }
                System.out.println(res);

            }else if (opt == 3){
                // 最大值
                int max = Integer.MIN_VALUE;
                for (int j = L; j < R; j++){
                    if (a[j] > max){
                        max = a[j];
                    }
                }
                System.out.println(max);
            }
        }

    }
}
