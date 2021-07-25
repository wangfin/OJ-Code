package LeetCode226;

public class Solution {
    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        Solution.TreeNode left;
        Solution.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, Solution.TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 翻转一棵二叉树。
     * 注意只要把每一个节点的左右孩子翻转一下，就可以达到整体翻转的效果
     * 这道题目使用前序遍历和后序遍历都可以，唯独中序遍历不行，因为中序遍历会把某些节点的左右孩子翻转了两次！
     */
    public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            invertTree(root.left);
            invertTree(root.right);
            swapChildren(root);
            return root;
        }

    private void swapChildren(TreeNode root) {
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }
}
