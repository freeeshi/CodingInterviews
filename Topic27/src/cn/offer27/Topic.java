package cn.offer27;

public class Topic {

	public static void main(String[] args) {
		// Å£¿ÍÍø²âÊÔ
	}

	/**
	 * ¶þ²æÊ÷µÄ¾µÏñ
	 * 
	 * @param root
	 * @return
	 */
	public static TreeNode mirrorTree(TreeNode root) {
		if (root == null)
			return null;

		TreeNode tmp = root.left;
		root.right = root.left;
		root.left = tmp;

		mirrorTree(root.left);
		mirrorTree(root.right);

		return root;
	}
	
}

class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;
}