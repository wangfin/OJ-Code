package LeetCode114;


import javax.swing.table.TableRowSorter;
import java.util.ArrayList;

public class Solution {
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
     * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
     *
     * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
     * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
     *
     * 简单就是递归先序遍历，然后构造二叉树
     *
     */
    public void flatten(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        preorderTraversal(root, list);

        // 获取到list这个前序遍历的结果，开始构造二叉树
        for (int i = 1; i < list.size(); i++){
            TreeNode pre = list.get(i-1);
            TreeNode cur = list.get(i);
            pre.left = null;
            pre.right = cur;
        }


    }

    public void preorderTraversal(TreeNode root, ArrayList<TreeNode> list){
        // 根，左，右
        if (root != null){
            list.add(root);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
    }
}
