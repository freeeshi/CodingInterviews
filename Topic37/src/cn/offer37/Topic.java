package cn.offer37;

import java.util.LinkedList;
import java.util.Queue;

public class Topic {

	private int index = -1;

	public static void main(String[] args) {
		// 牛客网做测试，不知道为什么通不过
		TreeNode root = createTree(new int[] { 8, 6, 10, 5, 7, 9, 11, 8, 6, 10, 5, 7, 9, 11, 8, 6, 10, 5, 7, 9, 11 });
		Topic topic = new Topic();
		String serialize = topic.Serialize(root);
		TreeNode node = topic.Deserialize(serialize);
		serialize = topic.Serialize(node);

		System.out.println(serialize);

	}

	/**
	 * 序列化二叉树，null用$表示，每个节点之间用,分隔
	 * 
	 * @param root
	 * @return
	 */
	public String Serialize(TreeNode root) {
		StringBuilder builder = new StringBuilder();
		if (root == null) {
			builder.append("$,");
			return builder.toString();
		}

		builder.append(root.val + ",");
		builder.append(Serialize(root.left));
		builder.append(Serialize(root.right));
		return builder.toString();
	}

	/**
	 * 反序列化二叉树，先将字符串以,分割成数组，再进行反序列化核心
	 * 
	 * @param str
	 * @return
	 */
	public TreeNode Deserialize(String str) {
		if (str == null || str.length() <= 0)
			return null;

		String[] split = str.split(",");
		return DeserializeCore(split);
	}

	/**
	 * 递归进行反序列化
	 * 
	 * @param strs
	 * @return
	 */
	public TreeNode DeserializeCore(String[] strs) {
		index++;
		if (index == strs.length)
			return null;

		if (strs[index].equals("$")) {
			return null;
		}

		TreeNode result = null;
		result = new TreeNode(Integer.parseInt(strs[index]));
		result.left = DeserializeCore(strs);
		result.right = DeserializeCore(strs);

		return result;
	}

	public static TreeNode createTree(int[] array) {
		if (array == null || array.length == 0)
			return null;

		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode result = new TreeNode(array[0]);
		queue.offer(result);
		for (int i = 1; i < array.length - 1; i += 2) {
			TreeNode node1 = new TreeNode(array[i]);
			TreeNode node2 = new TreeNode(array[i + 1]);
			TreeNode root = queue.poll();
			root.left = node1;
			root.right = node2;
			queue.offer(node1);
			queue.offer(node2);
		}
		if (array.length % 2 == 0) {
			TreeNode node = new TreeNode(array[array.length - 1]);
			queue.poll().left = node;
		}

		return result;
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