package cn.offer09;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Topic {

	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.offer(3);
		queue.offer(7);
		queue.offer(13);
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		queue.offer(10);
		System.out.println(queue.poll());
		System.out.println();

		MyStack stack = new MyStack();
		stack.push(23);
		stack.push(3);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		stack.push(11);
		stack.push(9);
		stack.push(19);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		stack.push(0);
		System.out.println(stack.pop());
	}

}

/**
 * 用两个栈来实现队列
 * 
 * @author 石龙飞
 *
 */
class MyQueue {
	Stack<Integer> stack1 = new Stack<>();
	Stack<Integer> stack2 = new Stack<>();

	public void offer(int value) {
		stack1.push(value);
	}

	public int poll() {
		int result = 0;
		if (stack2.isEmpty()) {
			if (stack1.isEmpty()) {
				throw new RuntimeException("Queue is empty!");
			} else {
				while (!stack1.isEmpty()) {
					stack2.push(stack1.pop());
				}
				result = stack2.pop();
			}
		} else {
			result = stack2.pop();
		}
		return result;
	}
}

/**
 * 用两个队列实现栈
 * 
 * @author 石龙飞
 *
 */
class MyStack {
	Queue<Integer> queue1 = new LinkedList<>();
	Queue<Integer> queue2 = new LinkedList<>();

	public void push(int value) {
		if (queue1.isEmpty()) {
			queue2.offer(value);
		} else {
			queue1.offer(value);
		}
	}

	public int pop() {
		int result = 0;

		if (queue1.isEmpty() && queue2.isEmpty()) {
			throw new RuntimeException("Stack is empty!");
		} else if (queue1.isEmpty()) {
			while (queue2.size() > 1) {
				queue1.offer(queue2.poll());
			}
			result = queue2.poll();
		} else {
			while (queue1.size() > 1) {
				queue2.offer(queue1.poll());
			}
			result = queue1.poll();
		}

		return result;
	}
}