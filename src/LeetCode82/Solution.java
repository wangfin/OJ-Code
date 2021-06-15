package LeetCode82;

public class Solution {
    /**
     * Definition for singly-linked list.
     */

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     *
     *存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中没有重复出现的数字。
     *
     * 返回同样按升序排列的结果链表。
     *
     * 有序数组查看是否有相同的，还是简单的，只要比较当前元素和后面的元素是否有相同的即可，如果有相同的就把后面的删除即可
     * 如果是无序数组，应该是需要hashmap
     *
     * 看错题目了，题目只要保留没有重复的数字，只要是重复了，全部删除，而不是留一个
     * 输入：head = [1,2,3,3,4,4,5]
     * 输出：[1,2,5]
     *
     */
    public ListNode deleteDuplicates(ListNode head) {
        // 链表为空
        if (head == null){
            return head;
        }

        // 构建虚拟头结点
        ListNode dummyHead = new ListNode(0, head);

        // 用这个节点遍历
        ListNode cur = dummyHead;

        // 保证下个节点和下下个节点不为空
        while (cur.next != null && cur.next.next != null){
            // 当前值与下一个的值相同
            if (cur.next.val == cur.next.next.val){
                // 如果有多个，一起删除
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            }else{
                cur = cur.next;
            }

        }

        return dummyHead.next;

    }




}
