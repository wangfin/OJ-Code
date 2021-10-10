package qunaer;

import java.util.Arrays;

public class Solution2 {
    public int solution(int[] arr) {
        int len = arr.length;
        Arrays.sort(arr);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++){
            int num = 1;
            int sum = 0;
            for (int j = i; j < len; j++){
                sum += arr[j] * num;
                num++;
            }

            if (sum >= max){
                max = sum;
            }

        }

        return max;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{-1,1,4,-9,-8};
        int res = new Solution2().solution(nums);
        System.out.println(res);
    }

}
