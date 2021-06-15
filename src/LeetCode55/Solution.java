package LeetCode55;

public class Solution {
    /**
     * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 判断你是否能够到达最后一个下标。
     *
     * 输入：nums = [2,3,1,1,4]
     * 输出：true
     * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
     *
     * 对于每一个可以到达的位置 x，它使得 x+1, x+2, x+nums[x] 这些连续的位置都可以到达。
     * 这样一来，依次遍历数组中的每一个位置，并实时维护 最远可以到达的位置。
     * 对于当前遍历到的位置 x，如果它在 最远可以到达的位置 的范围内，
     * 那么就可以从起点通过若干次跳跃到达该位置，因此可以用 x+nums[x] 更新 最远可以到达的位置。
     * 选择x+nums[x]中最大值，也就是最远可以到达的位置
     *
     * 构建jump为当前的位置，maxindex为目前能够到达的最远的位置
     * 将jump从当前位置到maxindex遍历，更新maxindex，直到jump>nums.length或者jump>maxindex
     * 如果这个时候jump没有到达数组末尾，就说明无法跳到末尾了
     *
     */
    public boolean canJump(int[] nums) {
        // 最远可以到达的index
        int[] index = new int[nums.length];
        for (int i = 0; i < nums.length; i ++){
            index[i] = i + nums[i];
        }
        // 当前位置
        int jump = 0;
        // 最远能到达的位置
        int maxindex = index[0];
        // 知道jump跳到数组末尾或者jump超越了当前可以跳到的最远位置
        // 这边只需要获取最远能跳到的位置maxindex能不能到达数组末尾，不需要jump真的去跳到那个能去最远地方的位置
        // jump只需要一个一个遍历即可
        while (jump < nums.length && jump <= maxindex){
            // 更新最远能到达的位置
            if (index[jump] > maxindex){
                maxindex = index[jump];
            }
            // jump一直更新到maxindex的位置
            jump++;
        }
        if (jump == index.length){
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,0,4};
        boolean res = new Solution().canJump(nums);
        System.out.println(res);
    }
}
