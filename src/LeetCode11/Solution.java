package LeetCode11;

/**
 * @Author wangfin
 * @Date 2023/12/24
 * @Desc
 */
public class Solution {

    /**
     * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * 返回容器可以储存的最大水量。
     * 说明：你不能倾斜容器。
     */

    public int maxArea(int[] height) {
        /**
         * 本题一开始的时候，使用双层for循环，一层找头节点，一层找尾节点，很显然超时了
         * 改了一版，一个从头开始，一个从尾部开始，还是超时
         * 后来看了题解，只需要移动短板即可，以为移动长板，而短板不动，因为面积取决于短板，而底部X减少，所以面积是一定会减少的。因此只需要移动短板即可，所以改成了一个while同时改变两个。
         * 题解：
         * 若向内 移动短板 ，水槽的短板 min(h[i],h[j])min(h[i], h[j])min(h[i],h[j]) 可能变大，因此下个水槽的面积 可能增大 。
         * 若向内 移动长板 ，水槽的短板 min(h[i],h[j])min(h[i], h[j])min(h[i],h[j])​ 不变或变小，因此下个水槽的面积 一定变小 。
         */
        // 单层while循环
        int maxArea = Integer.MIN_VALUE;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int area = (j - i) * Math.min(height[i], height[j]);
            if (area > maxArea) {
                maxArea = area;
            }

            // 短边向内移动
            if (height[i] < height[j]) {
                i ++;
            } else {
                j --;
            }
        }

        return maxArea;
    }
}
