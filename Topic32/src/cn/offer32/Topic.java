package cn.offer32;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Topic {

	public static void main(String[] args) {
		TreeNode root = createTree(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 1,
				2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 });
		printFromTopToBottom2(root);
		System.out.println();
		printFromTopToBottom3(root);
		System.out.println();
		printFromTopToBottom4(root);
	}

	/**
	 * 分行之字形从上到下打印二叉树，用两个栈来实现
	 * 
	 * @param root
	 * @return
	 */
	public static ArrayList<ArrayList<Integer>> printFromTopToBottom4(TreeNode root) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		ArrayList<Integer> tmp = null;
		if (root == null)
			return list;

		Stack<TreeNode> stack1 = new Stack<>();
		stack1.push(root);
		Stack<TreeNode> stack2 = new Stack<>();

		while (!stack1.isEmpty() || !stack2.isEmpty()) {
			tmp = new ArrayList<>();
			while (!stack1.isEmpty()) {
				TreeNode node = stack1.pop();
				tmp.add(node.val);
				System.out.print(node.val + " ");
				
				if (node.left != null) {
					stack2.push(node.left);
				}
				if (node.right != null) {
					stack2.push(node.right);
				}
			}
			list.add(tmp);
			
			if(!stack2.isEmpty())
				System.out.println();
			
			tmp = new ArrayList<>();
			while (!stack2.isEmpty()) {
				TreeNode node = stack2.pop();
				tmp.add(node.val);
				System.out.print(node.val + " ");
				
				if (node.right != null) {
					stack1.push(node.right);
				}
				if (node.left != null) {
					stack1.push(node.left);
				}
			}
			list.add(tmp);
			
			if(!stack1.isEmpty())
				System.out.println();
		}
		
		return list;
	}

	/**
	 * 分行从上到下打印二叉树，用m表示当前层还未被打印的节点个数，n表示下一层节点个数
	 * 
	 * @param root
	 * @return
	 */
	public static ArrayList<ArrayList<Integer>> printFromTopToBottom3(TreeNode root) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		ArrayList<Integer> tmp = new ArrayList<>();
		if (root == null)
			return list;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int m = 1;
		int n = 0;
		while (!queue.isEmpty()) {
			if (m != 0) {
				TreeNode node = queue.poll();
				tmp.add(node.val);
				System.out.print(node.val + " ");

				if (node.left != null) {
					queue.offer(node.left);
					n++;
				}
				if (node.right != null) {
					queue.offer(node.right);
					n++;
				}
				m--;
			} else {
				System.out.println();
				list.add(tmp);
				tmp = new ArrayList<>();
				m = n;
				n = 0;
			}
		}

		if (!tmp.isEmpty())
			list.add(tmp);

		return list;
	}

	/**
	 * 分行从上到下打印二叉树，用另一个大小相等的列队保存当前节点的层次，浪费空间
	 * 
	 * @param root
	 * @return
	 */
	public static ArrayList<Integer> printFromTopToBottom2(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<>();
		if (root == null)
			return list;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		Queue<Integer> ranks = new LinkedList<>();
		ranks.offer(0);
		int currRank = 0;
		while (!queue.isEmpty()) {
			int rank = ranks.poll();
			TreeNode node = queue.poll();

			if (rank != currRank) {
				currRank = rank;
				System.out.println();
			}

			list.add(node.val);
			System.out.print(node.val + " ");
			if (node.left != null) {
				queue.offer(node.left);
				ranks.offer(rank + 1);
			}
			if (node.right != null) {
				queue.offer(node.right);
				ranks.offer(rank + 1);
			}
		}

		return list;
	}

	/**
	 * 不分行从上到下打印二叉树
	 * 
	 * @param root
	 * @return
	 */
	public static ArrayList<Integer> printFromTopToBottom1(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<>();
		if (root == null)
			return list;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			list.add(node.val);
			System.out.print(node.val + " ");
			if (node.left != null)
				queue.offer(node.left);
			if (node.right != null)
				queue.offer(node.right);
		}

		return list;
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