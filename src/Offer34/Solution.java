package Offer34;

import java.util.*;
public class Solution {

    // Definition for a binary tree node.
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
     * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
     * 叶子节点 是指没有子节点的节点。
     *
     * 本问题是典型的二叉树方案搜索问题，使用回溯法解决，其包含 先序遍历 + 路径记录 两部分。
     *
     * 先序遍历： 按照 “根、左、右” 的顺序，遍历树的所有节点。
     * 路径记录： 在先序遍历中，记录从根节点到当前节点的路径。
     * 当路径为 ① 根节点到叶节点形成的路径 且 ② 各节点值的和等于目标值 sum 时，将此路径加入结果列表。
     *
     * 值得注意的是，记录路径时若直接执行 res.append(path) ，则是将 path 对象加入了 res ；后续 path 改变时， res 中的 path 对象也会随之改变。
     * 正确做法：res.append(list(path)) ，相当于复制了一个 path 并加入到 res 。
     *
     */
    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum);
        return res;
    }

    void recur(TreeNode root, int target){
        if (root == null) return;
        // 添加路径值
        path.add(root.val);
        target -= root.val;
        // 找到这个值，并且他得是叶子节点
        if (target == 0 && root.left == null && root.right == null){
            // 如果只是存入path，path会改变
            // 相当于复制了一个 path 并加入到 res
            res.add(new LinkedList<>(path));
        }
        // 前左右，也就是先序遍历
        recur(root.left, target);
        recur(root.right, target);
        // 回溯
        path.removeLast();

    }

}
