package cn.offer43;

public class Topic {

	public static void main(String[] args) {
		numberOf1Between1AndN(55);
	}

	public static long numberOf1Between1AndN(long n) {
		if (n < 1)
			return 0;
		if (n < 10)
			return 1;

		int len = (n + "").length();
		long[] COUNT = new long[len];
		COUNT[0] = 1;

		for (int i = 1; i < len; i++) {
			COUNT[i] = pow10(i) + 10 * COUNT[i - 1];
		}

		len--;
		int count = 0;
		while (n > 9) {
			long m = pow10(len);
			long i = n / m;

			if (i == 1) {
				count += (n - m + 1);
			} else {
				count += m;
			}

			n %= m;
			count += i * COUNT[--len];
		}

		if (n > 1)
			count++;

		return count;
	}

	public static long pow10(int e) {
		if (e == 0)
			return 1;
		if (e % 2 == 0)
			return pow10(e / 2) * pow10(e / 2);
		return pow10(e / 2) * pow10(e / 2) * 10;
	}

}