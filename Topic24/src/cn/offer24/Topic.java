package cn.offer24;

public class Topic {

	public static void main(String[] args) {
		ListNode head = creatList(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		head = reverseList(head);
		printList(head);
	}

	/**
	 * ·´×ªÁ´±í
	 * 
	 * @param head
	 * @return
	 */
	public static ListNode reverseList(ListNode head) {
		ListNode left = null;
		ListNode right = head;
		ListNode tmp = head;

		while (right != null) {
			tmp = right;
			right = right.next;
			tmp.next = left;
			left = tmp;
		}

		return left;
	}

	public static void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static ListNode creatList(int[] array) {
		if (array.length == 0)
			return null;

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