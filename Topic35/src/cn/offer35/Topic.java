package cn.offer35;

import java.util.HashMap;
import java.util.Map;

public class Topic {

	public static void main(String[] args) {
		// 在牛客网做测试
		RandomListNode list = creatList(new int[] { 1, 2, 3, 4, 5 });
		clone3(list);
	}

	/**
	 * 用一种比较复杂的方法以O(N)的时间复杂度和O(1)的空间复杂度解决该问题
	 * 
	 * @param pHead
	 * @return
	 */
	public static RandomListNode clone3(RandomListNode pHead) {
		if (pHead == null)
			return null;

		// 复制链表，顺序为N1-N1'-N2-N2'-...-Ni-Ni'...
		RandomListNode q = pHead;
		while (q != null) {
			RandomListNode tmp = new RandomListNode(q.label);
			tmp.next = q.next;
			q.next = tmp;
			q = tmp.next;
		}

		// 设置random域
		RandomListNode newHead = pHead.next;
		RandomListNode p = newHead;
		q = pHead;
		while (q != null) {
			if (q.random != null)
				p.random = q.random.next;

			q = q.next.next;
			if (p.next != null)
				p = p.next.next;
		}

		// 拆分长链表
		p = newHead;
		q = pHead;
		while (q != null) {
			q.next = q.next.next;
			if (p.next != null)
				p.next = p.next.next;

			q = q.next;
			p = p.next;
		}

		return newHead;
	}

	/**
	 * 通过一个map来保存node1和node2的配对信息，在第二布设置random的值的时候就可以以O(N)时间复杂度完成，空间增加O(N)
	 * 
	 * @param pHead
	 * @return
	 */
	public static RandomListNode clone2(RandomListNode pHead) {
		if (pHead == null)
			return null;

		Map<RandomListNode, RandomListNode> map = new HashMap<>();
		RandomListNode newHead = new RandomListNode(pHead.label);
		RandomListNode p = newHead;
		RandomListNode q = pHead.next;
		map.put(pHead, newHead);
		while (q != null) {
			RandomListNode tmp = new RandomListNode(q.label);
			map.put(q, tmp);
			p.next = tmp;
			p = tmp;
			q = q.next;
		}

		for (RandomListNode tmp = pHead; tmp != null; tmp = tmp.next) {
			RandomListNode node = map.get(tmp);
			RandomListNode random = map.get(tmp.random);
			node.random = random;
		}

		return newHead;
	}

	/**
	 * 先把链表复制一份，再一个节点一个节点得处理，时间复杂度非常大，为O(N^2)
	 * 
	 * @param pHead
	 * @return
	 */
	public static RandomListNode clone1(RandomListNode pHead) {
		if (pHead == null)
			return null;

		RandomListNode newHead = new RandomListNode(pHead.label);
		RandomListNode p = newHead;
		RandomListNode q = pHead.next;
		while (q != null) {
			RandomListNode tmp = new RandomListNode(q.label);
			p.next = tmp;
			p = tmp;
			q = q.next;
		}

		q = pHead;
		p = newHead;
		while (q != null) {
			if (q.random != null) {
				for (RandomListNode tmp1 = pHead, tmp2 = newHead; tmp1 != null; tmp1 = tmp1.next, tmp2 = tmp2.next) {
					if (q.random == tmp1) {
						p.random = tmp2;
						break;
					}
				}

				q = q.next;
				p = p.next;
			}
		}

		return newHead;
	}

	public static RandomListNode creatList(int[] array) {
		if (array.length == 0)
			return null;

		RandomListNode head = new RandomListNode();
		head.label = array[0];
		head.next = null;
		RandomListNode p = head;
		for (int i = 1; i < array.length; i++) {
			RandomListNode tmp = new RandomListNode();
			tmp.label = array[i];
			tmp.next = null;
			p.next = tmp;
			p = p.next;
		}
		return head;
	}

}

class RandomListNode {
	int label;
	RandomListNode next = null;
	RandomListNode random = null;

	public RandomListNode() {
		// TODO Auto-generated constructor stub
	}

	RandomListNode(int label) {
		this.label = label;
	}
}