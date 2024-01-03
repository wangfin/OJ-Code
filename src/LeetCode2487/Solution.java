package LeetCode2487;

/**
 * @Author wangfin
 * @Date 2024/1/3
 * @Desc LeetCode5487
 */
public class Solution {


    public static class ListNode {
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
     * 给你一个链表的头节点 head
     * 移除每个右侧有一个更大数值的节点
     * 返回修改后链表的头节点 head
     * <p>
     * 解题思路：
     * 反向遍历数组，遇到比自己小的就删除
     */

    public ListNode removeNodes(ListNode head) {
        // 翻转列表
        head = reverseList(head);

        ListNode cur = head;
        ListNode next = head.next;
        while (next != null) {
            // 如果当前值的val大于下一个值，则继续遍历next
            // 因为大于的这些点需要被移除，所以要找到小于等于的，将连接指向他
            if (cur.val > next.val) {
                cur.next = next.next;
            } else {
                // 如果没有，则吧cur向后挪一个
                cur = next;
            }
            next = next.next;
        }

        return reverseList(head);
    }


    /**
     * 翻转列表
     * 也就是把next指针写反
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        return pre;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(8);
        ListNode listNode2 = new ListNode(3, listNode1);
        ListNode listNode3 = new ListNode(13, listNode2);
        ListNode listNode4 = new ListNode(2, listNode3);
        ListNode listNode5 = new ListNode(5, listNode4);

        Solution solution = new Solution();
        System.out.println(solution.removeNodes(listNode5).toString());
    }

}
