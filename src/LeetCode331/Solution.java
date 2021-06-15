package LeetCode331;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    /**
     * 序列化二叉树的一种方法是使用前序遍历。
     * 当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
     * 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。
     * 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
     * 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
     * 你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如"1,,3" 。
     *
     * 看了一眼标签，是栈，那就和昨天那个简易计算器一样了
     * 因为前序遍历是有规律的，正好对应于栈的存入取出
     * 输入一个数字作为根节点，需要消耗一个空位，加入两个空位
     * 输入一个#，则是直接消耗一个空位
     * 最后判读栈中是否有空位，或者在进行的过程中是否没有空位了
     *
     */
    public boolean isValidSerialization(String preorder) {
        // 使用逗号分割字符串
        String[] preorder_list = preorder.split(",");
        Stack<String> stack =  new Stack<String>();
        // 初始化一个位置
        stack.push("#");
        // 判断分割好的字符串
        for(int i = 0 ; i < preorder_list.length; i++){
            // 如果不是#，那就是正常的节点，那就是-1个位置，+2个位置
            if(!preorder_list[i].equals("#")){
                // 堆栈不为空
                if(!stack.isEmpty()){
                    stack.pop();
                    stack.push("#");
                    stack.push("#");
                }else{
                    return false;
                }
            }else{// 输入的是#
                // 堆栈不为空
                if(!stack.isEmpty()){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }

        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }

    }

    public static void main(String[] args) {
        String preorder = "1,#";
        boolean res = new Solution().isValidSerialization(preorder);
        System.out.println(res);
    }
}
