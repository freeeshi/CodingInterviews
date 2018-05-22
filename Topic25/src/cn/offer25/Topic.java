package cn.offer25;

public class Topic {

	public static void main(String[] args) {
		ListNode list1 = creatList(new int[] { 1, 3, 5 });
		ListNode list2 = creatList(new int[] { 2, 4, 6 });
		ListNode node = mergeWithSort(list1, list2);
		printList(node);
	}

	/**
	 * 合并两个升序排列的链表，合并后的链表也是升序
	 * 
	 * @param list1
	 * @param list2
	 * @return
	 */
	public static ListNode mergeWithSort(ListNode list1, ListNode list2) {
		if (list1 == null)
			return list2;
		if (list2 == null)
			return list1;

		ListNode head = new ListNode();
		ListNode curr = head;
		if (list1.value < list2.value) {
			head.value = list1.value;
			list1 = list1.next;
		} else {
			head.value = list2.value;
			list2 = list2.next;
		}

		while (list1 != null && list2 != null) {
			if (list1.value < list2.value) {
				curr.next = list1;
				list1 = list1.next;
			} else {
				curr.next = list2;
				list2 = list2.next;
			}
			curr = curr.next;
		}

		if (list1 == null)
			curr.next = list2;
		else
			curr.next = list1;

		return head;
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