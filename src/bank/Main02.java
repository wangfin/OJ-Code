package bank;

import java.util.Scanner;

/**
 * 2 2 2 2
 * 1 2
 * -1 3
 * kjljk
 */

public class Main02 {
    public static void main(String[] args) {
        // n, m, x, y
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                map[i][j] = sc.nextInt();
            }
        }
        String options = sc.next();

        int res = 0;
        int i = 0;
        int j = 0;
        Character presignal = options.charAt(0);

        for (int index = 0; index < options.length(); index++) {
            if (options.charAt(index) != presignal) {
                res += x;
            }

            if (options.charAt(index) == 'h') {// 左
                presignal = 'h';
                if (j == 0 || map[i][j-1] == -1) {
                    res += y;
                    break;
                } else {
                    res += Math.max(map[i][j], map[i][j-1]);
                    j--;
                }

            } else if (options.charAt(index) == 'j') {// 下
                presignal = 'j';
                if (i == n-1 || map[i+1][j] == -1) {
                    res += y;
                    break;
                } else {
                    res += Math.max(map[i][j], map[i+1][j]);
                    i++;
                }

            } else if (options.charAt(index) == 'k') {// 上
                presignal = 'k';
                if (i == 0 || map[i-1][j] == -1) {
                    res += y;
                    break;
                } else {
                    res += Math.max(map[i][j], map[i-1][j]);
                    i--;
                }

            } else if (options.charAt(index) == 'l') {// 右
                presignal = 'l';
                if (j == n-1 || map[i][j+1] == -1) {
                    res += y;
                    break;
                } else {
                    res += Math.max(map[i][j], map[i][j+1]);
                    j++;
                }
            }
        }

        System.out.println(res);
    }
}
