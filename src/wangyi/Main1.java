package wangyi;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nn = n;
        ArrayList<Integer> arr = new ArrayList<>();
        while (n != 0){
            arr.add(n % 10);
            n = n / 10;
        }
        int res = 0;
        for (int i = 0; i < arr.size(); i++){
            // 被除数不=0
            if (arr.get(i) != 0){
                if (nn % arr.get(i) == 0){
                    res++;
                }
            }
        }

        System.out.println(res);

    }
}
