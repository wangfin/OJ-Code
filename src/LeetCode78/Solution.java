package LeetCode78;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     *
     * 组合 n!/m!(n-m)!，全组合，组合可以是1个字符的组合，2个字符的字符……一直到n个字符的组合
     *
     * 输入：nums = [1,2,3]
     * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     *
     * 输入：nums = [0]
     * 输出：[[],[0]]
     *
     * 回溯算法
     * 该题目和77组合是一样的，这个不过是全部子集的组合
     */
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        // tmp 也就是path，用于记录每一个路径的值
        ArrayList<Integer> tmp = new ArrayList<>();
        backtrack(0, nums, res, tmp);
        return res;
    }

    // 回溯函数
    private void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp){
        // 终止条件（本题没有终止，直接添加即可），添加到结果中

        res.add(new ArrayList<>(tmp));
        // 循环，在选择列表里进行选择
        // 这里的j=i限制了选择的选项
        for (int j = i; j < nums.length; j++){
            // 添加元素
            tmp.add(nums[j]);
            // 继续向下探索
            backtrack(j+1, nums, res ,tmp);
            // 回溯
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> res = new Solution().subsets(nums);
        System.out.println(res.toString());

    }

}
