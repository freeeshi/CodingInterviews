package cn.offer29;

import java.util.ArrayList;
import java.util.List;

public class Topic {

	public static void main(String[] args) {
		int[][] matrix1 = new int[][] { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 },
				{ 16, 17, 18, 19, 20 } };
		int[][] matrix2 = new int[][] { { 1 }, { 6 }, { 11 }, { 16 } };
		int[][] matrix3 = new int[][] { { 1, 2, 3, 4, 5 } };
		int[][] matrix4 = new int[][] { { 1 } };
		int[][] matrix5 = new int[][] { {} };
		System.out.println(printMatrix1(matrix1).toString());
		System.out.println(printMatrix1(matrix2).toString());
		System.out.println(printMatrix1(matrix3).toString());
		System.out.println(printMatrix1(matrix4).toString());
		System.out.println(printMatrix1(matrix5).toString());
		System.out.println(printMatrix1(matrix5).toString());
	}

	/**
	 * һ�����ϱ仯�������ҽ��޵ķ������ϱߺ�������꣬�Ͻ�+1���ұ����±����꣬�ҽ�-1���±ߺ�������꣬�½�-1��������±����꣬���+1
	 * 
	 * @param matrix
	 * @return
	 */
	public static ArrayList<Integer> printMatrix2(int[][] matrix) {
		int width = matrix[0].length;
		int high = matrix.length;
		int count = high * width;
		int xDire = 1, yDire = 1;
		int x = 0, y = 0;
		ArrayList<Integer> list = new ArrayList<>();

		while (count != 0) {

			for (int i = 0; i < width; i++) {
				list.add(matrix[y][x]);
				x += xDire;
				count--;
			}
			x -= xDire;
			high--;
			y += yDire;
			xDire *= -1;

			for (int i = 0; i < high; i++) {
				list.add(matrix[y][x]);
				y += yDire;
				count--;
			}
			y -= yDire;
			width--;
			x += xDire;
			yDire *= -1;
		}

		return list;
	}

	/**
	 * ÿѭ��һ�α���һȦ��ÿ�ο�ʼ�ĵ㶼Ϊ(a,a)����2a���ڵ�����������������������
	 * 
	 * @param matrix
	 * @return
	 */
	public static ArrayList<Integer> printMatrix1(int[][] matrix) {
		ArrayList<Integer> list = new ArrayList<>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return list;

		int rows = matrix.length;
		int cols = matrix[0].length;
		for (int i = 0; i * 2 < rows && i * 2 < cols; i++) {
			printOneCircle(matrix, list, i);
		}

		return list;
	}

	/**
	 * ����һȦ��ע��ÿһȦ�߽�ֵ���жϣ�����Ҫ
	 * 
	 * @param matrix
	 * @param list
	 * @param start
	 */
	public static void printOneCircle(int[][] matrix, List<Integer> list, int start) {
		int endX = matrix[0].length - start - 1;
		int endY = matrix.length - start - 1;

		for (int i = start; i <= endX; i++) {
			list.add(matrix[start][i]);
		}

		if (endY - start >= 1) {
			for (int i = start + 1; i <= endY; i++) {
				list.add(matrix[i][endX]);
			}
		}

		if (endY - start >= 1 && endX - start >= 1) {
			for (int i = endX - 1; i >= start; i--) {
				list.add(matrix[endY][i]);
			}
		}

		if (endX - start >= 1 && endY - start >= 2) {
			for (int i = endY - 1; i >= start + 1; i--) {
				list.add(matrix[i][start]);
			}
		}
	}

}