package LeetCode203;

public class Solution3 {

    // 使用虚拟头结点
    public ListNode removeElements(ListNode head, int val) {

        // 使用递归的方式
        if(head == null)
            return null;

//        ListNode res = removeElements(head.next, val);
//        if(head.val == val)
//            return res;
//        else{
//            head.next = res;
//            return head;
//        }

        head.next = removeElements(head.next, val);
        if(head.val == val)
            return head.next;
        else
            return head;

    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 6, 3, 4, 5, 6};

        ListNode head = new ListNode(nums);

        System.out.println(head);

        ListNode res = (new Solution3()).removeElements(head, 6);

        System.out.println(res);

    }
}
