package cn.offer18;

public class Topic {

    static ListNode head = null;

    public static void main(String[] args) {
        head = creatList(new int[] {1, 1, 2, 3, 3, 4, 5, 5});
        // ListNode delNode = search(0);
        // deleteNode(delNode);

        head = deleteDuplication(head);
        System.out.println();
    }

    /**
     * ɾ���������ظ��Ľڵ㣬�˴����ظ���ָ�������ظ������м���������ظ�
     */
    public static ListNode deleteDuplication(ListNode pHead) {
        ListNode pre = null;
        ListNode p = pHead;
        while (p != null) {
            boolean isDuplication = false;
            while (p.next != null && p.val == p.next.val) {
                p = p.next;
                isDuplication = true;
            }

            if (isDuplication) {
                if (pre == null) {
                    pHead = p.next;
                } else {
                    pre.next = p.next;
                }
                p = p.next;
            } else {
                pre = p;
                p = pre.next;
            }

        }

        return pHead;
    }

    /**
     * ɾ��ָ���ڵ�
     * 
     * @param delNode
     */
    public static void deleteNode(ListNode delNode) {
        if (delNode == null)
            return;

        ListNode tmp = delNode.next;
        if (delNode.next != null) {
            delNode.val = delNode.next.val;
            delNode.next = delNode.next.next;
            tmp.next = null;
        } else if (head == delNode && delNode.next == null) {
            head = null;
        } else {
            tmp = head;
            while (tmp.next != delNode) {
                tmp = tmp.next;
            }
            tmp.next = null;
        }
    }

    public static ListNode search(int value) {
        ListNode p = head;
        while (p != null && p.val != value)
            p = p.next;
        return p;
    }

    public static ListNode creatList(int[] array) {
        ListNode head = new ListNode();
        head.val = array[0];
        head.next = null;
        ListNode p = head;
        for (int i = 1; i < array.length; i++) {
            ListNode tmp = new ListNode();
            tmp.val = array[i];
            tmp.next = null;
            p.next = tmp;
            p = p.next;
        }
        return head;
    }

}

class ListNode {
    int val;
    ListNode next;
}