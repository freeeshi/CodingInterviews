package cn.offer52;

import java.util.Stack;

public class Topic {

    public static void main(String[] args) {
        // ţ�Ͳ���
    }

    /**
     * ��������ĵ�һ�������ڵ㣬����Ŀ��Ҫ���ǣ��������������һ�������ڵ㣬�Ǵ˽ڵ��Լ���ߵı�Ȼ���ǹ�����
     * �����ջ�Ļ�����Ҫ����Ŀռ䣬������O(1)�Ŀռ临�Ӷ������
     * �������������ĳ��ȣ��Լ����Ȳ�step��Ȼ���ٴα������������������ó�����������step�Σ�Ȼ����������ͬ������
     * �������ָ�����ʱ�����ǹ����ڵ���
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
     * ��������ĵ�һ�������ڵ㣬����Ŀ��Ҫ�����ǣ��������������һ�������ڵ㣬�Ǵ˽ڵ��Լ���ߵı�Ȼ���ǹ�����
     * �����뵽�Ӻ���ǰ��������������ҵ��Ǹ������ڵ㣬��Ҫ����ջ��ʵ��
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