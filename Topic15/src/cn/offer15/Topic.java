package cn.offer15;

public class Topic {

	public static void main(String[] args) {
		int num = -1;
		// System.out.println(countOfOne1(num));
		System.out.println(countOfOne2(num));
		System.out.println(countOfOne3(num));
	}

	/**
	 * ����˼�룺num-1��num��&���㣬�൱�ڰ�num���ұߵ�1��Ϊ0�����ѭ����ֱ��numΪ0���ж���1��ѭ�����ٴ�
	 * 
	 * @param num
	 * @return
	 */
	public static int countOfOne3(int num) {
		int count = 0;

		while (num != 0) {
			count++;
			num = num & (num - 1);
		}

		return count;
	}

	/**
	 * ��һ��flag������ÿ������һλ����ԭ��������λ�룬�õ�1�ĸ���
	 * 
	 * @param num
	 * @return
	 */
	public static int countOfOne2(int num) {
		int count = 0;
		int flag = 1;

		while (flag != 0) {
			if ((flag & num) != 0) {
				count++;
			}
			flag = flag << 1;
		}

		return count;
	}

	/**
	 * ��numѭ��������λ���ж����һλ�Ƿ�Ϊ1������Ǹ����Ļ����������ѭ��
	 * 
	 * @param num
	 * @return
	 */
	public static int countOfOne1(int num) {
		int count = 0;

		while (num != 0) {
			if ((num & 1) != 0)
				count++;
			num = num >> 1;
		}

		return count;
	}

}