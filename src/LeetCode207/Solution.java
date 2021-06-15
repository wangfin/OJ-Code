package LeetCode207;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    /**
     *
     * 你这个学期必须选修 numCourses 门课程，记为0到numCourses - 1 。
     *
     * 在选修某些课程之前需要一些先修课程。
     * 先修课程按数组prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则必须先学习课程 bi。
     *
     * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
     * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
     *
     * 输入：numCourses = 2, prerequisites = [[1,0]]
     * 输出：true
     * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
     *
     * 拓扑排序
     * 本题可约化为：课程安排图是否是 有向无环图(DAG)。即课程间规定了前置条件，但不能构成任何环路，否则课程前置条件将不成立。
     * 思路是通过 拓扑排序 判断此课程安排图是否是 有向无环图(DAG) 。
     * 拓扑排序原理：对 DAG 的顶点进行排序，使得对每一条有向边 (u, v)，均有 u（在排序记录中）比 v 先出现。
     * 亦可理解为对某点 v 而言，只有当 v 的所有源点均出现了，v 才能出现。
     * 通过课程前置条件列表 prerequisites 可以得到课程安排图的 邻接表 adjacency，以降低算法时间复杂度，以下两种方法都会用到邻接表。
     *
     *
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++)
            adjacency.add(new ArrayList<>());
        // Get the indegree and adjacency of every course.
        for(int[] cp : prerequisites) {
            indegrees[cp[0]]++;
            adjacency.get(cp[1]).add(cp[0]);
        }
        // Get all the courses with the indegree of 0.
        for(int i = 0; i < numCourses; i++)
            if(indegrees[i] == 0) queue.add(i);
        // BFS TopSort.
        while(!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            for(int cur : adjacency.get(pre))
                if(--indegrees[cur] == 0) queue.add(cur);
        }
        return numCourses == 0;

    }
}
