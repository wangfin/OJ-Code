package LeetCode75;

public class Solution {
    /**
     * 给定一个包含红色、白色和蓝色，一共 n个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     *
     * 此题中，我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
     *
     * 输入：nums = [2,0,2,1,1,0]
     * 输出：[0,0,1,1,2,2]
     *
     * 输入：nums = [2,0,1]
     * 输出：[0,1,2]
     * 进阶：
     * 你可以不使用代码库中的排序函数来解决这道题吗？
     * 你能想出一个仅使用常数空间的一趟扫描算法吗？
     *
     * 因为只有0,1,2三个数字，应该也不需要排序函数
     * 看标签是双指针，考虑使用双指针
     * 简单思路，单指针，也就是遍历一遍把0移到前面，再遍历一遍把1移到前面，最后2就在后面
     * 原地排序，应该是不能统计个数，然后在重新构造数组了（桶排序）
     * 双指针，一个指针交换0
     * 一个i遍历数组，
     *
     */
    public void sortColors(int[] nums) {
        int pos_0 = 0, pos_1 = 0;
        // 遍历数组
        for (int i = 0; i < nums.length; i ++){
            // 当前值=0
            if (nums[i] == 0){
                // 如果当前值是0，那么移动的时候，pos_0,pos_1的位置都需要向后移动
                int tmp = nums[i];
                nums[i] = nums[pos_0];
                nums[pos_0] = tmp;
                if (pos_0 < pos_1){
                    int temp = nums[i];
                    nums[i] = nums[pos_1];
                    nums[pos_1] = temp;
                }
                pos_0++;
                pos_1++;
            }else if (nums[i] == 1){
                // 如果当前值=1
                int temp = nums[i];
                nums[i] = nums[pos_1];
                nums[pos_1] = temp;
                ++pos_1;
            }
        }
    }
}
