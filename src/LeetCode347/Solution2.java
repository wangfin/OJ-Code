package LeetCode347;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Solution2 {
    /**
     * 使用Java自带的PriorityQueue
     * 并使用匿名类的方式实现比较器
     */

    // 频次类，既包含元素，也包含元素的频次
//    private class Freq{
//        // 元素与相应的频次
//        int e, freq;
//
//        public Freq(int e, int freq){
//            this.e = e;
//            this.freq = freq;
//        }
//    }

    // 实现比较器
//    private class FreqComparator implements Comparator<Freq>{
//
//        @Override
//        public int compare(Freq a, Freq b){
//            return a.freq - b.freq;
//        }
//    }


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
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            // 自定义比较器，定义如何设置优先级
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });

        // 遍历映射
        for (int key: map.keySet()){
            // 如果小于k，入队
            if (pq.size() < k) {
                // 将key加入优先队列
                pq.add(key);
            }else if (map.get(key) > map.get(pq.peek())){
                // 如果当前的key的频次比优先队列中频次最小的元素的频次要高，则需要将当前元素替换该元素
                // 让头结点出对
                pq.remove();
                // 加入当前元素
                pq.add(key);
            }
        }

        // 将优先队列输出
        int[] res = new int[k];
        int i = 0;
        while (!pq.isEmpty()){
            res[i] = pq.poll();
            i++;
        }

        return res;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,1,-1,2,-1,2,3};
        int k = 2;
        int[] res = new Solution2().topKFrequent(nums, k);
        System.out.println(Arrays.toString(res));
    }
}

