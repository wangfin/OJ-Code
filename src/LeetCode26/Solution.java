package LeetCode26;

public class Solution {
    /**
     * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * 在27的基础上，还是使用双指针
     *
     * 慢指针在后面，快指针去前面找有没有一样的，一样的就跳过，直到和慢指针不一样的，在拿到前面来
     *
     */
    public int removeDuplicates(int[] nums) {
        // 慢指针从0开始
        int slowIndex = 1;
        // 快指针进行遍历
        for (int fastIndex = 1; fastIndex < nums.length; fastIndex ++){
            // 因为是有序数组，只需要前后判断即可
            if (nums[fastIndex] != nums[fastIndex - 1]){
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        // 从0开始算的，长度需要+1
        return slowIndex+1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 4, 4, 5};
        int res = new Solution().removeDuplicates(nums);
        System.out.println(res);
    }
}
