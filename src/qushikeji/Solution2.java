package qushikeji;

import java.util.Scanner;

public class Solution2 {
    /**
     * 考虑一排n个卡片，值分别为V1，V2...Vn，其中n是偶数。我们通过交替轮流与对手进行游戏。
     * 在每一轮中，玩家从该行中选择第一个或最后一个卡片，将其从该行中永久移除，并获得该卡片的数值。
     * 确定如果我们先行动，我们肯定能赢得的最大可能总值。
     * 注意：对手和使用者一样聪明。
     * 让我们通过几个例子来理解这个问题：
     * 5,3,7,10：用户收集最大值为15（10+5）
     * 8,15,3,7：用户收集最大值为22（7+15）
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        // 用字符读入
        String s = sc.nextLine();
        String[] nums =  s.split(",");
        // 尝试使用dp，dp[i]表示第i轮的最大值
        // dp[i+1] = dp[i]+max[nums[0], nums[i-1]]
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        int left = 0;
        int right = nums.length - 1;
        int round = 0;
        for (int i = 1; i < nums.length + 1; i++){
            if (round % 2 !=0 ) {
                if (Integer.parseInt(nums[left]) > Integer.parseInt(nums[right])) {
                    dp[i] = dp[i - 1] + Integer.parseInt(nums[left]);
                    left++;
                } else {
                    dp[i] = dp[i - 1] + Integer.parseInt(nums[right]);
                    right--;
                }
            }else{
                if (Integer.parseInt(nums[left]) > Integer.parseInt(nums[right])) {
                    left++;
                } else {
                    right--;
                }
            }
            round += 1;
        }
        System.out.println(dp[dp.length-1]);
    }


}
