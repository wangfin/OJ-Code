package wangyi;

import java.util.*;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++){
            char[] s = sc.next().toCharArray();
            for (int j = 0; j < n; j++){
                map[i][j] = s[j];
            }
        }

        System.out.println(a);

    }
}
