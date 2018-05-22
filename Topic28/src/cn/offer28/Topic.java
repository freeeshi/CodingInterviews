package cn.offer28;

public class Topic {

	public static void main(String[] args) {
		// ţ��������
	}

	/**
	 * �ж�һ���������ǲ��ǶԳƣ��ֱ��ж����������ǲ��ǶԳƼ���
	 * 
	 * @param root
	 * @return
	 */
	public static boolean isSymmetrical(TreeNode root) {
		if(root == null)
			return true;
		
		return isSubSymmetrical(root.left, root.right);
	}

	/**
	 * �ݹ��ж������������Ƿ�Գ�
	 * 
	 * @param left
	 * @param right
	 * @return
	 */
	public static boolean isSubSymmetrical(TreeNode left, TreeNode right) {
		if (left == null && right == null)
			return true;
		if (left == null || right == null)
			return false;

		if (right.val != left.val)
			return false;

		return isSubSymmetrical(left.left, right.right) && isSubSymmetrical(left.right, right.left);
	}

}

class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;
}