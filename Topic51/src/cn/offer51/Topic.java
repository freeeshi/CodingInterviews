package cn.offer51;

public class Topic {

	public static void main(String[] args) {
		// 牛客测试
		long count = inversePairs(new int[] {5, 7, 7, 7, 4, 4, 4, 6});
		System.out.println(count);
	}

	/**
	 * 求数组中的逆序对，整体结构采用归并排序
	 * 将一个数组分为两个部分，分别求第一和第二部分的逆序对，并将这两部分归并排序，再求数组整体的逆序对
	 * 最终逆序对的个数是这三个逆序对数量之和
	 * 
	 * @param array
	 * @return
	 */
	public static long inversePairs(int[] array) {
		if (array == null || array.length == 0)
			return 0;

		return inversePairsCore(array, new int[array.length], 0, array.length - 1);
	}

	public static long inversePairsCore(int[] array, int[] tmp, int start, int end) {
		if (start == end)
			return 0;

		int mid = (start + end) / 2;
		long left = inversePairsCore(array, tmp, start, mid);
		long right = inversePairsCore(array, tmp, mid + 1, end);

		long count = 0L;
		int i = start, j = start, k = mid + 1;
		for (; j <= mid && k <= end; i++) {
			if (array[k] >= array[j]) {
				tmp[i] = array[j++];
			} else {
				tmp[i] = array[k++];
				count += (long) (mid - j + 1);
			}
		}

		while (j <= mid)
			tmp[i++] = array[j++];
		while (k <= end)
			tmp[i++] = array[k++];

		for (i = start; i <= end; i++) {
			array[i] = tmp[i];
		}

		return count + left + right;
	}

}