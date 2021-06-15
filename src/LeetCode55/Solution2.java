package LeetCode55;

public class Solution2 {
    public boolean canJump(int[] nums) {
        // 数据只有一个值，开头即末尾
        if (nums.length <= 1){
            return true;
        }
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
        for (jump = jump; jump <= maxindex; jump ++){
            // 能够到达末尾，因为jump是从0开始跳的，所以应该是长度-1
            if (jump >= nums.length - 1){
                return true;
            }
            // 最大值更新
            if (maxindex < index[jump]){
                maxindex = index[jump];
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,4};
        boolean res = new Solution2().canJump(nums);
        System.out.println(res);
    }
}
