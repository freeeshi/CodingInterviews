package cn.offer42;

public class Topic {

	public static void main(String[] args) {
		int[] array = new int[] {-6};
		System.out.println(findGreatestSumOfSubArray2(array));
	}
	
	/**
	 * �ö�̬�滮��˼������Ψһ�ĺô����Ǽ���ȫ��ǰn����������������
	 * @param array
	 * @return
	 */
	public static int findGreatestSumOfSubArray2(int[] array) {
		if (array == null || array.length == 0)
			return 0;
		
		int[] sum = new int[array.length];
		int index = array.length;
		
		for(int i = 0; i < array.length; i++) {
			if(i == 0 || sum[i-1] < 0)
				sum[i] = array[i];
			else 
				sum[i] = sum[i-1] + array[i];
		}
		
		int maxSum = sum[0];
		for(int i = 0; i < index; i++) {
			if(maxSum < sum[i])
				maxSum = sum[i];
		}
		
		return maxSum;
	}

	/**
	 * ��������������ͣ��������������С������1���������numMax��Ӧȫ�Ǹ��������
	 * 
	 * @param array
	 * @return
	 */
	public static int findGreatestSumOfSubArray1(int[] array) {
		if (array == null || array.length == 0)
			return 0;

		int maxNum = array[0];
		int maxSum = 0;
		int currSum = 0;

		for (int i = 0; i < array.length; i++) {
			currSum += array[i];

			if (maxNum < array[i])
				maxNum = array[i];

			if (maxSum < currSum)
				maxSum = currSum;

			if (currSum < 0)
				currSum = 0;
		}

		if (maxNum < 0)
			return maxNum;

		return maxSum;
	}
}