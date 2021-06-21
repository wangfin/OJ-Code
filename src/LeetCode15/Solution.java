package LeetCode15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？
     * 请你找出所有和为 0 且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     *
     * 输入：nums = [-1,0,1,2,-1,-4]
     * 输出：[[-1,-1,2],[-1,0,1]]
     *
     * 输入：nums = []
     * 输出：[]
     *
     * 题解：
     * 直接上专业题解吧，这边用了一个三指针指着对应的元素
     * 原本也可以两层for循环就可以确定 a 和 b的数值了，可以使用哈希法来确定 0-(a+b) 是否在 数组里出现过
     * 但是去重比较浪费时间，而且去重的过程不好处理
     * 所以使用双指针的这种方式
     * 先将数组排序，然后有一层for循环，i从下表0的地方开始，同时定一个下表left 定义在i+1的位置上，定义下表right 在数组结尾的位置上。
     * 依然还是在数组中找到 abc 使得a + b +c =0，这里相当于 a = nums[i] b = nums[left] c = nums[right]。
     * 接下来如何移动left 和right呢， 如果nums[i] + nums[left] + nums[right] > 0 就说明
     * 此时三数之和大了，因为数组是排序后了，所以right下表就应该向左移动，这样才能让三数之和小一些。
     * 如果 nums[i] + nums[left] + nums[right] < 0 说明 此时 三数之和小了，left 就向右移动，才能让三数之和大一些，直到left与right相遇为止。
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 排序
        Arrays.sort(nums);
        // 找出a + b + c = 0
        // a = nums[i], b = nums[left], c = nums[right]
        for (int i = 0; i < nums.length; i++){
            // 排序之后如果第一个元素已经大于零，那么无论如何组合都不可能凑成三元组，直接返回结果就可以了
            if (nums[i] > 0){
                return res;
            }

            // 去重方法
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }

            // 设置left和right
            int left = i + 1;
            int right = nums.length - 1;

            while (right > left){
                // 去重复逻辑如果放在这里，0，0，0 的情况，可能直接导致 right<=left 了，从而漏掉了 0,0,0 这种三元组
                if (nums[i] + nums[left] + nums[right] > 0){
                    right --;
                }else if (nums[i] + nums[left] + nums[right] < 0){
                    left ++;
                }else{ //nums[i] + nums[left] + nums[right] == 0
                    // 添加到结果中
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重逻辑应该放在找到一个三元组之后
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    while (right > left && nums[left] == nums[left + 1]) left++;

                    right--;
                    left++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> res = new Solution().threeSum(nums);
        System.out.println(res.toString());
    }

}
