package LeetCode235;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
     * 百度百科中最近公共祖先的定义为：
     * “对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     *
     * 本题与LeetCode236不同的是，本题是二叉搜索树
     * 普通的二叉树利用回溯从底向上搜索，遇到一个节点的左子树里有p，右子树里有q，那么当前节点就是最近公共祖先。
     * 本题是二叉搜索树，二叉搜索树是有序的
     * 其实只要从上到下遍历的时候，cur节点是数值在[p, q]区间中则说明该节点cur就是最近公共祖先了。
     * 可使用递归或者循环
     * 1. 确定递归函数返回值以及参数
     * 参数就是当前节点，以及两个结点 p、q。
     * 返回值是要返回最近公共祖先，所以是TreeNode * 。
     * 2.确定终止条件
     * 遇到空返回就可以了，代码如下：
     * if (cur == NULL) return cur;
     * 其实都不需要这个终止条件，因为题目中说了p、q 为不同节点且均存在于给定的二叉搜索树中。
     * 也就是说一定会找到公共祖先的，所以并不存在遇到空的情况。
     * 3.确定单层递归的逻辑
     * 在遍历二叉搜索树的时候就是寻找区间[p.val, q.val]（注意这里是左闭右闭）
     * 如果 cur.val > p.val，同时 cur.val > q.val，那么就应该向左遍历（说明目标区间在左子树上）。
     * 如果 cur.val < p.val，同时 cur.val < q.val，那么就应该向右遍历（目标区间在右子树）。
     * 剩下的情况，就是cur节点在区间（p.val <= cur.val && cur.val <= q.val）或者
     * （q.val <= cur.val && cur.val <= p.val）中，那么cur就是最近公共祖先了，直接返回cur。
     *
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(true){
            if (root.val > p.val && root.val > q.val){
                root = root.left;
            }else if (root.val < p.val && root.val < q.val){
                root = root.right;
            }else {
                break;
            }
        }
        return root;
    }
}
