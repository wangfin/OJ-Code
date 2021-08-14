package Offer25;

public class Solution {
    /**
     * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
     * 1.初始化： 伪头节点 dum，节点 cur 指向 dum 。
     * 2.循环合并： 当 l_1或 l_2为空时跳出；
     *   1.当 l_1.val < l_2.val 时： cur 的后继节点指定为 l_1，并 l_1 向前走一步；
     *   2.当 l_1.val ≥ l_2.val 时： cur 的后继节点指定为 l_2，并 l_2 向前走一步 ；
     *   3.节点 cur 向前走一步，即 cur = cur.next 。
     * 3.合并剩余尾部： 跳出时有两种情况，即 l_1为空 或 l_2为空。
     *   1.若 l_1 != null： 将 l_1添加至节点 cur 之后；
     *   2.否则： 将 l_2 添加至节点 cur 之后。
     * 4.返回值： 合并链表在伪头节点 dumdum 之后，因此返回 dum.nextdum.next 即可。
     */

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 设置虚拟头节点，和cur
        ListNode dum = new ListNode(0), cur = dum;
        // 开始遍历
        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return dum.next;
    }
    
}
