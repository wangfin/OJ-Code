package Tenxun;
import java.util.*;

public class Main04 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode solve (TreeNode root, int[][] b) {
        // write code here
        for(int i = 0; i < b.length; i++){
            TreeNode x = findnode(root, b[i][0]);
            TreeNode y = findnode(root, b[i][1]);

//            if (!isSon(x, y)){
//
//            }
        }


        return root;

    }

    public static TreeNode findnode(TreeNode root ,int val){
        // 根据val找到这个节点
        if (root != null){
            if (root.val == val)
                return root;

            findnode(root.left, val);
            findnode(root.right, val);

        }
        return null;
    }

//    public static boolean isSon(TreeNode a, TreeNode b){
//        boolean res = true;
//        if (a.left != null || a.right != null){
//
//        }
//
//
//    }

    public static void ExchangeLeftRight(TreeNode node){
        if (node == null)
            return;

        if (node.left == null && node.right == null){
            return;
        }else{
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        ExchangeLeftRight(node.left);
        ExchangeLeftRight(node.right);
    }
}
