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
 * 实现一个能够得到栈最小元素的min函数，利用一个辅助栈，保存当前最小元素，需要每次push都保存一次
 * 
 * @author 石龙飞
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