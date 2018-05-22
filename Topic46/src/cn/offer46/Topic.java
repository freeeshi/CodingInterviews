package cn.offer46;

public class Topic {

	public static void main(String[] args) {
		// ţ�Ͳ���
		getTranslationCount(25);
	}

	/**
	 * �����ַ�����ַ�����0~25�ֱ��Ӧa~z����һ�����֣������ж����ַ��뷽��
	 * 17���Ա������1��7��Ӧ����ĸ��Ҳ���Կ���17��Ӧ����ĸ������һ�����͵�DP���⣬������һά���鴦���ȼۼ�
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