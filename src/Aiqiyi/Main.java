package Aiqiyi;

import java.util.*;

public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in) ;
//        int totalMonths = sc.nextInt();
//        int a = 1, b = 1, sum;
//        for(int i = 0; i < totalMonths; i++){
//            sum = a + b;
//            a = b;
//            b = sum;
//        }
//        System.out.println(a);
//
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt();
        int[] ischecked = new int[n];
        // 未签到数
        int unchecked_num = 0;
        for (int i = 0; i < n; i++){
            int x = sc.nextInt();
            if (x == 0){
                unchecked_num ++;
            }
            ischecked[i] = x;
        }
        int k = sc.nextInt();
        // 最长连续签到天数
        int maxlen = 0;
        if (unchecked_num <= k){
            maxlen = n;
        }else {
            for (int i = 0; i <= n - unchecked_num; i++){
                if(ischecked[i+k+1] - ischecked[i] - 1 > maxlen)
                    maxlen = ischecked[i+k+1] - ischecked[i] - 1;
            }
        }

        System.out.println(maxlen);
    }
}
