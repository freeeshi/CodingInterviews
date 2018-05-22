package cn.offer26;

public class Topic {

	public static void main(String[] args) {
		// 在牛客做测试
	}

	/**
	 * 判断tree2是不是tree1的子结构：先进行两个树的根节点的匹配，匹配成功后判断其结果是否相同
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
	 * 判断tree2的结构是否包含在tree1中，注意对tree2是null的判断需要在tree1前边
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