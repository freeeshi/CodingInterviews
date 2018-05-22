package cn.offer12;

import java.util.Arrays;

public class Topic {

	public static void main(String[] args) {
		char[][] matrix = new char[][] { { 's', 'd', 'i', 's' }, { 'k', 'z', 'q', 'c' }, { 'm', 'x', 'a', 's' } };

		System.out.println(findPath(matrix, "skm"));
	}

	/**
	 * 查找矩阵中是否有指定路径
	 * 
	 * @param matrix
	 * @param path
	 * @return
	 */
	public static boolean findPath(char[][] matrix, String path) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			throw new RuntimeException("Invalid parameter!");
		}

		int rows = matrix.length;
		int cols = matrix[0].length;

		boolean[][] visited = new boolean[rows][cols];
		for (int i = 0; i < rows; i++) {
			Arrays.fill(visited[i], false);
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (hasPath(matrix, visited, i, j, path, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 查找路径的核心代码，利用回溯法递归调用，查找指定路径
	 * 
	 * @param matrix
	 * @param visited
	 * @param row
	 * @param col
	 * @param path
	 * @param pathLen
	 * @return
	 */
	public static boolean hasPath(char[][] matrix, boolean[][] visited, int row, int col, String path, int pathLen) {
		if (path.length() == pathLen)
			return true;

		int rows = matrix.length;
		int cols = matrix[0].length;
		if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col])
			return false;

		boolean result = false;
		if (matrix[row][col] == path.charAt(pathLen)) {
			visited[row][col] = true;
			pathLen++;

			result = hasPath(matrix, visited, row - 1, col, path, pathLen)
					|| hasPath(matrix, visited, row + 1, col, path, pathLen)
					|| hasPath(matrix, visited, row, col - 1, path, pathLen)
					|| hasPath(matrix, visited, row, col + 1, path, pathLen);

			if (!result) {
				visited[row][col] = false;
			}
		}

		return result;
	}

}