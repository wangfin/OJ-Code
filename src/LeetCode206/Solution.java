package LeetCode206;

import java.util.ArrayList;

class Solution {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 目标：需要将一个单链表进行反转
     * 解题思路：因为链表是单向的，一个节点只保存了下一跳节点的连接，如果需要反转，
     * 则需要保存上一跳节点，同时需要一个虚拟节点保存该节点的next，也就是下一跳节点的连接，
     * 然后将该节点的next改为上一个节点，
     * 然后将链表进行循环遍历
     * @param head 输入的单链表
     * @return 反转链表
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    /**
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     * @param head
     * @return 反转链表输出
     */
    public int[] reversePrint(ListNode head) {
        ArrayList<Integer> Listtmp = reverse(head);

        int[] res = new int[Listtmp.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = Listtmp.get(i);
        }
        return res;
    }

    public ArrayList<Integer> reverse(ListNode head) {

        ArrayList<Integer> Listtmp = new ArrayList<>();

        ListNode pre = null;
        ListNode cur = head;

        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
            Listtmp.add(cur.val);
        }
        return Listtmp;
    }


}
