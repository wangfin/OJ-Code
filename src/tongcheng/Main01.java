package tongcheng;

import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        int n = s1.length();
        int m = s2.length();
        int[][] d = new int[n+1][m+1];
        char ch1, ch2;
        int temp;
        if (n == 0 || m == 0){
            System.out.println(0);
        }
        for (int i = 0; i <= n; i++){
            d[i][0] = i;
        }
        for (int j = 0; j <= m; j++){
            d[0][j] = j;
        }

        for (int i = 1; i <= n; i++){
            ch1 = s1.charAt(i-1);
            // 匹配
            for (int j = 1; j <= m; j++){
                ch2 = s2.charAt(j-1);
                if (ch1 == ch2 || ch1 == ch2 + 32 || ch1 + 32 == ch2){
                    temp = 0;
                }else{
                    temp = 1;
                }
                d[i][j] = Math.min(Math.min(d[i-1][j]+1, d[i][j-1]+1), d[i-1][j-1] + temp);
            }
        }

        System.out.println((1 - (float)d[n][m] / Math.max(s1.length(), s2.length())));


    }
}
