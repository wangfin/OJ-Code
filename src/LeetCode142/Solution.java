package LeetCode142;

public class Solution {
    /**
     * Definition for singly-linked list.
     * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     */

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // 题解中给了两种做法，一种是使用哈希表，把节点保存在哈希表中，当经过重复的点时，可以判断存在环
    // 双指针，设置一快一慢两个指针，快的一次走两格，慢的一次走一格
    // 这类链表题目一般都是使用双指针法解决的，例如寻找距离尾部第K个节点、寻找环入口、寻找公共尾部入口等。
    // https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/linked-list-cycle-ii-kuai-man-zhi-zhen-shuang-zhi-/

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

}
