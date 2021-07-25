package LeetCode25;

public class Solution {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * 给你一个链表，每k个节点一组进行翻转，请你返回翻转后的链表。
     * k是一个正整数，它的值小于或等于链表的长度。
     * 如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
     * 进阶：
     * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
     * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
     *
     * 思路，本题就是按着题意做就可以了，每k个结点翻转一次，翻转就是206的链表翻转
     * 重点是每k个节点翻转，需要找到翻转开始节点的前一个节点和翻转结束的节点的下一个
     * pre start end next
     *
     *
     */

    public ListNode reverseKGroup(ListNode head, int k) {
        // 为了避免头结点错误，设置虚拟头结点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        // pre为翻转头节点的前一个节点
        ListNode pre = dummyHead;
        // end为翻转结束尾节点
        ListNode end = dummyHead;

        while (end.next != null){
            // 先把end移动到翻转结束的位置
            for (int i = 0; i < k && end != null; i++)
                end = end.next;

            if (end == null)
                break;

            // start为翻转头节点
            ListNode start = pre.next;
            // next为翻转尾节点的下一跳节点
            ListNode next = end.next;

            // 断开end的连接
            end.next = null;
            pre.next = null;

            // 翻转链表，并连上连接
            pre.next = reverse(start);
            // start节点就是尾节点了
            start.next = next;

            // 向后移动，跳到这个k个结点后面
            pre = start;
            end = pre;

        }

        return dummyHead.next;

    }

    // 206链表翻转
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }


}
