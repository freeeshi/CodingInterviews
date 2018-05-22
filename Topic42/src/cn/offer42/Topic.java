package cn.offer42;

public class Topic {

	public static void main(String[] args) {
		int[] array = new int[] {-6};
		System.out.println(findGreatestSumOfSubArray2(array));
	}
	
	/**
	 * 用动态规划的思想做，唯一的好处就是计算全局前n个树的最大子数组和
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
	 * 连续子数组的最大和，这里子数组的最小长度是1，因此引入numMax对应全是负数的情况
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