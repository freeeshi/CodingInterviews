package cn.offer04;

public class Topic {

	public static void main(String[] args) {
		int[][] array = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
		System.out.println(find(7, array));
	}

	/**
	 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
	 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
	 * 分析：可以选取左下或者右上的数字，但不能是左上后者右下！
	 * 
	 * @param target
	 * @param array
	 * @return
	 */
	public static boolean find(int target, int[][] array) {

		if (array[0].length == 0)
			return false;

		int i = 0;
		int j = array.length - 1;
		boolean find = false;
		boolean finish = false;

		while (find == false && finish == false) {
			if (target > array[i][j])
				i++;
			else if (target < array[i][j])
				j--;
			else
				find = true;

			if (i == array[0].length || j == -1)
				finish = true;
		}

		return find;
	}

}
