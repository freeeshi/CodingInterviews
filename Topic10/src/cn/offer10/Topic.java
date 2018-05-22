package cn.offer10;

public class Topic {

	public static void main(String[] args) {
		System.out.println("求斐波那契数列第45项");
		long start = System.currentTimeMillis();
		System.out.println(fibonacci1(45));
		System.out.println("递归时间：" + (System.currentTimeMillis() - start) + "ms");

		start = System.currentTimeMillis();
		System.out.println(fibonacci2(45));
		System.out.println("循环时间：" + (System.currentTimeMillis() - start) + "ms");
	}

	/**
	 * 用循环来实现斐波那契数列
	 * 
	 * @param num
	 * @return
	 */
	public static long fibonacci2(int num) {
		if (num < 0)
			throw new RuntimeException("Invalid value!");

		long[] fibo = new long[] { 1l, 1l, 2l };
		if (num < 3) {
			return fibo[num];
		}

		for (int i = 0; i < num - 2; i++) {
			fibo[0] = fibo[1];
			fibo[1] = fibo[2];
			fibo[2] = fibo[0] + fibo[1];
		}

		return fibo[2];
	}

	/**
	 * 用递归实现斐波那契数列
	 * 
	 * @param num
	 * @return
	 */
	public static long fibonacci1(int num) {
		if (num < 0)
			throw new RuntimeException("Invalid value!");
		if (num == 0 || num == 1)
			return 1l;
		else
			return fibonacci1(num - 1) + fibonacci1(num - 2);
	}

}