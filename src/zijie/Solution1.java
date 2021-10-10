package zijie;

import java.util.*;

public class Solution1 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] preorder = new int[n];
        int[] inorder = new int[n];
        for (int i = 0; i < n; i++){
            preorder[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++){
            inorder[i] = sc.nextInt();
        }

        TreeNode root = buildTree(preorder, inorder);



    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }

    public static boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> layer = new LinkedList<TreeNode>();
        ArrayList<TreeNode> compara = new ArrayList<TreeNode>();
        layer.add(root);
        while(!layer.isEmpty()){
            while(!layer.isEmpty()){
                TreeNode nowNode = layer.poll();
                if(nowNode == null) continue;
                compara.add(nowNode.left);
                compara.add(nowNode.right);
            }
            for(int left = 0,right = compara.size() - 1;left < right; left++,right--){
                if(compara.get(left) != null && compara.get(right) != null &&compara.get(left).val ==  compara.get(right).val){
                    continue;
                }else if(compara.get(left) == null && compara.get(right) == null){
                    continue;
                }else{
                    System.out.println();
                    return false;
                }
            }
            layer.addAll(compara);
            compara.clear();
        }
        return true;
    }

}
