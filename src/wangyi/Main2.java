package wangyi;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        String SS = sc.nextLine();
//        String S = SS.split(" ")[0];
//        int m = Integer.parseInt(SS.split(" ")[1]);
        String S = sc.next();
        int m = sc.nextInt();
        // 找到连续m个需要操作最多的操作
        int[] opts = new int[S.length()];
        // 需要操作数
        for (int i = 1; i < S.length(); i++){
            // 向右走
            int right = Math.abs(S.charAt(i) - S.charAt(i-1));
            // 向左走
            int left = 26 - right;
            opts[i] = Math.min(left, right);
        }


        int opt = 0;
        for (int i = 0; i < m; i ++){
            opt += opts[i+1];
        }
        int max_opt = opt;

        for (int i = 2; i < opts.length - m; i++){
            opt = opt - opts[i - 1] + opts[i + m];

            if (opt >= max_opt){
                max_opt = opt;
            }
        }


        int sum_opt = 0;
        for (int i = 1; i < opts.length; i++){
            sum_opt += opts[i];
        }
        // 无魔法操作
        int no_m = sum_opt + S.length();
        // 有魔法操作
        int with_m = sum_opt - max_opt + m + S.length();

        int res = Math.min(no_m, with_m);

        System.out.println(res);


    }
}
