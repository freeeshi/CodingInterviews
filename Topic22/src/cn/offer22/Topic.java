package cn.offer22;

public class Topic {

	public static void main(String[] args) {
		ListNode head = creatList(new int[] { 12, 4, 23, 6, 9, 33, 21 });
		System.out.println(findKthToTail(head, 3).value);
	}

	/**
	 * 找到链表中倒数第k个节点，有两种特殊情况需要考虑：1)k=0，2)k大于链表长度
	 * 
	 * @param head
	 * @param k
	 * @return
	 */
	public static ListNode findKthToTail(ListNode head, int k) {
		if (head == null || k <= 0)
			return null;

		ListNode left = null;
		ListNode right = head;
		int count = 0;
		for (count = 0; right != null && count != k; right = right.next, count++)
			;

		if (count != k)
			return null;

		left = head;
		while (right != null) {
			right = right.next;
			left = left.next;
		}

		return left;
	}

	public static ListNode creatList(int[] array) {
		ListNode head = new ListNode();
		head.value = array[0];
		head.next = null;
		ListNode p = head;
		for (int i = 1; i < array.length; i++) {
			ListNode tmp = new ListNode();
			tmp.value = array[i];
			tmp.next = null;
			p.next = tmp;
			p = p.next;
		}
		return head;
	}

}

class ListNode {
	int value;
	ListNode next;
}