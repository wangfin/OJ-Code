package LeetCode203;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

     // 不使用虚拟头结点
     public ListNode removeElements(ListNode head, int val) {
         // 如果链表的头结点是需要删除的点
         while(head != null && head.val == val)
             head = head.next;

         // 如果删除头结点之后整个链表为空
         if(head == null)
             return null;

         ListNode prev = head;
         while (prev.next != null){
             if (prev.next.val == val){
                 prev.next = prev.next.next;
             }else{
                 prev = prev.next;
             }
         }
         return head;
    }
}
