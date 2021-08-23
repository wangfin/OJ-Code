package Aiqiyi;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        ArrayList<String> arrayList = new ArrayList<>();
        while (sc.hasNext()){
            String str = sc.next();
            String[] nums = str.split(",");
            if (nums.length <= 1){
                System.out.println(0);
            }else{
                int last = Integer.valueOf(nums[1]) - Integer.valueOf(nums[0]);
                int ans = Math.abs(last);
                int tmp = last;
                for (int i = 2; i < nums.length; i++){
                    int a = Integer.valueOf(nums[i-0]) - Integer.valueOf(nums[i-1]);

                    if (last * a >= 0){
                        tmp += Math.abs(a);
                    }else{
                        tmp = a;
                        last = a;
                    }

                    if (a != 0 && last == 0){
                        last = a;
                    }

                    ans = Math.max(ans, tmp);
                }
                System.out.println(ans);
            }
        }
    }
}
