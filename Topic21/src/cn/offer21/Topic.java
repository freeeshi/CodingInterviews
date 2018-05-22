package cn.offer21;

import java.util.Arrays;

public class Topic {

	public static void main(String[] args) {
		int[] array = new int[] {2,5,3,2};
		reOrderArray(array);
		System.out.println(Arrays.toString(array));
	}

	/**
	 * 将符合条件的数字移动到数组的前半部分，不符合的移动到后半部分，条件可以根据check函数自动调整，提高了程序的可扩展性
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
	 * 判定条件是否成立，这里判断奇偶
	 * 
	 * @param num
	 * @return
	 */
	public static boolean check(int num) {
		return num % 2 == 0 ? true : false;
	}
}