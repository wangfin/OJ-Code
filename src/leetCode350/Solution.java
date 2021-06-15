package leetCode350;
import java.util.ArrayList;
import java.util.TreeMap;

public class Solution {
    /**
     * 给定两个数组，编写一个函数来计算它们的交集。
     * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出：[2,2]
     * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出：[4,9]
     * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
     * 我们可以不考虑输出结果的顺序
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        // 使用映射，key是数组中的元素，value是数组的频次，这是为了应对重复元素的
        TreeMap<Integer, Integer>map = new TreeMap<>();
        for(int num: nums1){
            // 把nums1中的元素添加到Map中
            // 没有这个key就创建，频次设置为1
            if(!map.containsKey(num))
                map.put(num, 1);
            else
                // 有，频次+1
                map.put(num, map.get(num) + 1);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int num: nums2){
            // 如果num1中有num2的值
            if(map.containsKey(num)){
                // 添加到结果列表中
                list.add(num);
                // map中的频次-1
                map.put(num, map.get(num) - 1);
                if(map.get(num) == 0)
                    map.remove(num);
            }
        }

        int[] res  = new int[list.size()];
        for(int i = 0; i < list.size(); i ++)
            res[i] = list.get(i);
        return res;
    }

}
