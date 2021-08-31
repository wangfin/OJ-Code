package Shenxinfu;

import java.util.Arrays;

public class Solution1 {
    public int[] nearestDiff (int[] nums) {
        int[] res = new int[nums.length];
        // write code here
        for (int i = 0; i < nums.length; i++){
            int x = i;
            int y = i;
            int x_val, y_val;
            while(x >= 0){
                if (nums[x] < nums[i]){
                    break;
                }else{
                    x --;
                }
            }
            if (x >= 0){
                x_val = nums[x];
            }else{
                x_val = 0;
            }
            while (y <= nums.length - 1){
                if (nums[y] > nums[i]){
                    break;
                }else{
                    y ++;
                }
            }
            if (y <= nums.length - 1){
                y_val = nums[y];
            }else{
                y_val = 0;
            }

            res[i] = y_val - x_val;

        }
        return res;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        int[] res = new Solution1().nearestDiff(nums);
        System.out.println(Arrays.toString(res));
    }
}
