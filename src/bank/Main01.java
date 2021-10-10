package bank;
/**
 *
 3
 3
 25
 2

 YES
 YES
 NO
 */

import java.util.Scanner;

public class Main01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            if(fun(sc.nextInt())){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }

    }

    public static boolean fun(long k){

        for (int i = 1; i * i * i < k; i++){
            int xm3 = i * i * i;
            for (int j = 1; j * j * j < k - xm3; j++){
                int ym4 = j * j * j * j;
                int z = (int)Math.pow(k - xm3 - ym4, 1/5);
                if (xm3 + ym4 + (z * z * z) == k ||
                xm3 + ym4 + ((z+1)*(z+1)*(z+1)) == k ||
                xm3 + ym4 + ((z-1)*(z-1)*(z-1)) == k){
                    return true;
                }
            }
        }
        return false;
    }
}
