package cn.offer21;

import java.util.Arrays;

public class Topic {

	public static void main(String[] args) {
		int[] array = new int[] {2,5,3,2};
		reOrderArray(array);
		System.out.println(Arrays.toString(array));
	}

	/**
	 * �����������������ƶ��������ǰ�벿�֣������ϵ��ƶ�����벿�֣��������Ը���check�����Զ�����������˳���Ŀ���չ��
	 * 
	 * @param array
	 */
	public static void reOrderArray(int[] array) {
		if (array == null || array.length == 0 || array.length == 1)
			return;

		int len = array.length;
		int left = -1;
		int right = len;

		while (left != len-1 && !check(array[++left]))
			;
		while (right != 0 && check(array[--right]))
			;

		if (left < right) {
			int tmp = array[left];
			array[left] = array[right];
			array[right] = tmp;
		}
	}

	/**
	 * �ж������Ƿ�����������ж���ż
	 * 
	 * @param num
	 * @return
	 */
	public static boolean check(int num) {
		return num % 2 == 0 ? true : false;
	}
}