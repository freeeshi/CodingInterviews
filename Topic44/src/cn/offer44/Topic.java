package cn.offer44;

public class Topic {

	public static void main(String[] args) {
		System.out.println(digitAtIndex(1000));
	}

	/**
	 * 数字序列中某一位数字，012345678910111213141516...
	 * 
	 * @param index
	 * @return
	 */
	public static int digitAtIndex(int index) {
		if (index < 0)
			return 0;
		if (index < 10)
			return index;

		int len = (index + "").length();
		long[] lastDigit = new long[len];
		lastDigit[0] = 9;

		long nTen = 10;
		for (int i = 1; i < len; i++, nTen *= 10) {
			lastDigit[i] = nTen * 9 * (i + 1) + lastDigit[i - 1];
		}

		int i = 0;
		for (; index > lastDigit[i]; i++);

		long j = index - lastDigit[i - 1];
		int k = (int) (j % (i + 1));
		long l = j / (i + 1);

		long num = pow10(i) + l;
		if (k == 0) {
			return ((num - 1) + "").charAt(i) - '0';
		}

		return (num + "").charAt(k - 1) - '0';
	}

	public static long pow10(int e) {
		if (e == 0)
			return 1;
		if (e % 2 == 0)
			return pow10(e / 2) * pow10(e / 2);
		return pow10(e / 2) * pow10(e / 2) * 10;
	}

}