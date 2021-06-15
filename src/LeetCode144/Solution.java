package LeetCode144;

import java.util.*;

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
     * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
     * 前序遍历：根，左子节点，右子节点
     * 144.二叉树的前序遍历
     * 145.二叉树的后序遍历
     * 94.二叉树的中序遍历
     *
     * 递归写法
     * 1.确定递归函数的参数和返回值
     * 2.确定终止条件
     * 3.确定单层递归的逻辑
     */
    // 递归写法
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        traversal(root, res);
//        return res;
//    }
//    public void traversal(TreeNode cur,  List<Integer> res){
//        if (cur == null){
//            return;
//        }
//        res.add(cur.val);
//        // 左
//        traversal(cur.left, res);
//        // 右
//        traversal(cur.right, res);
//    }

    // 非递归写法，也就是迭代，使用栈
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return res;
    }


}
