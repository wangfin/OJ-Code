package Offer37;

import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Queue;

public class Codec {
    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 请实现两个函数，分别用来序列化和反序列化二叉树。
     * 你需要设计一个算法来实现二叉树的序列化与反序列化。
     * 这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
     * 提示：输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅LeetCode 序列化二叉树的格式。
     * 你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
     *
     * 观察题目示例，序列化的字符串实际上是二叉树的 “层序遍历”（BFS）结果，所以采用层序遍历。
     * 为完整表示二叉树，考虑将叶节点下的 null 也记录。
     * 在此基础上，对于列表中任意某节点 node ，其左子节点 node.left 和右子节点 node.right 在序列中的位置都是 唯一确定 的。
     * 序列化 使用层序遍历实现。反序列化 通过以上递推公式反推各节点在序列中的索引，进而实现。
     *
     */

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        /**
         * 序列化 Serialize ：
         * 借助队列，对二叉树做层序遍历，并将越过叶节点的 null 也打印出来。
         *
         * 算法流程：
         * 特例处理： 若 root 为空，则直接返回空列表 "[]" ；
         * 初始化： 队列 queue （包含根节点 root ）；序列化列表 res ；
         * 层序遍历： 当 queue 为空时跳出；
         * 节点出队，记为 node ；
         * 若 node 不为空：① 打印字符串 node.val ，② 将左、右子节点加入 queue ；
         * 否则（若 node 为空）：打印字符串 "null" ；
         * 返回值： 拼接列表，用 ',' 隔开，首尾添加中括号；
         *
         */
        if (root == null)
            return "[]";
        // 构建输出
        StringBuilder res = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node != null){

            }
        }

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

    }

}
