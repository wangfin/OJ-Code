package BinaryTree;

import java.util.ArrayList;

public class RecursiveTraversal {
    /**
     * 二叉树的递归遍历
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
     * 递归三要素
     *   1.确定递归函数的参数和返回值：确定哪些参数是递归的过程中需要处理的，那么就在递归函数里加上这个参数，
     *   并且还要明确每次递归的返回值是什么进而确定递归函数的返回类型。
     *   2.确定终止条件：写完了递归算法, 运行的时候，经常会遇到栈溢出的错误，就是没写终止条件或者终止条件写的不对，
     *   操作系统也是用一个栈的结构来保存每一层递归的信息，如果递归没有终止，操作系统的内存栈必然就会溢出。
     *   3.确定单层递归的逻辑：确定每一层递归需要处理的信息。在这里也就会重复调用自己来实现递归的过程。
     */

    // 前序遍历，中左右
    ArrayList<Integer> preOrderReverse(TreeNode root) {
        // 返回结果
        ArrayList<Integer> result = new ArrayList<Integer>();
        // 递归
        preOrder(root, result);
        return result;
    }

    void preOrder(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        // 将中值加入结果中
        result.add(root.val);           // 注意这一句
        // 左子树
        preOrder(root.left, result);
        // 右子树
        preOrder(root.right, result);
    }

    // 中序遍历
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    void inorder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);             // 注意这一句
        inorder(root.right, list);
    }

    // 后序遍历
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    void postorder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.val);             // 注意这一句
    }

}
