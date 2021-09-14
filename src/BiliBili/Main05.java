package BiliBili;

import java.util.Scanner;

public class Main05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int L = sc.nextInt();
        int N = sc.nextInt();
        for (int i = 1; i <= L; i++){
            if (i % N != 0){
                System.out.println(i);
            }
        }
    }

}
