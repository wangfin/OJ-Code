package LeetCode134;

public class Solution {

    /**
     *
     * 在一条环路上有N个加油站，其中第i个加油站有汽油gas[i]升。
     * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1个加油站需要消耗汽油cost[i]升。你从其中的一个加油站出发，开始时油箱为空。
     * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
     * 说明:
     * 如果题目有解，该答案即为唯一答案。
     * 输入数组均为非空数组，且长度相同。
     * 输入数组中的元素均为非负数。
     *
     * 1.首先判断总gas能不能大于等于总cost，如果总gas不够，一切都白搭对吧（总（gas- cost）不用单独去计算，和找最低点时一起计算即可，只遍历一次）；
     * 2.再就是找总（gas-cost）的最低点，不管正负（当然如果最低点都是正的话那肯定能跑完了）；
     * 3.找到最低点后，如果有解，那么解就是最低点的下一个点，因为总（gas-cost）是大于等于0的，所以前面损失的gas我从最低点下一个点开始都会拿回来，
     * 别管后面的趋势是先加后减还是先减后加，最终结果我是能填平前面的坑的。
     *
     */

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int spare = 0;
        int minspare = 1;
        int minindex = 0;
        for (int i = 0; i < gas.length; i++){
            // 每个站点的剩余油量=在这个站点加入的-前往这个站点消耗的
            spare += gas[i] - cost[i];
            // 找到那个剩余油量的最低点
            if (spare < minspare){
                minspare = spare;
                minindex = i;
            }
        }

        // 如果最低点的小于0，也就是不能到达
        if (spare < 0){
            return -1;
        }else{
            // 找到最低点后，如果有解，那么解就是最低点的下一个点
            return (minindex + 1) % gas.length;
        }
    }

    public static void main(String[] args) {
        int[] gas = new int[]{1,2,3,4,5};
        int[] cost = new int[]{3,4,5,1,2};
        int res = new Solution().canCompleteCircuit(gas, cost);
        System.out.println(res);

    }

}


