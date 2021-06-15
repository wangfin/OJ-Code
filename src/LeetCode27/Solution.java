package LeetCode27;

public class Solution {
    /**
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     *
     * 他会读取数组的前res个值，需要确实删除数组
     * 可以暴力解法，一个for循环遍历数组元素 ，第二个for循环更新数组，不彳亍，超时了
     *
     * 使用双指针法（快慢指针法）： 通过一个快指针和慢指针在一个for循环下完成两个for循环的工作。
     */
//    public int removeElement(int[] nums, int val) {
//        int n = nums.length;
//        int res = n;
//        for (int i = 0; i < n; i ++){
//            if (nums[i] == val){
//                for (int j = i + 1; j < n ; j ++){
//                    nums[j-1] = nums[j];
//                }
//                i --;
//                res --;
//            }
//        }
//        return res;
//    }

    public int removeElement(int[] nums, int val) {
        // 快慢指针，慢指针指位置，快指针做调整
        int slowIndex = 0;
        // 直接把不是val的值全部移到前面来
        for (int fastIndex = 0 ; fastIndex < nums.length; fastIndex ++){
            // fastIndex的值 != val
            if (nums[fastIndex] != val){
                nums[slowIndex] = nums[fastIndex];
                slowIndex ++;
            }
        }
        return slowIndex;
    }
}
