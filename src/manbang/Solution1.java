package manbang;

import java.util.*;

public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        int A = sc.nextInt();
        // 0 - 9
        int B = sc.nextInt();
        int res_num = 0;

        for (int i = 1; i <= A; i++){
            ArrayList<Integer> res = new Solution1().number(i);
            for (int j = 0; j < res.size(); j++){
                if (res.get(j) == B){
                    res_num ++;
                }
            }
        }

        System.out.println(res_num);
    }

    // 将数字拆分成单个数字
    public ArrayList<Integer> number(int num){
        ArrayList<Integer> res = new ArrayList<>();
        while (num != 0){
            int n = num % 10;
            num = num / 10;
            res.add(n);
        }
        return res;
    }
}
