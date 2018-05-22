package cn.offer04;

public class Topic {

	public static void main(String[] args) {
		int[][] array = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
		System.out.println(find(7, array));
	}

	/**
	 * ��һ����ά�����У�ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳������
	 * �����һ������������������һ����ά�����һ���������ж��������Ƿ��и�������
	 * ����������ѡȡ���»������ϵ����֣������������Ϻ������£�
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
