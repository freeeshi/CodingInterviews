package cn.offer31;

import java.util.Stack;

public class Topic {

	public static void main(String[] args) {
		int[] pushA = new int[] { 1, 2, 3 };
		int[] popA = new int[] { 4, 5, 3 };
		System.out.println(isPopOrder(pushA, popA));
	}

	/**
	 * 给出一个入栈序列，判断另一个序列是不是合理的出栈序列，给出的序列值没有重复的
	 * 
	 * @param pushA
	 * @param popA
	 * @return
	 */
	public static boolean isPopOrder(int[] pushA, int[] popA) {
		if (pushA == null || popA == null || pushA.length == 0 || popA.length == 0 || pushA.length != popA.length)
			return false;

		boolean result = true;
		int index1 = 0;
		int index2 = 0;
		Stack<Integer> stack = new Stack<>();

		// 当任何一个序列遍历完，即退出循环
		while (index1 != pushA.length && index2 != popA.length) {
			// 如果当前入栈序列的值和出栈序列值相等，两个下标都向前移动
			// 如果栈非空，且栈顶元素和当前出栈序列值相等，那么pop，并且出栈序列下标+1
			// 否则入栈序列入栈
			if (pushA[index1] == popA[index2]) {
				index1++;
				index2++;
			} else if (!stack.isEmpty() && stack.get(stack.size() - 1) == popA[index2]) {
				stack.pop();
				index2++;
			} else {
				stack.push(pushA[index1++]);
			}

		}

		// 若当前栈非空，不断pop，判断与出栈序列是否相等
		while (!stack.isEmpty()) {
			if (stack.pop() != popA[index2++]) {
				result = false;
				break;
			}
		}

		return result;
	}

}