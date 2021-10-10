package wangyi;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = Integer.parseInt(s);
        String n_b = Integer.toBinaryString(n);
        int res = 0;
        for (int i = 0; i < n_b.length(); i++){
            if (n_b.charAt(i) == '1'){
                res++;
            }
        }

        System.out.println(res);
    }
}
