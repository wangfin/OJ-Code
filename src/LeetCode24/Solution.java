package LeetCode24;

public class Solution {
    /**
     * Definition for singly-linked list.
     */

    public class ListNode {
        int val;
        ListNode next;
        ListNode() { }
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     * 输入：head = [1,2,3,4]
     * 输出：[2,1,4,3]
     * 输入：head = [1]
     * 输出：[1]
     *
     * 交换节点，也就是交换ListNode的next
     */

    public ListNode swapPairs(ListNode head) {
        // 设置虚拟头结点，就可以避开头结点问题
        ListNode dummyNode = new ListNode(0);
        // 虚拟头结点的下一个节点就是head
        dummyNode.next = head;
        // 从虚拟头结点开始
        ListNode prev = dummyNode;

        // 有能够交换的节点
        while (prev.next != null && prev.next.next != null){
            // 保存第二个节点，因为第二个的next是当前不需要交换的节点，也就是外部节点
            ListNode temp = head.next.next;
            // 虚拟头结点的next指向第二个节点
            prev.next = head.next;
            // 第二个节点指向第一个节点
            head.next.next = head;
            // 第一个节点指向外部节点
            head.next = temp;
            // 移动prev和head
            prev = head;
            head = head.next;
        }
        return dummyNode.next;
    }
}
