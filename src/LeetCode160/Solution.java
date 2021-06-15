package LeetCode160;

import java.util.HashSet;
import java.util.Set;


public class Solution {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 编写一个程序，找到两个单链表相交的起始节点。
     * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
     * 输出：Reference of the node with value = 8
     * 输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
     * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
     *
     * 方法1：HashSet，判断两个链表是否有重复的元素
     * 方法2：双指针，这个也有两种思路
     * 第一个是，在A链表的头节点设置指针，在B链表中设置指针，然后将B链表的指针与A链表的指针对齐，然后两个指针一起移动
     * 第二个，AHead设置指针，BHead设置指针，双指针一起移动，一个移动完就把指针移动到另一个链表的头节点开始
     * 例如，A移动完，就从B头节点开始，如果A指针与B指针相遇
     * 若相交，链表A： a+c, 链表B : b+c. a+c+b+c = b+c+a+c 。则会在公共处c起点相遇。若不相交，a +b = b+a 。因此相遇处是NULL
     */
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        // 采用Set的方式，将两个链表分别插入Set，判断Set中是否有重复的部分
//        Set<ListNode> set = new HashSet<>();
//        while (headA != null){
//            set.add(headA);
//            headA = headA.next;
//        }
//        while (headB != null){
//            if(set.contains(headB)){
//                return headB;
//            }
//            headB = headB.next;
//        }
//        return null;
//    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        // A指针与B指针是否相等
        while (pA != pB) {
            // 如果某个指针到末尾null了，那么就换到另一个链表的头节点
            pA = (pA == null) ? headB : pA.next;
            pB = (pB == null) ? headA : pB.next;
        }
        return pA;
    }

}
