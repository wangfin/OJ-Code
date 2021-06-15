package LeetCode215;

import java.util.Arrays;

public class Solution {
    /**
     * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     * 示例:
     * 输入: [3,2,1,5,6,4] 和 k = 2
     * 输出: 5
     * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
     * 输出: 4
     *
     * 简单想法，先排序，然后选第K个
     */
    public int findKthLargest(int[] nums, int k) {
        // Arrays.sort(nums);
        quicksort(nums);
        return nums[nums.length - k];
    }
    public static void quicksort(int[] arr){
        qsort(arr, 0, arr.length-1);
    }
    private static void qsort(int[] arr, int low, int high){
        if (low >= high){
            return;
        }
        // 将数组分为两个部分
        int pivot = partition(arr, low, high);
        // 递归排序左右子数组
        qsort(arr, low, pivot-1);
        qsort(arr, pivot+1, high);
    }
    private static int partition(int[] arr, int low, int high){
        // 一开始设置基准为0
        int pivot = arr[low];
        while (low < high){
            // 遍历数组
            while (low < high && arr[high] >= pivot)
                --high;
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot)
                ++low;
            arr[high] = arr[low];
        }
        // 扫描完成，基准到位
        arr[low] = pivot;
        // 返回基准的位置
        return low;
    }



    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};
        int k = 3;
        int res = new Solution().findKthLargest(nums, k);
        System.out.println(res);
    }

}
