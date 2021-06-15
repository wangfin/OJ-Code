package LeetCode02;

class Solution {
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
     * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
     *
     * 如果使用将l1,l2中的数字先读取出来，然后在相加，最后在倒序输出这种方式会导致超时，所以考虑其他方法
     *
     * 由于输入的两个链表都是逆序存储数字的位数的，因此两个链表中同一位置的数字可以直接相加。
     * 同时遍历两个链表，逐位计算它们的和，并与当前位置的进位值相加。
     * 具体而言，如果当前两个链表处相应位置的数字为 n1,n2，进位值为 carry，则它们的和为 n1+n2+carry；
     * 其中，答案链表处相应位置的数字为 (n1+n2+carry)mod10，而新的进位值为 向下取整（n1+n2+carry/10）
     * 如果两个链表的长度不同，则可以认为长度短的链表的后面有若干个 0 。
     * 此外，如果链表遍历结束后，有 carry>0，还需要在答案链表的后面附加一个节点，节点的值为 carry。
     *
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 设置输出
        ListNode head = null;
        ListNode cur = null;
        // 设置进位值
        int carry = 0;
        while (l1 != null || l2 != null){
            // 取出该位置的值
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            // 将该位的值置入链表
            if (head == null){
                head = new ListNode(sum % 10);
                // 这里需要重新指一下cur
                cur = head;
            }else{
                cur.next = new ListNode(sum % 10);
                cur = cur.next;
            }
            // 更新下一位的carry值
            carry = sum / 10;
            // 遍历l1,l2
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

        }
        // 如果最后carry!=0，还有一个进位值，那就再创建一位
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
