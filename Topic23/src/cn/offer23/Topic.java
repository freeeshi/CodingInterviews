package cn.offer23;

public class Topic {

	public static void main(String[] args) {
		ListNode head = createListWithRing(new int[] { 0 }, 0);
		int ringSize = findRingAndNum(head);
		ListNode entry = findEntry(head, ringSize);
		System.out.println(entry.value);

	}

	/**
	 * 找到链表中环的入口节点，需要知道环的节点个数N，设置两个指针，第一个先移动N-1次，让后两个一起移动，当两个指向同一个节点时，这个节点就是环的入口
	 * 
	 * @param head
	 * @param ringSize
	 * @return
	 */
	public static ListNode findEntry(ListNode head, int ringSize) {
		if (ringSize == 0)
			return null;

		ListNode p1 = head;
		ListNode p2 = head;
		for (int i = ringSize; i > 0; i--, p1 = p1.next)
			;

		for (; p1 != p2; p1 = p1.next, p2 = p2.next)
			;

		return p1;
	}

	/**
	 * 找到链表中环的节点个数：设置两个指针，一个慢一个快，当快的指针追上慢的的时候，快的停止，让慢的走一圈再到自己，就能统计出圈中环的个数
	 * 
	 * @param head
	 * @return
	 */
	public static int findRingAndNum(ListNode head) {
		if (head == null || head.next == null)
			return 0;
		ListNode slow = null;
		ListNode fast = null;
		for (slow = head, fast = head; fast != null && fast.next != null
				&& fast.next != slow; slow = slow.next, fast = fast.next.next)
			;

		if (fast == null || fast.next == null)
			return 0;

		int count = 1;
		for (ListNode tmp = slow.next; tmp != slow; tmp = tmp.next, count++)
			;

		return count;
	}

	/**
	 * 创建一个带环的链表，可以指定环的入口的节点
	 * 
	 * @param array
	 * @param entry
	 * @return
	 */
	public static ListNode createListWithRing(int[] array, int entry) {
		ListNode entryNode = null;
		int size = array.length;
		ListNode head = new ListNode();
		head.value = array[0];
		head.next = null;
		ListNode p = head;

		if (entry == 0)
			entryNode = head;

		for (int i = 1; i < size; i++) {
			ListNode tmp = new ListNode();
			tmp.value = array[i];
			tmp.next = null;
			p.next = tmp;
			p = p.next;
			if (i == entry)
				entryNode = tmp;
		}
		p.next = entryNode;

		return head;
	}

}

class ListNode {
	int value;
	ListNode next;
}