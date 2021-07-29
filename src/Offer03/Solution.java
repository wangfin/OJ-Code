package Offer03;

import java.util.HashSet;

public class Solution {
    /**
     * 找出数组中重复的数字。
     *
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
     * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
     *
     * 输入：
     * [2, 3, 1, 0, 2, 5, 3]
     * 输出：2 或 3
     *
     *
     * 这个题的话首先是哈希，HashMap或者HashSet
     */
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> dic = new HashSet<>();
        for (int num: nums){
            if (dic.contains(num)){
                return num;
            }else{
                dic.add(num);
            }
        }
        return -1;
    }
}
