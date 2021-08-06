package Offer37;

import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Queue;

public class Codec {
    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 请实现两个函数，分别用来序列化和反序列化二叉树。
     * 你需要设计一个算法来实现二叉树的序列化与反序列化。
     * 这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
     * 提示：输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅LeetCode 序列化二叉树的格式。
     * 你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
     *
     * 观察题目示例，序列化的字符串实际上是二叉树的 “层序遍历”（BFS）结果，所以采用层序遍历。
     * 为完整表示二叉树，考虑将叶节点下的 null 也记录。
     * 在此基础上，对于列表中任意某节点 node ，其左子节点 node.left 和右子节点 node.right 在序列中的位置都是 唯一确定 的。
     * 序列化 使用层序遍历实现。反序列化 通过以上递推公式反推各节点在序列中的索引，进而实现。
     *
     */

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        /**
         * 序列化 Serialize ：
         * 借助队列，对二叉树做层序遍历，并将越过叶节点的 null 也打印出来。
         *
         * 算法流程：
         * 特例处理： 若 root 为空，则直接返回空列表 "[]" ；
         * 初始化： 队列 queue （包含根节点 root ）；序列化列表 res ；
         * 层序遍历： 当 queue 为空时跳出；
         * 节点出队，记为 node ；
         * 若 node 不为空：① 打印字符串 node.val ，② 将左、右子节点加入 queue ；
         * 否则（若 node 为空）：打印字符串 "null" ；
         * 返回值： 拼接列表，用 ',' 隔开，首尾添加中括号；
         *
         */
        if (root == null)
            return "[]";
        // 构建输出
        StringBuilder res = new StringBuilder("[");
        // 队列用于层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        // 先加入根节点
        queue.add(root);
        // 开始遍历
        while (!queue.isEmpty()){
            // 弹出队列中的点，用于输入res中
            TreeNode node = queue.poll();
            if (node != null){
                res.append(node.val + ",");
                // 加入左右子节点，这就是层序遍历的过程
                queue.add(node.left);
                queue.add(node.right);
            }else{
                // 如果节点为null，表示没有这个节点，但是还是要输出出来
                res.append("null,");
            }
        }
        // 最后多一个逗号
        res.deleteCharAt(res.length() - 1);
        res.append("]");
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        /**
         * 基于本文开始推出的 node , node.left , node.right 在序列化列表中的位置关系，可实现反序列化。
         * 利用队列按层构建二叉树，借助一个指针 i 指向节点 node 的左、右子节点，每构建一个 node 的左、右子节点，指针 i 就向右移动 11 位。
         *
         * 算法流程：
         * 1.特例处理： 若 data 为空，直接返回 null ；
         * 2.初始化： 序列化列表 vals （先去掉首尾中括号，再用逗号隔开），指针 i = 1 ，根节点 root （值为 vals[0] ），队列 queue（包含 root ）；
         * 3.按层构建： 当 queue 为空时跳出；
         *   1.节点出队，记为 node ；
         *   2.构建 node 的左子节点：node.left 的值为 vals[i] ，并将 node.left 入队；
         *   3.执行 i += 1 ；
         *   4.构建 node 的右子节点：node.left 的值为 vals[i] ，并将 node.left 入队；
         *   5.执行 i += 1 ；
         * 4.返回值： 返回根节点 root 即可；
         *
         */
        // 空树
        if (data.equals("[]"))
            return null;
        // 去掉首尾的[]，然后按,划分
        String[] vals = data.substring(1, data.length() - 1).split(",");
        // 将字符串转换为数字
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        // 遍历queue
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            // 不为空，就在树中构造这个节点
            // 左节点
            if (!vals[i].equals("null")){
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.left);
            }
            // 如果为空就跳过
            i ++;
            // 右节点
            if(!vals[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.right);
            }
            i++;

        }
        return root;
    }

}
