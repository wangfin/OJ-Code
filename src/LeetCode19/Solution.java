package LeetCode19;

public class Solution {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     * 进阶：你能尝试使用一趟扫描实现吗？
     *
     * 输入：head = [1,2,3,4,5], n = 2
     * 输出：[1,2,3,5]
     *
     * 简单想法：
     * 简单的思路就是，简单的过两遍，第一遍找到正序时的位置，第二遍删除
     * 优化：
     * 双指针的经典应用，如果要删除倒数第n个节点，让fast移动n步，然后让fast和slow同时移动，直到fast指向链表末尾。
     * 删掉slow所指向的节点就可以了。
     * 也就是维持一个固定值大小的窗口，一端到尾部，另一端就就是倒数第n个
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 先设置虚拟头节点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        // 设置快慢指针
        ListNode fast = dummyNode;
        ListNode slow = dummyNode;
        // 只要n没有到0，fast就向右边移动
        // fast先移动到位置
        while (n > 0){
            fast = fast.next;
            n--;
        }
        // 获得删除节点的pre
        ListNode preNode = null;
        while (fast != null){
            preNode = slow;
            slow = slow.next;
            fast = fast.next;
        }
        // 上一节点的next指针绕过 待删除节点slow 直接指向slow的下一节点
        preNode.next = slow.next;
        // 释放 待删除节点slow 的next指针, 这句删掉也能AC
        slow.next = null;

        return dummyNode.next;
    }
}
