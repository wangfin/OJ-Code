package bank;

import java.util.Scanner;

public class Main03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] B = new int[n];
        for (int i = 0; i < n ; i++){
            B[i] = sc.nextInt();
        }
        int[] res = new int[n];
        res[0] = B[0];

        for (int i = 1; i < n; i++){
            if (i % 2 == 1){
                res[i] = 0-(B[i]-B[i-1]);
            }else{
                res[i] = B[i]-B[i-1];
            }
        }
        String s = "";
        for (int i = 0; i < n; i++){
            s += res[i] + " ";
        }

        System.out.println(s.substring(0, s.length() - 1));
    }
}
