package Huawei;

public class Solution {
    public int completteCircuit(int[] gas, int[] cost){
        int N = gas == null? 0: cost.length;

        // 剩余油量
        int left = 0;
        // 起点
        int ans = 0;
        // 当sum(Gas) >= sum(Cost)时，必然存在某个出发点可以绕一圈
        int total = 0;

        // 遍历节点
        for (int i = 0; i < N; i++){
            int ga = gas[i];
            int co = cost[i];
            total += ga - co;

            if(left + ga - co >= 0){
                // 可以继续前进
                left += ga - co;
            }else{
                left = 0;
                // 下一个尝试的起点
                ans = i+1;
            }



        }
        return total >= 0 ? ans: -1;

    }
}
