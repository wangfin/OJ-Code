package Huawei;

import java.util.*;

public class Main03 {
    List<Integer> path;
    int res;

    private int getGift(int m, int cash, int n, int[] gifts){
        Arrays.sort(gifts);
        path = new ArrayList<>();
        res = 0;
        backtracking(m, cash, 0, gifts, 0);
        return res;
    }

    private void backtracking(int m, int cash, int sum, int[] gifts, int statrIndex){
        if (path.size() == m && sum == cash){
            res ++;
        }
        if (path.size() > m){
            return;
        }
        if (sum > cash){
            return;
        }
        for (int i = statrIndex; i < gifts.length; i++){
            path.add(gifts[i]);
            sum += gifts[i];
            backtracking(m, cash, sum, gifts, i+1);
            sum -= gifts[i];
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int cash = sc.nextInt();
        int n = sc.nextInt();
        int[] gifts = new int[n];
        for (int i = 0; i < n; i++){
            gifts[i] = sc.nextInt();
        }
        Main03 ma = new Main03();
        System.out.println(ma.getGift(m, cash, 0, gifts));

    }

}
