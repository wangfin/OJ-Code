package LeetCode707;

public class MyLinkedList {
    /**
     * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val和next。
     * val是当前节点的值，next是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性prev以指示链表中的上一个节点。
     * 假设链表中的所有节点都是 0-index 的。
     *
     * 在链表类中实现这些功能：
     *
     * get(index)：获取链表中第index个节点的值。如果索引无效，则返回-1。
     * addAtHead(val)：在链表的第一个元素之前添加一个值为val的节点。插入后，新节点将成为链表的第一个节点。
     * addAtTail(val)：将值为val 的节点追加到链表的最后一个元素。
     * addAtIndex(index,val)：在链表中的第index个节点之前添加值为val 的节点。如果index等于链表的长度，则该节点将附加到链表的末尾。
     * 如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
     * deleteAtIndex(index)：如果索引index 有效，则删除链表中的第index 个节点。
     */

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(){};
        ListNode(int val) { this.val = val; }
    }

    // size存储链表元素的个数
    int size;
    // 虚拟头结点
    ListNode dummyHead;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        // 初始化链表
        this.size = 0;
        this.dummyHead = new ListNode(0);
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        //获取第index个节点的数值
        if (index < 0 || index >= this.size){
            return -1;
        }
        ListNode currentNode = this.dummyHead;
        // 包含一个虚拟头结点，所以查找第index+1个结点
        for (int i = 0; i < index+1; i++){
            currentNode = currentNode.next;
        }
        return currentNode.val;

    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        // 在链表前面插入一个节点
        addAtIndex(0, val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        // 在链表前面插入一个节点
        addAtIndex(this.size, val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        // 在第 index 个节点之前插入一个新节点，例如index为0，那么新插入的节点为链表的新头节点。
        // 如果 index 等于链表的长度，则说明是新插入的节点为链表的尾结点
        // 如果 index 大于链表的长度，则返回空
        if (index > this.size)
            return;
        // 小于0在头部
        if (index < 0)
            index = 0;
        this.size++;
        // 找到要插入的节点的前驱
        ListNode preNode = this.dummyHead;
        for (int i = 0; i < index; i ++){
            preNode = preNode.next;
        }
        ListNode toAdd = new ListNode(val);
        // 加入节点的next接到pre的next
        toAdd.next = preNode.next;
        preNode.next = toAdd;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        // 删除第index个节点
        if (index < 0 || index >= this.size){
            return;
        }
        this.size--;
        ListNode preNode = this.dummyHead;
        // 断开连接
        for (int i = 0; i < index; i ++){
            preNode = preNode.next;
        }
        preNode.next = preNode.next.next;
    }
}
