package qunaer;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution1 {
    /* 一个正整数的数组 arr，数组满足0 <= arr[i] <= 9，挑出任意个数组成一个最大的数，并且能被3整除，并以字符串形式返回。*/
    public String solution(int[] d) {
        // 如果这个数字能够被3整除，那么他的和肯定能被3整除
        // 所以能够选出能够被3整除数，然后再排列组合
        // 选出最长的和为3的倍数的数字
        int len = d.length;
        int dp[][] = new int[len+1][3];
        Arrays.sort(d);
        int[] d_desc = new int[len];
        for (int i = 0; i < len; i++){
            d_desc[i] = d[len-i-1];
        }
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        dp[0][2] = Integer.MIN_VALUE;
        ArrayList<Integer> index = new ArrayList<>();
        for (int i = 0; i < len; i++){
            if (d[i] % 3 == 0){
//                if (dp[i][0]+d[i] > dp[i][0]){
//                    index.add(d[i]);
//                }
                dp[i+1][0] = Math.max(dp[i][0], dp[i][0]+d[i]);
                dp[i+1][1] = Math.max(dp[i][1], dp[i][1]+d[i]);
                dp[i+1][2] = Math.max(dp[i][2], dp[i][2]+d[i]);
            }else if (d[i] % 3 == 1){
//                if (dp[i][2]+d[i] > dp[i][0]){
//                    index.add(d[i]);
//                }
                dp[i+1][0] = Math.max(dp[i][0], dp[i][2]+d[i]);
                dp[i+1][1] = Math.max(dp[i][1], dp[i][0]+d[i]);
                dp[i+1][2] = Math.max(dp[i][2], dp[i][1]+d[i]);
            }else if (d[i] % 3 == 2){
//                if (dp[i][1]+d[i] > dp[i][0]){
//                    index.add(d[i]);
//                }
                dp[i+1][0] = Math.max(dp[i][0], dp[i][1]+d[i]);
                dp[i+1][1] = Math.max(dp[i][1], dp[i][2]+d[i]);
                dp[i+1][2] = Math.max(dp[i][2], dp[i][0]+d[i]);
            }
        }
        System.out.println(dp[len][0]);
        return "";

//        int[] index_num = new int[index.size()];
//        for (int i = 0; i < index.size(); i++){
//            index_num[i] = index.get(i);
//        }
//        Arrays.sort(index_num);
//        String res = "";
//        for (int i = index_num.length - 1; i >= 0; i--){
//            res += index_num[i];
//        }
//
//        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7,7,7};
        String res = new Solution1().solution(nums);
        System.out.println(res);
    }
}
