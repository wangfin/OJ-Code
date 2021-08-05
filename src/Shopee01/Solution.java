package Shopee01;

public class Solution {
    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     * 给出一个数组，你需要找到在这个数组中的“平衡点”。
     *
     * 一个数组的“平衡点”满足 在它左边的所有数字的和等于在它右边的所有数字的和（不包括平衡点本身）。
     *
     * 你的代码应该返回平衡数的下标，如果平衡数存在多个，返回最小的下标。
     * 1. 保证存在一个可行解
     * 2. 3 <= length(inputArray) <= 10^5
     * 3. 1 <= inputArray[i] <= 2*10^4, where 0 <= i < length(inputArray)
     *
     * find balanced index for an input array
     * @param inputArray int整型一维数组 the input array
     * @return int整型
     */
    public int findBalancedIndex(int[] inputArray) {
        // write code here
        // 初始化左半边的值
        int left = 0;
        // 初始化右半边的值
        int right = 0;
        for (int i = 1; i < inputArray.length; i++){
            right+=inputArray[i];
        }
        int res = -1;
        // 开始遍历
        for (int i = 1; i < inputArray.length; i++){

            left += inputArray[i-1];
            right -= inputArray[i];
            if (left == right){
                res = i;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] inputArray = {1,2,3,4,6};
        int res = new Solution().findBalancedIndex(inputArray);
        System.out.println(res);
    }
}
