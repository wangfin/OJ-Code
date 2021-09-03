package PDD;

import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<String> res = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        // n个字符串
        for (int i = 0; i < N; i++){
            PriorityQueue<String> ppl = new PriorityQueue<>();
            String in = sc.next();
            ppl.add(in);
//            int left = 0, right = in.length() - 1;
//            while (left <= right){
//                String snew = swap(in, left, right);
//                left++;
//                right--;
//                ppl.add(snew);
//            }
            int len = in.length();
            for (int j = 0; j <= len / 2; j++){
                String tmp = swap(in, j, len-1-j);
                ppl.add(tmp);
                int l = j, r = len-1-j;
                while (l < r){
                    String tmp1 = swap(tmp, l++, r--);
                    ppl.add(tmp1);
                }
            }
            String min = ppl.peek();
            // min是不是原始字符串
            if (min.equals(in)){
                res.add(min);
            }else{
                res.add(min);
                map.put(min, in);
            }
        }
        Collections.sort(res);
        // 替换
        for (int i = 0; i < res.size(); i++){
            if (map.containsKey(res.get(i))){
                res.set(i, map.get(res.get(i)));
                map.remove(res.get(i));
            }
        }
        for (String s2: res){
            System.out.println(s2);
        }
    }

    public static String swap(String s, int left, int right){
        StringBuilder sb = new StringBuilder(s);
        char l = s.charAt(left);
        char r = s.charAt(right);
        sb.setCharAt(left, r);
        sb.setCharAt(right, l);
        return sb.toString();
    }
}
