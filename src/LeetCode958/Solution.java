package LeetCode958;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 给定一个二叉树，确定它是否是一个完全二叉树。
     * 若设二叉树的深度为 h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。
     * （注：第 h 层可能包含 1~2^h个节点。）
     * 广度优先遍历
     * 对于根节点，定义其编号为 1。然后，对于每个节点 v，将其左节点编号为 2 * v，将其右节点编号为 2 * v + 1。
     * 可以发现，树中所有节点的编号按照广度优先搜索顺序正好是升序。（也可以使用深度优先搜索，之后对序列排序）。
     * 然后，检测编号序列是否为无间隔的 1, 2, 3, …，事实上，我们只需要检查最后一个编号是否正确，因为最后一个编号的值最大。
     *
     */
    public boolean isCompleteTree(TreeNode root) {
        List<ANode> nodes = new ArrayList<>();
        nodes.add(new ANode(root, 1));
        int i = 0;
        while (i < nodes.size()){
            // 层序遍历
            ANode anode = nodes.get(i++);
            if (anode.node != null){
                nodes.add(new ANode(anode.node.left, anode.code * 2));
                nodes.add(new ANode(anode.node.right, anode.code * 2 + 1));
            }
        }
        // 只要判断list中的个数是否等于按从1开始的编号，也即没有跳号
        return nodes.get(i - 1).code == nodes.size();
    }

    class ANode {  // Annotated Node
        // 为每个树节点添加编号
        TreeNode node;
        int code;

        ANode(TreeNode node, int code) {
            this.node = node;
            this.code = code;
        }
    }

}
