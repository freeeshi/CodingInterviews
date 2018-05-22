package cn.offer28;

public class Topic {

	public static void main(String[] args) {
		// 牛客网测试
	}

	/**
	 * 判断一个二叉树是不是对称，分别判断左右子树是不是对称即可
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
	 * 递归判断子树的子树是否对称
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