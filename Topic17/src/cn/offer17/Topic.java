package cn.offer17;

import java.util.Arrays;

public class Topic {

	public static void main(String[] args) {
		print1ToN1(3);
		print1ToN2(3);
	}
	
	/**
	 * 利用全排列来列举打印所有数字
	 * @param N
	 */
	public static void print1ToN2(int N) {
		if (N <= 0)
			throw new RuntimeException("Invalid parameter!");

		char[] num = new char[N];
		Arrays.fill(num, '0');
		
		fullArrangement(num, -1);
		
	}
	
	public static void fullArrangement(char[] num, int index) {
		if(index == num.length-1) {
			printNum(num);
			return;
		}
		
		for(int i = 0; i < 10; i++) {
			num[index+1] = (char) ('0' + i);
			fullArrangement(num, index+1);
		}
	}

	/**
	 * 用常规的加法思想，模拟数字累加
	 * @param N
	 */
	public static void print1ToN1(int N) {
		if (N <= 0)
			throw new RuntimeException("Invalid parameter!");

		char[] num = new char[N];
		Arrays.fill(num, '0');

		boolean isOverFlow = false;
		while (!isOverFlow) {
			int carry = 1;
			for (int i = N - 1; i >= 0 && carry == 1; i--) {
				int value = num[i] - '0';
				value += carry;
				if (value == 10) {
					if (i == 0) {
						isOverFlow = true;
						break;
					}
					num[i] = '0';
					carry = 1;
				} else {
					num[i] = (char) (value + '0');
					carry = 0;
				}
			}
			if (!isOverFlow)
				printNum(num);
		}
	}

	public static void printNum(char[] num) {
		int len = num.length;
		boolean start = false;
		for (int i = 0; i < len; i++) {
			if (!start && num[i] != '0')
				start = true;
			if (start)
				System.out.print(num[i]);
		}
		System.out.println();
	}

}