package Shenxinfu;

import java.util.*;

public class Solution2 {
    public ArrayList<String> merge (ArrayList<String> input) {
        // write code here
        if (input.size() == 1)
            return input;

        // 排序
        Collections.sort(input, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] o1s = o1.split("-");
                String[] o2s = o2.split("-");

//                String[] o1_l = o1.split("-")[0].split("\\.");
//                String[] o2_l = o2.split("-")[0].split("\\.");

//                if (Integer.parseInt(o1_l[0]) != Integer.parseInt(o2_l[0])){
//                    return Integer.parseInt(o1_l[0]) - Integer.parseInt(o2_l[0]);
//                }else if(Integer.parseInt(o1_l[1]) != Integer.parseInt(o2_l[1])){
//                    return Integer.parseInt(o1_l[1]) - Integer.parseInt(o2_l[1]);
//                }else if(Integer.parseInt(o1_l[2]) != Integer.parseInt(o2_l[2])){
//                    return Integer.parseInt(o1_l[2]) - Integer.parseInt(o2_l[2]);
//                }else{
//                    return Integer.parseInt(o1_l[3]) - Integer.parseInt(o2_l[3]);
//                }
                return o1s[0].compareTo(o2s[0]);
            }
        });

        // 返回的结果
        ArrayList<String> merged = new ArrayList<>();
        for (int i = 0; i < input.size(); i++){
            String[] ips = input.get(i).split("-");
            String L, R = "";
            // 左右边界
            if (ips.length > 1){
                L = ips[0];
                R = ips[1];
            }else{
                L = ips[0];
                R = ips[0];
            }

            // 前一个区间的右边界小于后一个区间的左边界
            // 也就是不相关的两个区间，创建一个新的
            if (merged.size() == 0 || merged.get(merged.size()-1).split("-")[1].compareTo(L) < 0){
                merged.add(L + "-" + R);
            }else{
                // 如果没有的话，根据两个的右边界，看哪个更大
                if (merged.get(merged.size() - 1).split("-")[1].compareTo(R) < 0){
                    merged.set(merged.size()-1, L + "-" + R);
                }else{
                    merged.set(merged.size()-1, L + "-" + merged.get(merged.size()-1).split("-")[1]);
                }

            }
        }
        for (int i = 0; i < merged.size(); i++){
            if(merged.get(i).split("-")[0].compareTo(merged.get(i).split("-")[1]) ==0){
                merged.set(i, merged.get(i).split("-")[0]);
            }
        }
        return merged;
    }

    public static void main(String[] args) {
        // String[] input = new String[]{"192.168.0.1", "192.168.0.12-192.168.0.15"};
        ArrayList<String> input = new ArrayList<>();
        input.add("192.168.0.1");
        input.add("192.168.0.12-192.168.0.15");
        input.add("192.168.0.2");
        ArrayList<String> merged = new Solution2().merge(input);
        System.out.println(merged.toString());
    }
}
