package cn.offer34;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Topic {

	private static Stack<Integer> stack = new Stack<>();
	private static int currSum = 0;

	public static void main(String[] args) {
		TreeNode tree = createTree(new int[] { 10, 5, 12, 4, 7 });
		findPath(tree, 15);
	}

	/**
	 * 找到二叉树中和为某一值target的所有路径，使用一个全局的栈来保存当前路径
	 * 
	 * @param root
	 * @param target
	 * @return
	 */
	public static ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		if (root == null)
			return list;

		findCore(root, target, list);

		return list;
	}

	/**
	 * 使用前序遍历来递归得寻找
	 * 
	 * @param root
	 * @param target
	 * @param list
	 */
	public static void findCore(TreeNode root, int target, ArrayList<ArrayList<Integer>> list) {
		if (root == null)
			return;

		if (root.left != null || root.right != null) {
			if (root.val + currSum < target) {
				stack.push(root.val);
				currSum += root.val;

				findCore(root.left, target, list);
				findCore(root.right, target, list);

				stack.pop();
				currSum -= root.val;
			}
		} else {
			if (currSum + root.val == target) {
				ArrayList<Integer> tmp = new ArrayList<>();
				for (int i = 0; i < stack.size(); i++) {
					tmp.add(stack.get(i));
				}
				tmp.add(root.val);
				list.add(tmp);
			}
		}
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
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}