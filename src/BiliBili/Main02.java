package BiliBili;

import java.util.*;

public class Main02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String[] ss = s.substring(1, s.length()-1).split(",");
        int[] nums = new int[ss.length];
        for (int i = 0; i < ss.length; i++){
            nums[i] = Integer.parseInt(ss[i]);
        }

        int max1, max2, min1, min2;
        max1 = min2 = Math.max(nums[0], nums[1]);
        min1 = max2 = Math.min(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++){
            if(nums[i] > max1){
                max2 = max1;
                max1 = nums[i];
            }else if(nums[i] > max2){
                max2 = nums[i];
            }

            if (nums[i] < min1){
                min2 = min1;
                min1 = nums[i];
            }else if(nums[i] < min2){
                min2 = nums[i];
            }

        }

        System.out.println(max1 * max2 - min1 * min2);

    }
}
