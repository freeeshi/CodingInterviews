package cn.offer49;

public class Topic {

	public static void main(String[] args) {
		// Å£¿Í²âÊÔ
		System.out.println(getUglyNumber(2716));
	}

	/**
	 * ¼ÆËã³óÊı
	 * 
	 * @param index
	 * @return
	 */
	public static int getUglyNumber(int index) {
		if (index < 1)
			return 0;

		int[] uglyNum = new int[index];
		uglyNum[0] = 1;
		int index0 = 1, index2 = 0, index3 = 0, index5 = 0;

		while (index0 < index) {
			int min = min(uglyNum[index2] * 2, uglyNum[index3] * 3, uglyNum[index5] * 5);
			uglyNum[index0++] = min;

			while (uglyNum[index2] * 2 <= min) {
				index2++;
			}

			while (uglyNum[index3] * 3 <= min) {
				index3++;
			}

			while (uglyNum[index5] * 5 <= min) {
				index5++;
			}

		}

		return uglyNum[index - 1];
	}

	public static int min(int a, int b, int c) {
		a = a < b ? a : b;
		return a = a < c ? a : c;
	}

}