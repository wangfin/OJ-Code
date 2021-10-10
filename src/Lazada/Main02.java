package Lazada;

import java.util.Scanner;

public class Main02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int M = sc.nextInt();
            for (int i = 0 ; i < M; i++){
                int L = sc.nextInt();
                int R = sc.nextInt();
                System.out.println(calPrimeNum(L, R));
            }
        }
    }

    public static int calPrimeNum(int start, int end){
        int res = 0;
        // 有多少数字整除，包括1和本身
        // int state = 0;
        boolean flag = false;
        // 循环
        for (int i = start; i <= end; i++){
            // 从i到0依次取余
            for (int j = i; j > 0; j--){
                // 判断是否除1和本身外有其他的数字能整除
                if (i % j == 0 && j > 1 && j < i){
                    flag = true;
                    break;
                }
            }
            if (flag){
                // 清空状态，用于下一个数的判断。注：不清空会影响后面程序的运行结果
                flag = false;
            }else{
                res++;
            }
        }

        if (start == 1){
            res--;
        }

        return res;
    }




}
