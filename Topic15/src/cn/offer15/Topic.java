package cn.offer15;

public class Topic {

	public static void main(String[] args) {
		int num = -1;
		// System.out.println(countOfOne1(num));
		System.out.println(countOfOne2(num));
		System.out.println(countOfOne3(num));
	}

	/**
	 * 核心思想：num-1和num做&运算，相当于把num最右边的1变为0，如此循环，直至num为0，有多少1，循环多少次
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
	 * 用一个flag变量，每次左移一位，与原来的数按位与，得到1的个数
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
	 * 将num循环向右移位，判断最后一位是否为1，如果是负数的话，会进入死循环
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