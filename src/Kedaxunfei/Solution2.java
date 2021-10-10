package Kedaxunfei;

import java.util.Arrays;

public class Solution2 {
    public int qualifiedQuantity(int k, int target, int[] nums){
        int n = nums.length;
        int[] times = new int[n];
        for (int i = 0; i < n; i ++){
            if (nums[i] == target){
                times[i] = 0;
            }
            if (Math.abs(nums[i] - target) % 2 == 0){
                times[i] = Math.abs(nums[i] - target) / 2;
            }else{
                times[i] = Math.abs(nums[i] - target) / 2 + 1;
            }
        }
        Arrays.sort(times);
        int res = 0;
        for (int i = 0; i < n; i++){
            if (times[i] <= k){
                k = k - times[i];
                res++;
            }
            if (k <= 0){
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int k = 3;
//        int target = 6;
//        int[] nums = new int[]{6,6,6};
//        int res = new Solution2().qualifiedQuantity(k, target, nums);
//        System.out.println(res);

        System.out.println(6/2);

    }

}
