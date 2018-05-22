package cn.offer31;

import java.util.Stack;

public class Topic {

	public static void main(String[] args) {
		int[] pushA = new int[] { 1, 2, 3 };
		int[] popA = new int[] { 4, 5, 3 };
		System.out.println(isPopOrder(pushA, popA));
	}

	/**
	 * ����һ����ջ���У��ж���һ�������ǲ��Ǻ���ĳ�ջ���У�����������ֵû���ظ���
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

		// ���κ�һ�����б����꣬���˳�ѭ��
		while (index1 != pushA.length && index2 != popA.length) {
			// �����ǰ��ջ���е�ֵ�ͳ�ջ����ֵ��ȣ������±궼��ǰ�ƶ�
			// ���ջ�ǿգ���ջ��Ԫ�غ͵�ǰ��ջ����ֵ��ȣ���ôpop�����ҳ�ջ�����±�+1
			// ������ջ������ջ
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

		// ����ǰջ�ǿգ�����pop���ж����ջ�����Ƿ����
		while (!stack.isEmpty()) {
			if (stack.pop() != popA[index2++]) {
				result = false;
				break;
			}
		}

		return result;
	}

}