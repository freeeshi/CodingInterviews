package cn.offer52;

import java.util.Stack;

public class Topic {

    public static void main(String[] args) {
        // 牛客测试
    }

    /**
     * 两个链表的第一个公共节点，此题目的要点是，如果两个链表有一个公共节点，那此节点以及后边的必然都是公共的
     * 如果用栈的话，需要额外的空间，这里用O(1)的空间复杂度来完成
     * 先求出两个量表的长度，以及长度差step，然后再次遍历两个链表，条件是让长的量表先走step次，然后两个链表同步遍历
     * 最后当两个指针相等时，就是公共节点了
     * 
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode findFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null)
            return null;

        int len1 = 0, len2 = 0;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != null) {
            p1 = p1.next;
            len1++;
        }
        while (p2 != null) {
            p2 = p2.next;
            len2++;
        }

        int step = len1 - len2;
        p1 = pHead1;
        p2 = pHead2;
        if (step > 0) {
            for (int i = 0; i < step; i++, p1 = p1.next);
        } else {
            step = -step;
            for (int i = 0; i < step; i++, p2 = p2.next);
        }

        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }

    /**
     * 两个链表的第一个公共节点，此题目的要点是是，如果两个链表有一个公共节点，那此节点以及后边的必然都是公共的
     * 容易想到从后往前遍历链表很容易找到那个公共节点，需要两个栈来实现
     * 
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode findFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null)
            return null;

        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();

        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != null) {
            stack1.push(p1);
            p1 = p1.next;
        }
        while (p2 != null) {
            stack2.push(p2);
            p2 = p2.next;
        }
        while (pHead1 != null) {
            stack1.push(pHead1);
            pHead1 = pHead1.next;
        }

        p1 = stack1.pop();
        p2 = stack2.pop();
        ListNode result = null;
        while (!stack1.isEmpty() && !stack2.isEmpty() && p1 == p2) {
            result = p1;
            p1 = stack1.pop();
            p2 = stack2.pop();
        }

        if (stack1.isEmpty() || stack2.isEmpty())
            result = p1;

        return result;
    }

}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}