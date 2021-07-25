package LeetCode121;

public class Solution1 {
    /**
     * 一次遍历
     * 用一个变量记录一个历史最低价格 minprice，我们就可以假设自己的股票是在那天买的。
     * 那么我们在第 i 天卖出股票能得到的利润就是 prices[i] - minprice。
     * 因此，我们只需要遍历价格数组一遍，记录历史最低点，然后在每一天考虑这么一个问题：如果我是在历史最低点买进的，那么我今天卖出能赚多少钱？
     * 当考虑完所有天数之时，我们就得到了最好的答案。
     *
     */
    public int maxProfit(int prices[]){
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        // 开始遍历
        for (int i = 0; i < prices.length; i ++){
            if (prices[i] < minprice){
                minprice = prices[i];
            }else if (prices[i] - minprice > maxprofit){
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }
}
