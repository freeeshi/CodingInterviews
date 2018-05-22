package cn.offer36;

public class Topic {

	private TreeNode tail = null;

	public static void main(String[] args) {
		// 牛客网做测试
	}

	/**
	 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表
	 * 
	 * @param pRootOfTree
	 * @return
	 */
	public TreeNode Convert(TreeNode pRootOfTree) {
		if (pRootOfTree == null)
			return null;

		ConvertNode(pRootOfTree);

		while (tail != null && tail.left != null)
			tail = tail.left;

		return tail;
	}

	/**
	 * 递归调整每一个节点，用tail记录链表最后一个节点
	 * @param node
	 */
	public void ConvertNode(TreeNode node) {
		if (node == null)
			return;

		// 当当前节点有左儿子时，递归处理子节点
		if (node.left != null)
			ConvertNode(node.left);
		
		// 处理当前节点：也就是将当前节点加入链表，当前节点的left指向tail
		node.left = tail;
		// 如果tail不为null，让tail的right指向当前节点
		if (tail != null)
			tail.right = node;
		
		// 处理完当前节点，更新tail为当前节点
		tail = node;

		// 如果当前节点右子树不为null，递归处理右子树
		if (node.right != null)
			ConvertNode(node.right);
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