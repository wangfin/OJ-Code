package LeetCode92;

class Solution {
    /**
        Definition for singly-linked list.
    */
    public class ListNode { 
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
     * 这个是206题目的升级版，206是反转全部的链表
     * 这是反转一部分的链表
     *
     * 目前的想法是，截取m到n的链表，做全部的反转，然后接回原来的链表
     */

    public ListNode reverseBetween(ListNode head, int left, int right) {
        /// 因为头节点有可能发生变化，使用虚拟头节点可以避免复杂的分类讨论
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        // 第 1 步：从虚拟头节点走 left - 1 步，来到 left 节点的前继节点
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        // 第 2 步：从 pre 再走 right - left + 1 步，来到 right 节点
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        // 第 3 步：切断出一个子链表（截取链表）
        // 切出来的链表的左节点
        ListNode leftNode = pre.next;
        // 切出来的链表的右节点的后继节点
        ListNode succ = rightNode.next;

        // 注意：切断链接
        pre.next = null;
        rightNode.next = null;

        // 第 4 步：同第 206 题，反转链表的子区间
        reverseList(leftNode);

        // 第 5 步：接回到原来的链表中
        pre.next = rightNode;
        leftNode.next = succ;

        return dummyNode.next;
    }

    public void reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
    }
}
