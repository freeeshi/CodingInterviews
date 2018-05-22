package cn.offer30;

import java.util.Stack;

public class Topic {

	public static void main(String[] args) {
		MyStack stack = new MyStack();
		stack.push(3);
		System.out.println("min" + stack.min());
		stack.push(4);
		System.out.println("min" + stack.min());
		stack.push(2);
		System.out.println("min" + stack.min());
		stack.push(3);
		System.out.println("min" + stack.min());
		System.out.println("pop" + stack.pop());
		System.out.println("min" + stack.min());
		System.out.println("pop" + stack.pop());
		System.out.println("min" + stack.min());
		System.out.println("pop" + stack.pop());
		System.out.println("min" + stack.min());
		stack.push(0);
		System.out.println("min" + stack.min());
	}

}

/**
 * ʵ��һ���ܹ��õ�ջ��СԪ�ص�min����������һ������ջ�����浱ǰ��СԪ�أ���Ҫÿ��push������һ��
 * 
 * @author ʯ����
 *
 */
class MyStack {

	private Stack<Integer> stack;
	private Stack<Integer> minStack;

	public MyStack() {
		this.stack = new Stack<>();
		this.minStack = new Stack<>();
	}

	public int pop() {
		minStack.pop();
		return stack.pop();
	}

	public void push(int t) {
		stack.push(t);

		if (minStack.isEmpty() || t < minStack.get(minStack.size() - 1))
			minStack.push(t);
		else {
			minStack.push(minStack.get(minStack.size() - 1));
		}
	}

	public int min() {
		return minStack.get(minStack.size() - 1);
	}

}