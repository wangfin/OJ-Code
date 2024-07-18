package LeetCode332;

import java.util.List;

/**
 * @Author wangfin
 * @Date 2024/6/19
 * @Desc 332. 重新安排行程
 */
class Solution {

    /**
     * 给你一份航线列表 tickets ，其中 tickets[i] = [fromi, toi] 表示飞机出发和降落的机场地点。请你对该行程进行重新规划排序。
     * 所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。如果存在多种有效的行程，请你按字典排序返回最小的行程组合。
     * 例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前。
     * 假定所有机票至少存在一种合理的行程。且所有的机票 必须都用一次 且 只能用一次。
     *
     * 示例 1：
     * 输入：tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
     * 输出：["JFK","MUC","LHR","SFO","SJC"]
     *
     * 示例 2：
     * 输入：tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
     * 输出：["JFK","ATL","JFK","SFO","ATL","SFO"]
     * 解释：另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"] ，但是它字典排序更大更靠后。
     */
    public List<String> findItinerary(List<List<String>> tickets) {
        /**
         * 采用回溯法，那就是构建一个树型结构，然后进行遍历，需要构建遍历内容、截止条件
         * 1. 构建遍历内容
         * 遍历内容应该是出发地到目的地，Map<出发机场, 到达机场的集合>
         * 2. 截止条件：应该就是全部的机票用完，返回值List长度是tickets长度+1
         */


        // todo 322题目
        return null;

    }
}
