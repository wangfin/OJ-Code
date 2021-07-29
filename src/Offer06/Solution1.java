package Offer06;
import Offer06.Solution.ListNode;

import java.util.LinkedList;

public class Solution1 {
    // 堆栈法
    public int[] reversePrint(ListNode head) {
        // 创建堆栈
        LinkedList<Integer> stack = new LinkedList<Integer>();
        // 遍历链表
        while(head != null) {
            stack.addLast(head.val);
            head = head.next;
        }
        // 将栈的内容输出结果
        int[] res = new int[stack.size()];
        for(int i = 0; i < res.length; i++)
            res[i] = stack.removeLast();
        return res;
    }

}
