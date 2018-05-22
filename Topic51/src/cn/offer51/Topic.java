package cn.offer51;

public class Topic {

	public static void main(String[] args) {
		// ţ�Ͳ���
		long count = inversePairs(new int[] {5, 7, 7, 7, 4, 4, 4, 6});
		System.out.println(count);
	}

	/**
	 * �������е�����ԣ�����ṹ���ù鲢����
	 * ��һ�������Ϊ�������֣��ֱ����һ�͵ڶ����ֵ�����ԣ������������ֹ鲢����������������������
	 * ��������Եĸ��������������������֮��
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