package cn.offer06;

import java.util.Stack;

public class Topic {

	public static void main(String[] args) {
		ListNode listNode = null;

		for (int i = 0; i < 5; i++) {
			int num = (int) (Math.random() * 100);
			System.out.print(num + " ");
			ListNode node = new ListNode(num);
			node.setNext(listNode);
			listNode = node;
		}
		System.out.println();
		printListFromTailToHead1(listNode);
		System.out.println();
		printListFromTailToHead2(listNode);
	}
	
	/**
	 * 输入一个链表，从尾到头打印链表每个节点的值。
	 * 利用栈的先进后出性质完成倒叙输出
	 * @param listNode
	 */
	public static void printListFromTailToHead2(ListNode listNode) {
		if (listNode == null)
			return;
		
		
		Stack<Integer> stack = new Stack<>();
		while(listNode != null){
			stack.push(listNode.val);
			listNode = listNode.next;
		}
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}

	/**
	 * 输入一个链表，从尾到头打印链表每个节点的值。
	 * 使用递归调用，先递归打印之前的节点的值，再打印自己节点的值
	 * 
	 * @param listNode
	 * @return
	 */
	public static void printListFromTailToHead1(ListNode listNode) {
		if (listNode == null)
			return;
		
		if (listNode.next == null) {
			System.out.print(listNode.val + " ");
		} else {
			printListFromTailToHead1(listNode.next);
			System.out.print(listNode.val + " ");
		}
	}

}

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}
}