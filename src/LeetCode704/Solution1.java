package LeetCode704;

public class Solution1 {
    /**
     * 如果说定义 target 是在一个在左闭右开的区间里，也就是[left, right) ，那么二分法的边界处理方式则截然不同。
     *
     * 有如下两点：
     *
     * while (left < right)，这里使用 < ,因为left == right在区间[left, right)是没有意义的
     * if (nums[middle] > target) right 更新为 middle，因为当前nums[middle]不等于target，去左区间继续寻找，
     * 而寻找区间是左闭右开区间，所以right更新为middle，即：下一个查询区间不会去比较nums[middle]
     */
    public int search(int[] nums, int target) {
        int left = 0;
        // 这里的右区间也做了修改，因为最右边的值是取不到的
        int right = nums.length;
        // 左区间不能和右区间相同
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                // 主要不同的在这里，因为定义的是左闭右开的区间
                // 所以右边是取不到的
                // 可以将边界值设定为mid
                right = mid;
        }
        return -1;
    }
}
