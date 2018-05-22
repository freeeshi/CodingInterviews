package cn.offer33;

public class Topic {

	public static void main(String[] args) {
		System.out.println(verifySquenceOfBST(new int[] { 7, 4, 6, 5 }));
	}

	/**
	 * �ж�һ�������ǲ���ĳ���������ĺ������
	 * 
	 * @param sequence
	 * @return
	 */
	public static boolean verifySquenceOfBST(int[] sequence) {
		if (sequence == null || sequence.length <= 0)
			return false;

		return checkArray(sequence, 0, sequence.length - 1);
	}

	/**
	 * �ݹ��ж�ÿ���������ǲ���ĳ���������ĺ������
	 * 
	 * @param array
	 * @param left
	 * @param right
	 * @return
	 */
	public static boolean checkArray(int[] array, int left, int right) {
		int root = array[right];
		int i = 0;
		for (i = left; i < right; i++) {
			if (array[i] > root)
				break;
		}

		int j = i;
		for (j = i; j < right; j++) {
			if (array[j] < root)
				break;
		}

		boolean leftFlag = true;
		if (i > left)
			leftFlag = checkArray(array, left, i - 1);

		boolean rightFlag = false;
		if (j == right) {
			if (i == right)
				rightFlag = true;
			else
				rightFlag = checkArray(array, i, right - 1);
		}

		return leftFlag && rightFlag;
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}