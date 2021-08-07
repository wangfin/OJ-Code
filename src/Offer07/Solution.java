package Offer07;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     *
     * 前序遍历性质： 节点按照 [ 根节点 | 左子树 | 右子树 ] 排序。
     * 中序遍历性质： 节点按照 [ 左子树 | 根节点 | 右子树 ] 排序。
     *
     * 分治算法解析：
     * 1.递推参数： 根节点在前序遍历的索引 root 、子树在中序遍历的左边界 left 、子树在中序遍历的右边界 right ；
     * 2.终止条件： 当 left > right ，代表已经越过叶节点，此时返回 nullnull ；
     * 3.递推工作：
     *   1.建立根节点 node ： 节点值为 preorder[root] ；
     *   2.划分左右子树： 查找根节点在中序遍历 inorder 中的索引 i ；
     *   3.构建左右子树： 开启左右子树递归；
     *
     */

    public TreeNode buildTree(int[] preorder, int[] inorder) {

    }
}
