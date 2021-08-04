package LeetCode445;

import java.util.LinkedList;
import java.util.Stack;

public class Solution {

    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
     * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
     * 进阶：如果输入链表不能修改该如何处理？换句话说，不能对列表中的节点进行翻转。
     *
     * 这道题与LeetCode02相似，不过02的题目是从头加到尾（也就是从个位数开始），符合正常的加法逻辑
     * 这道题是需要从尾部开始，也就是需要翻转，或者是逆序，但是题目不能对输入链表进行翻转，只能采用逆序的方法
     *
     * 所以题解的推荐做法就是使用了栈，用来逆序
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 构建两个栈用于逆序
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        // 设置输出
        ListNode head = null;

        // 将两个链表的值逆序输入stack
        while (l1 != null){
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            stack2.push(l2.val);
            l2 = l2.next;
        }

        // 设置进位符
        int carry = 0;
        // 开始相加
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0){
            // 空了的栈补0
            int num1 = stack1.isEmpty() ? 0: stack1.pop();
            int num2 = stack2.isEmpty() ? 0: stack2.pop();

            int sum = num1 + num2 + carry;

            // 将该位的值置入链表
            // 此处需要注意，输出的值是逆序的，所以需要逆序插入链表
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;

            // 更新下一位的carry值
            carry = sum / 10;
        }
        return head;
    }

}
