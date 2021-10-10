package Huawei;

import java.util.*;

public class Main01 {
//    public static int intTo32Bit(int num, int n, int m){
//        StringBuffer sb = new StringBuffer();
//        for (int i = 0; i < 32; i++){
//            sb.append(num & 1);
//            num = num >>> 1;
//        }
//        sb = sb.reverse();
//
//        for (int i = 32 - n - m; i < 32 - n; i++){
//
//        }
//
//        return 0;
//    }
    public int getRes(int[] nums, int n, int m){
        int res = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num:nums){
            int newNum = getNewNum(n, m, num);
            map.put(newNum, map.getOrDefault(newNum, 0)+1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(((o1, o2) -> o2[1] - o1[1]));

        for (Map.Entry<Integer, Integer> entry:map.entrySet()){
            queue.add(new int[]{
                    entry.getKey(), entry.getValue()});
        }

        if (queue.size() == 1){
            res = queue.poll()[1];
        }else if (queue.size() > 1){
            int[] maxCount = queue.poll();
            if (maxCount[1] > queue.peek()[1]){
                res = maxCount[0];
            }
        }
        return res;
    }

    private int getNewNum(int n, int m, int num){
        int rightSave = 0;
        for(int i = 0; i < n; i++){
            rightSave += (((num >>> i) & 1)<<i);
        }
        int midSave = 0;
        for (int i = n+m; i <= 31; i++){
            midSave += (((num>>>i)&1)<<(i-n));
        }

        int leftSave = 0;
        for (int i = n; i < m+n; i++){
            leftSave += ((num>>>i)&1)<<(32-(m+n)+i);
        }

        int newNum = leftSave + rightSave + midSave;

        return newNum >>> 16;

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[X];
        for (int i = 0; i < X; i++){
            nums[i] = sc.nextInt();
        }
        Main01 ma = new Main01();
        System.out.println(ma.getRes(nums, n, m));

    }
}
