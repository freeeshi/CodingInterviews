package cn.offer26;

public class Topic {

	public static void main(String[] args) {
		// ��ţ��������
	}

	/**
	 * �ж�tree2�ǲ���tree1���ӽṹ���Ƚ����������ĸ��ڵ��ƥ�䣬ƥ��ɹ����ж������Ƿ���ͬ
	 * 
	 * @param tree1
	 * @param tree2
	 * @return
	 */
	public static boolean matchRoot(TreeNode tree1, TreeNode tree2) {
		if (tree1 == null || tree2 == null)
			return false;

		boolean isSub = false;
		if (tree1.val == tree2.val)
			isSub = matchEqule(tree1, tree2);
		if (!isSub)
			isSub = matchRoot(tree1.left, tree2);
		if (!isSub)
			isSub = matchRoot(tree1.right, tree2);
		return isSub;
	}

	/**
	 * �ж�tree2�Ľṹ�Ƿ������tree1�У�ע���tree2��null���ж���Ҫ��tree1ǰ��
	 * 
	 * @param tree1
	 * @param tree2
	 * @return
	 */
	public static boolean matchEqule(TreeNode tree1, TreeNode tree2) {
		if (tree2 == null)
			return true;
		if (tree1 == null)
			return false;

		if (tree1.val != tree2.val)
			return false;

		return matchEqule(tree1.left, tree2.left) && matchEqule(tree1.right, tree2.right);
	}
}

class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;

	public TreeNode(int val) {
		this.val = val;

	}

}