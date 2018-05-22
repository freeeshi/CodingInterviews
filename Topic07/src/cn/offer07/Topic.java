package cn.offer07;

public class Topic {

	public static void main(String[] args) {
		int[] pre = { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] in = { 4, 7, 2, 1, 5, 3, 6 };
		TreeNode treeNode = reConstruct(pre, in);
		System.out.println(treeNode);
	}

	public static TreeNode reConstruct(int[] pre, int[] in) {

		if (pre == null || in == null || pre.length != in.length)
			throw new RuntimeException("不能构成二叉树！");

		// 根节点
		TreeNode root = null;

		// 如果输入的数组长度为0，直接返回null
		// 如果长度为一，返回值为此值的节点
		if (pre.length == 0) {
			if (in.length == 0)
				return null;
			else
				throw new RuntimeException("不能构成二叉树！");
		} else if (pre.length == 1) {
			if (in.length != 1 && pre[0] != in[0])
				throw new RuntimeException("不能构成二叉树！");
			else
				root = new TreeNode(pre[0]);
		} else {
			int rootValue = pre[0];
			int rootIndex = 0;

			// 构造出当前root节点
			root = new TreeNode(rootValue);

			// 计算出root在数组中的位置
			for (int i = 0; i < in.length; i++) {
				if (in[i] == rootValue) {
					rootIndex = i;
					break;
				}
			}

			// 分离出pre和in的左右子树
			int[] leftPre = new int[rootIndex];
			int[] rightPre = new int[pre.length - rootIndex - 1];
			int[] leftIn = new int[rootIndex];
			int[] rightIn = new int[pre.length - rootIndex - 1];
			for (int i = 0; i < rootIndex; i++) {
				leftPre[i] = pre[i + 1];
				leftIn[i] = in[i];
			}
			for (int i = 0; i < pre.length - rootIndex - 1; i++) {
				rightPre[i] = pre[rootIndex + i + 1];
				rightIn[i] = in[rootIndex + i + 1];
			}

			// printArray(leftPre);
			// printArray(leftIn);
			// printArray(rightPre);
			// printArray(rightIn);

			// 设置左右节点
			root.left = reConstruct(leftPre, leftIn);
			root.right = reConstruct(rightPre, rightIn);
		}

		return root;
	}

	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
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