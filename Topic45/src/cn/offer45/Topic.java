package cn.offer45;

import java.util.Arrays;
import java.util.Comparator;

public class Topic {

	public static void main(String[] args) {
		// 牛客测试
	}

	/**
	 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个
	 * 假设有m和n，两个数字组合为mn或者nm，如果mn<nm，那么就定义m小于n，如果mn>nm，就定义m大于n，mn=nm则为等于
	 * 实时上只需要对数组进行排序，而排序规则就是刚刚定义的，最后所能组成的最小数便是按数组顺序组合的数字
	 * 
	 * @param numbers
	 * @return
	 */
	public String printMinNumber(int[] numbers) {
		if (numbers == null || numbers.length == 0)
			return "";

		Integer[] nums = new Integer[numbers.length];
		for (int i = 0; i < numbers.length; i++)
			nums[i] = numbers[i];

		Arrays.sort(nums, new MyComparator());

		StringBuilder result = new StringBuilder();
		for (int i = 0; i < numbers.length; i++)
			result.append(nums[i]);

		return new String(result);
	}

}

/**
 * 自定义的比较器
 * 
 * @author 石龙飞
 *
 */
class MyComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer a, Integer b) {
		int i = (a + "" + b).compareTo(b + "" + a);
		return i == 0 ? 0 : (i > 0 ? 1 : -1);
	}

}