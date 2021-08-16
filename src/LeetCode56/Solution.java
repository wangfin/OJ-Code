package LeetCode56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    /**
     * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
     * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
     * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
     * 输出：[[1,6],[8,10],[15,18]]
     * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     *
     * 朴素想法：先将列表中的区间按照左端点升序排序
     * 1.将第一个区间加入 merged 数组中，并按顺序依次考虑之后的每个区间：
     *   1.如果当前区间的左端点在数组 merged 中最后一个区间的右端点之后，那么它们不会重合，我们可以直接将这个区间加入数组 merged 的末尾；
     *   2.否则，它们重合，我们需要用当前区间的右端点更新数组 merged 中最后一个区间的右端点，将其置为二者的较大值。
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1)
            return intervals;

        // 设置一下比较器
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        // 返回的结果
        List<int[]> merged = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++){
            // 左右边界
            int L = intervals[i][0], R = intervals[i][1];
            // 前一个区间的右边界小于后一个区间的左边界
            // 也就是不相关的两个区间，创建一个新的
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L){
                merged.add(new int[]{L, R});
            }else{
                // 如果没有的话，根据两个的右边界，看哪个更大
                merged.get(merged.size()-1)[1] = Math.max(merged.get(merged.size()-1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
