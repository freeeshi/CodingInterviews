package cn.offer13;

import java.util.Arrays;

public class Topic {

	public static void main(String[] args) {
		System.out.println(getMovingCount(20, 20, 10));
		System.out.println(getMovingCountByFor(100, 1, 10));
	}

	/**
	 * 使用循环遍历所有的方格，时间复杂度很高
	 * 
	 * @param rows
	 * @param cols
	 * @param max
	 * @return
	 */
	public static int getMovingCountByFor(int rows, int cols, int max) {
		if (rows <= 0 || cols <= 0 || max < 0)
			throw new RuntimeException("Invalid parameter!");

		int count = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (check(i, j, max)) {
					count++;
				}
			}
		}

		return count;
	}

	/**
	 * 使用回溯法的程序入口程序
	 * 
	 * @param rows
	 * @param cols
	 * @param max
	 * @return
	 */
	public static int getMovingCount(int rows, int cols, int max) {
		if (rows <= 0 || cols <= 0 || max < 0)
			throw new RuntimeException("Invalid parameter!");

		boolean[][] visited = new boolean[rows][cols];
		for (int i = 0; i < rows; i++) {
			Arrays.fill(visited[i], false);
		}

		return move(rows, cols, 0, 0, max, visited);
	}

	/**
	 * 用回溯法找到所有符合条件的方格，返回符合条件的方格数量
	 * 
	 * @param rows
	 * @param cols
	 * @param row
	 * @param col
	 * @param max
	 * @param visited
	 * @return
	 */
	public static int move(int rows, int cols, int row, int col, int max, boolean[][] visited) {
		int count = 0;
		if (row >= 0 && row < rows && col >= 0 && col < cols && !visited[row][col]) {
			if (check(row, col, max)) {
				visited[row][col] = true;
				count = 1 + move(rows, cols, row - 1, col, max, visited) + move(rows, cols, row + 1, col, max, visited)
						+ move(rows, cols - 1, row, col, max, visited) + move(rows, cols, row, col + 1, max, visited);
			}
		}
		return count;
	}

	public static boolean check(int row, int col, int max) {
		return bitSum(row) + bitSum(col) <= max;
	}

	public static int bitSum(int num) {
		int sum = 0;
		while (num > 0) {
			sum += num % 10;
			num /= 10;
		}
		return sum;
	}

}