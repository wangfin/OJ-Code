package Offer03;

public class Solution1 {
    /**
     * 原地交换
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0 ~ n-1 的范围内，此说明含义：数组元素的 索引 和 值 是 一对多 的关系。
     * 遍历中，第一次遇到数字 x 时，将其交换至索引 x 处；而当第二次遇到数字 x 时，一定有 nums[x] = x ，此时即可得到一组重复数字。
     *
     * 1.遍历数组 nums ，设索引初始值为 i = 0:
     *  1.若 nums[i] = i： 说明此数字已在对应索引位置，无需交换，因此跳过；
     *  2.若 nums[nums[i]] = nums[i] ：
     *  代表索引 nums[i] 处和索引 i 处的元素值都为 nums[i] ，即找到一组重复值，返回此值 nums[i] ；
     *  3.否则： 交换索引为 i 和 nums[i] 的元素值，将此数字交换至对应索引位置。
     * 2.若遍历完毕尚未返回，则返回 -1 。
     *
     */
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i ++){
            if (nums[i] == i){
                continue;
            }
            // 代表索引 nums[i] 处和索引 i 处的元素值都为 nums[i] ，即找到一组重复值，返回此值 nums[i]
            if (nums[nums[i]] == nums[i]){
                return nums[i];
            }else{
                // 如果不是，交换值
                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
        }
        return -1;
    }
}
