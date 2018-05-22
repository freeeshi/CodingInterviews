package cn.offer45;

import java.util.Arrays;
import java.util.Comparator;

public class Topic {

	public static void main(String[] args) {
		// ţ�Ͳ���
	}

	/**
	 * ����һ�����������飬����������������ƴ�������ų�һ��������ӡ��ƴ�ӳ���������������С��һ��
	 * ������m��n�������������Ϊmn����nm�����mn<nm����ô�Ͷ���mС��n�����mn>nm���Ͷ���m����n��mn=nm��Ϊ����
	 * ʵʱ��ֻ��Ҫ������������򣬶����������Ǹոն���ģ����������ɵ���С�����ǰ�����˳����ϵ�����
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
 * �Զ���ıȽ���
 * 
 * @author ʯ����
 *
 */
class MyComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer a, Integer b) {
		int i = (a + "" + b).compareTo(b + "" + a);
		return i == 0 ? 0 : (i > 0 ? 1 : -1);
	}

}