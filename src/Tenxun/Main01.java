package Tenxun;

import java.util.Scanner;

public class Main01 {
    public static int judge(int x){
        for (int i = 2; i <= x/i; i++){
            if (x % i == 0){
                return 0;
            }
        }
        return 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0){
            T--;
            int x = sc.nextInt();
            int a = x + 1;
            int b = 2 * x + 1;
            while (judge(a) == 0){
                a++;
                b++;
            }
            while (judge(b) == 0){
                b++;
            }
            int res = a * b;
            System.out.println(res);

        }
    }
}
