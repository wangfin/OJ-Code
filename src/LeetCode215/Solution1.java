package LeetCode215;

public class Solution1 {
    /**
     * 堆排序
     */

    public int findKthLargest(int[] nums, int k) {
        // 堆的大小
        int heapSize = nums.length;
        // 构建最大堆
        buildMaxHeap(nums, heapSize);
        for (int i = nums.length - 1; i >= nums.length - k + 1; --i){
            swap(nums, 0, i);
            --heapSize;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    public void buildMaxHeap(int[] a, int heapSize){
        for (int i = heapSize / 2; i >= 0; --i){
            maxHeapify(a, i, heapSize);
        }
    }

    public void maxHeapify(int[] a, int i, int heapSize){
        // 节点的左孩子节点
        int l = i * 2 + 1;
        // 节点的右孩子节点
        int r = i * 2 + 2;
        int largest = i;
        if (l < heapSize && a[l] > a[largest]){
            largest = l;
        }
        if (r < heapSize && a[r] > a[largest]){
            largest = r;
        }
        if (largest != i){
            swap(a, i, largest);
            maxHeapify(a, largest, heapSize);
        }

    }

    public void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};
        int k = 3;
        int res = new Solution1().findKthLargest(nums, k);
        System.out.println(res);
    }

}
