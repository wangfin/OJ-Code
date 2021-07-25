package LeetCode98;

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
     * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
     * 假设一个二叉搜索树具有如下特征：
     * 节点的左子树只包含小于当前节点的数。
     * 节点的右子树只包含大于当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     *
     * 简单思路：按性质来，对于每一个结点，检查结点左子树中值最大的结点的值是否小于结点，右子树中值最小的结点是否大于结点。
     *
     * 换个思路：
     * 二叉排序树的中序遍历结果是一个有序数组，且有序数组的前一个元素一定小于后一个元素。
     * 在进行中序遍历时，我们可以通过使用在递归调用函数中传入一个用于保存当前访问结点前一个结点值的整型变量 pre ，
     * 如果当前访问结点的值小于或者等于他的前驱结点的值，则该树不是二叉排序树。
     *
     */
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {

        // 空的
        if (root == null){
            return true;
        }
        // 中序遍历，左中右
        // 访问左子树
        if (!isValidBST(root.left)){
            return false;
        }
        // 访问当前节点，如歌当前节点小于等于前一个节点，说明不满足BST
        if (root.val <= pre){
            return false;
        }
        pre = root.val;
        return isValidBST(root.right);

    }



}
