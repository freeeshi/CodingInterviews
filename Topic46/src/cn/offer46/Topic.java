package cn.offer46;

public class Topic {

	public static void main(String[] args) {
		// 牛客测试
		getTranslationCount(25);
	}

	/**
	 * 把数字翻译成字符串，0~25分别对应a~z，给一个数字，计算有多少种翻译方法
	 * 17可以被翻译成1和7对应的字母，也可以看成17对应的字母，这是一个典型的DP问题，可以用一维数组处理，比价简单
	 * 
	 * @param number
	 * @return
	 */
	public static int getTranslationCount(int number) {
		if (number < 10)
			return 1;

		String str = number + "";
		int[] count = new int[str.length()];

		count[0] = 1;
		if (Integer.parseInt(str.substring(0, 2)) < 26)
			count[1] = 2;
		else
			count[1] = 1;
		for (int i = 2; i < count.length; i++) {
			count[i] = count[i - 1];
			if (Integer.parseInt(str.substring(i - 1, i + 1)) < 26)
				count[i] += count[i - 2];
		}

		return count[count.length - 1];
	}

}