package cn.offer36;

public class Topic {

	private TreeNode tail = null;

	public static void main(String[] args) {
		// ţ����������
	}

	/**
	 * ����һ�ö��������������ö���������ת����һ�������˫������
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
	 * �ݹ����ÿһ���ڵ㣬��tail��¼�������һ���ڵ�
	 * @param node
	 */
	public void ConvertNode(TreeNode node) {
		if (node == null)
			return;

		// ����ǰ�ڵ��������ʱ���ݹ鴦���ӽڵ�
		if (node.left != null)
			ConvertNode(node.left);
		
		// ����ǰ�ڵ㣺Ҳ���ǽ���ǰ�ڵ����������ǰ�ڵ��leftָ��tail
		node.left = tail;
		// ���tail��Ϊnull����tail��rightָ��ǰ�ڵ�
		if (tail != null)
			tail.right = node;
		
		// �����굱ǰ�ڵ㣬����tailΪ��ǰ�ڵ�
		tail = node;

		// �����ǰ�ڵ���������Ϊnull���ݹ鴦��������
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