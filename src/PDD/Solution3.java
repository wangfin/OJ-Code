package PDD;

import java.util.Scanner;

public class Solution3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nums = sc.nextInt();
        for (int i = 0; i < nums; i++){
            System.out.println(cnt(sc.nextInt()));
        }
    }

    public static int cnt(int m){
        // i*(j-1) + (i-1)*j
        int x = 1, y = 1;
        int max_num = Integer.MIN_VALUE;
        for (int i = 1; i < (int)Math.sqrt(m); i++){
            int j = 1;
            while (true){
                int num = i*(j-1) + (i-1)*j;
                if (max_num > m){
                    break;
                }
                if (num > max_num){
                    max_num = num;
                    y = j;
                }
                j++;
            }
//            while (num <= m && num > max_num){
//                j ++;
//                max_num = num;
//            }

        }

        return (x-1) * (y-1);
    }
}
