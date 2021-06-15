package LeetCode148;

public class Solution {

    /**
     * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
     * 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
     */

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // 这道题的重点就是在链表中插入排序算法，而本题要求  可以在 O(n log n) 时间复杂度和常数级空间复杂度下
    // 所以就是对排序算法有要求，
    // 时间复杂度是 O(n logn) 的排序算法包括归并排序、堆排序和快速排序（快速排序的最差时间复杂度是 O(n^2))
    // 其中最适合链表的排序算法是归并排序

    public ListNode sortList(ListNode head) {
        

        return head;
    }

}
