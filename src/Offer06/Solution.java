package Offer06;

import java.util.ArrayList;

class Solution {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
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

