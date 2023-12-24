package manbang;

import java.util.*;
public class Solution2 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 计算出每一天感染数量需要等几天才会有降低
     * @param nums int整型一维数组 一段时间内的感染数量数组
     * @return int整型一维数组
     */
    public int[] covid (int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            int n = 0;
            for (int j = i; j < nums.length; j ++){
                if (nums[j] >= nums[i]){
                    n++;
                }else{
                    break;
                }
                res[i] = n;
            }
        }
        // 处理到结束都没有下降的点
        for (int i = 0; i < nums.length; i++){
            if (res[i] == nums.length - i){
                res[i] = 0;
            }
        }
        return res;
    }

}
