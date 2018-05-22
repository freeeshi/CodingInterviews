package cn.offer14;

public class Topic {

	public static void main(String[] args) {
		int len = 4;
		System.out.println(maxProduct1(len));
		System.out.println(maxProduct2(len));
	}

	/**
	 * ̰���㷨��������ȴ���5��һֱ��ȥ����Ϊ3�����ӣ�ʣ�೤��Ϊ4ʱ�������Ӽ�������
	 * 
	 * @param length
	 * @return
	 */
	public static long maxProduct2(int length) {
		if (length < 2)
			throw new RuntimeException("Invalid parameter!");

		if (length == 2)
			return 1;
		if (length == 3)
			return 2;

		int m = length / 3;
		int n = length % 3;
		long product = 0;
		if (n == 0) {
			product = pow(3, m);
		} else if (n == 1) {
			product = pow(3, m - 1) * 4;
		} else {
			product = pow(3, m) * 2;
		}

		return product;
	}

	public static long pow(int x, int n) {
		long product = 1;
		for (int i = 0; i < n; i++) {
			product *= x;
		}
		return product;
	}

	/**
	 * ��̬�滮�����ڼ����кܶ����������һЩ�����⹹�ɣ���Щ���������кܶ���غϣ����ʹ���������ϼ���
	 * 
	 * @param length
	 * @return
	 */
	public static long maxProduct1(int length) {
		if (length < 2)
			throw new RuntimeException("Invalid parameter!");

		if (length == 2)
			return 1;
		if (length == 3)
			return 2;

		long[] product = new long[length + 1];
		product[0] = 0;
		product[1] = 1;
		product[2] = 2;
		product[3] = 3;

		for (int len = 4; len <= length; len++) {

			for (int cutLen = 1; cutLen <= len / 2; cutLen++) {
				long tmp = product[cutLen] * product[len - cutLen];
				if (product[len] < tmp) {
					product[len] = tmp;
				}
			}
		}

		return product[length];
	}

}