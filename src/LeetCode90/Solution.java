package LeetCode90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author wangfin
 * @Date 2024/4/18
 * @Desc 子集 II
 */
public class Solution {

    /**
     * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
     * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
     * <p>
     * 示例 1：
     * 输入：nums = [1,2,2]
     * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
     * 示例 2：
     * 输入：nums = [0]
     * 输出：[[],[0]]
     */

    /**
     * “树层去重”和“树枝去重”，这道题就是一个树层去重，即上一个使用过的数字，如果下个数字是一样的话就不能再用了
     * 当然得先排序，且 i > startIndex，也就是必须开始往后面找元素的时候才开始识别是否有重复
     *
     * 同一树层上重复取2 就要过滤掉，同一树枝上就可以重复取2，因为同一树枝上元素的集合才是唯一子集！
     * 本题也可以不使用used数组来去重，因为递归的时候下一个startIndex是i+1而不是0。
     * 如果要是全排列的话，每次要从0开始遍历，为了跳过已入栈的元素，需要使用used。
     */

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        backTracking(nums, 0);

        return res;
    }

    private void backTracking(int[] nums, int startIndex) {
        // 终止条件
        // 这个题目跟子集一样，路径过程中的值就是最终的结果
        res.add(new ArrayList<>(path));

        // 循环遍历
        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            backTracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {0};
        Solution solution = new Solution();
        System.out.println(solution.subsetsWithDup(nums));
    }

}
