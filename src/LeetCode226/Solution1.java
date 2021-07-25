package LeetCode226;

import java.util.ArrayDeque;

public class Solution1 {
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
     * BFS广度优先遍历
     *
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {return null;}
        // 双端队列
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        // 加入队尾
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                // 队首取出并删除，还是先进先出
                TreeNode node = deque.poll();
                // 交换左右子树
                swap(node);
                if (node.left != null) {deque.offer(node.left);}
                if (node.right != null) {deque.offer(node.right);}
            }
        }
        return root;
    }

    public void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
