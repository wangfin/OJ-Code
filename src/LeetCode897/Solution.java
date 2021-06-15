package LeetCode897;

import sun.reflect.generics.tree.Tree;

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
     * 给你一棵二叉搜索树，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，
     * 使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
     *
     */
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        // 排序
        inorder(root, res);

        // 有了结果res之后，开始构建树
        TreeNode dummyHead = new TreeNode(-1);
        TreeNode curNode = dummyHead;
        // 根据题目要求将res中的内容构建右节点
        for (int value:res){
            curNode.right = new TreeNode(value);
            curNode = curNode.right;
        }

        return dummyHead.right;
    }

    public void inorder(TreeNode node, List<Integer> res){
        if (node == null){
            return ;
        }
        // 递归左子树的内容，也就是一直到最小值
        inorder(node.left, res);
        // root
        res.add(node.val);
        // 右子树
        inorder(node.right, res);
    }
}
