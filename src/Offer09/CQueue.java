package Offer09;

import java.util.LinkedList;

public class CQueue {
    /**
     * 用两个栈实现一个队列。
     * 队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。
     * (若队列中没有元素，deleteHead操作返回 -1 )
     *
     * 栈无法实现队列功能： 栈底元素（对应队首元素）无法直接删除，需要将上方所有元素出栈。
     * 双栈可实现列表倒序： 设有含三个元素的栈 A = [1,2,3] 和空栈 B = []。
     * 若循环执行 A 元素出栈并添加入栈 B ，直到栈 A 为空，则 A = [] , B = [3,2,1] ，即 栈 B 元素实现栈 A 元素倒序 。
     * 利用栈 B 删除队首元素： 倒序后，B 执行出栈则相当于删除了 A 的栈底元素，即对应队首元素。
     *
     */
    // 构建两个链表
    LinkedList<Integer> A, B;
    public CQueue() {
        A = new LinkedList<>();
        B = new LinkedList<>();
    }

    public void appendTail(int value) {
        // 在队列末尾添加元素
        // 也就是正常在栈A中添加元素
        A.addLast(value);
    }

    public int deleteHead() {
        // 删除队列的头元素
        // 这里就需要A，B栈来回倒腾了
        // 也即使用B作为A的倒序栈，实现先进先出

        // 如果B不为空，直接导出B的末尾元素，也即队列的头元素
        if (!B.isEmpty())
            return B.removeLast();
        // A为空，B也为空，即整个队列没有元素
        if (A.isEmpty())
            return -1;
        // A不为空，B为空，将A中的元素导入B中
        while (!A.isEmpty()){
            B.addLast(A.removeLast());
        }

        return B.removeLast();

    }

}
