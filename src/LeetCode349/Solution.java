package LeetCode349;
import java.util.ArrayList;
import java.util.TreeSet;

public class Solution {
    /**
     * 给定两个数组，编写一个函数来计算它们的交集。
     * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出：[2]
     *
     * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出：[9,4]
     * 在结果中元素必须是唯一的
     */

    public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> set = new TreeSet<>();
        // 对num1数组进行去重
        for(int num: nums1){
            set.add(num);
        }

        ArrayList<Integer> list = new ArrayList<>();
        // 从nums2中查询元素
        for(int num: nums2){
            // 如果存在这个元素
            if(set.contains(num)){
                // 把元素保存在结果中
                list.add(num);
                // 从nums1集合中删除这个元素
                set.remove(num);
            }
        }

        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        return res;
    }
}
