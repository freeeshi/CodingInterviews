package cn.offer23;

public class Topic {

	public static void main(String[] args) {
		ListNode head = createListWithRing(new int[] { 0 }, 0);
		int ringSize = findRingAndNum(head);
		ListNode entry = findEntry(head, ringSize);
		System.out.println(entry.value);

	}

	/**
	 * �ҵ������л�����ڽڵ㣬��Ҫ֪�����Ľڵ����N����������ָ�룬��һ�����ƶ�N-1�Σ��ú�����һ���ƶ���������ָ��ͬһ���ڵ�ʱ������ڵ���ǻ������
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
	 * �ҵ������л��Ľڵ��������������ָ�룬һ����һ���죬�����ָ��׷�����ĵ�ʱ�򣬿��ֹͣ����������һȦ�ٵ��Լ�������ͳ�Ƴ�Ȧ�л��ĸ���
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
	 * ����һ����������������ָ��������ڵĽڵ�
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