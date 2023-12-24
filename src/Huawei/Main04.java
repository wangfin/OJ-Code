package Huawei;

import java.util.*;

public class Main04 {
    /**
     * 3 2
     * xinguan feiyan xinzeng bendi quezhen anli
     * ju baodao chengdu xinzneg xinguan feiyan bendi quezhen anli yili shenzhen xinzeng bendi quezhen anli liangqi yiyang zhengti kongzhi lianghao
     * xinguan yimiao linchuang shiyan
     * wuzhong xinguan yimiao tongguo lanqi linchuang shiyan xiaoguo lianghao
     * @param args
     */
    public static void main(String[] args) {
        // 第一行输入为正整数topN的文章数M，输出出现频率最高的词语个数和处理的文章的数量
        // 第二行起，每章文章的标题串和正文串
        Scanner sc = new Scanner(System.in);
        int topN = sc.nextInt();
        int M = sc.nextInt();

        // 处理掉缓冲区字符
        sc.nextLine();
        // 构建字典
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        // 获取文章的标题与正文
        for (int i = 1; i <= 2*M; i++){
            String words = sc.nextLine();
            // 标题
            if (i % 2 == 1){
                // 文章标题
                for(String word : words.split(" ")){
                    // 如果有，则+1，因为是title，需要+3
                    if (map.containsKey(word)) {
                        map.put(word, map.get(word) + 3);
                    } else {
                        map.put(word, 3);
                    }
                }
            }else{
                // 文章内容
                for(String word : words.split(" ")){
                    // 如果有，则+1
                    if (map.containsKey(word)) {
                        map.put(word, map.get(word) + 1);
                    } else {
                        map.put(word, 1);
                    }
                }
            }
        }

        // 遍历map，用最小堆保存频率最大的k个元素
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return map.get(a) - map.get(b);
            }
        });

        for (String key : map.keySet()) {
            if (pq.size() < topN) {
                pq.add(key);
            } else if (map.get(key) > map.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }
        // 取出最小堆中的元素
        ArrayList<String> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.remove());
        }
        for (int i = res.size() - 1; i >= 0; i--){
            System.out.println(res.get(i));
        }

    }

}
