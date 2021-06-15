package LeetCode347;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Solution {
    /**
     * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
     *
     * 输入: nums = [1,1,1,2,2,3], k = 2
     * 输出: [1,2]
     *
     * 输入: nums = [1], k = 1
     * 输出: [1]
     *
     * 首先遍历数组，使用TreeMap统计出频次
     * 然后定义一个Freq类，类中包含元素与元素相对应的频次
     *
     * 首先选取出K个元素，如果后面遍历的元素的频次大于当前K个中最小频次元素的频次，那个就替换这个最小元素
     * Java自带的就是最小堆栈，所以不需要使用最大堆的东西
     * 如果当前元素的频次大于最小堆的头结点的频次，那么就出队头结点（最小频次的元素），然后加入该节点
     */

    // 频次类，既包含元素，也包含元素的频次
    private class Freq implements Comparable<Freq>{
        // 元素与相应的频次
        int e, freq;

        public Freq(int e, int freq){
            this.e = e;
            this.freq = freq;
        }

        // 定义如何比较，也就是定义优先级
        @Override
        public int compareTo(Freq another){
            // 因为是最小堆，所以频次最小的在顶上，所以只需要替换第一个就行
            // 频次越小，优先级越高
            if (this.freq > another.freq){
                return 1;
            }else if (this.freq < another.freq){
                return -1;
            }else{
                return 0;
            }
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        // 首先统计频次
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num:nums){
            if (map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }else{
                map.put(num, 1);
            }
        }
        // 构建优先队列
        PriorityQueue<Freq> pq = new PriorityQueue<>();

        // 遍历映射
        for (int key: map.keySet()){
            // 如果小于k，入队
            if (pq.size() < k) {
                // 将Freq类加入优先队列
                pq.add(new Freq(key, map.get(key)));
            }else if (map.get(key) > pq.peek().freq){
                // 如果当前的key的频次比优先队列中频次最小的元素的频次要高，则需要将当前元素替换该元素
                // 让头结点出对
                pq.remove();
                // 加入当前元素
                pq.add(new Freq(key, map.get(key)));
            }
        }

        // 将优先队列输出
        int[] res = new int[k];
        int i = 0;
        while (!pq.isEmpty()){
            res[i] = pq.poll().e;
            i++;
        }

        return res;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,1,-1,2,-1,2,3};
        int k = 2;
        int[] res = new Solution().topKFrequent(nums, k);
        System.out.println(Arrays.toString(res));
    }
}

