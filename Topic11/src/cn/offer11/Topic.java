package cn.offer11;

public class Topic {

	public static void main(String[] args) {
		int[] array;
		array = new int[10];
		for (int i = 0; i < 10; i++) {
			array[i] = (int) (Math.random() * 100);
		}
		quickSort2(array, 0, 9);
		quickSort1(array, 0, 9);
		System.out.println();
		array = new int[] {1,0,1,1,0,1,1,};
		System.out.println(getMin(array));
	}

	/**
	 * 得到旋转数组中的最小数字
	 * 
	 * @param array
	 * @return
	 */
	public static int getMin(int[] array) {
		if (array == null || array.length <= 0) {
			throw new RuntimeException("Invalid parameter!");
		}

		int start = 0;
		int end = array.length - 1;
		int midIndex = start;

		while (array[start] >= array[end]) {
			if (end - start == 1) {
				midIndex = end;
				break;
			}

			midIndex = (start + end) / 2;

			if (array[midIndex] == array[start] && array[midIndex] == array[end]) {
				midIndex = start;
				for (int i = start + 1; i <= end; i++) {
					if (array[i] < array[midIndex])
						midIndex = i;
				}
				break;
			}

			if (array[midIndex] >= array[start]) {
				start = midIndex;
			}
			if (array[midIndex] <= array[end]) {
				end = midIndex;
			}
		}

		return array[midIndex];
	}

	/**
	 * 快速排序：选择srart、mid、end三个位置中的中位数最为中值，分割数组
	 * 
	 * @param array
	 * @param len
	 * @param start
	 * @param end
	 */
	public static void quickSort2(int[] array, int start, int end) {
		if (array == null || array.length <= 0 || start < 0 || end >= array.length)
			throw new RuntimeException("Invalid parameter!");

		if (end - start < 3) {
			for (int i = start; i < end; i++) {
				for (int j = i + 1; j <= end; j++) {
					if (array[i] > array[j])
						swap(array, i, j);
				}
			}
			return;
		}

		int midIndex = (end + start) / 2;
		if (array[start] > array[midIndex])
			swap(array, start, midIndex);
		if (array[start] > array[end])
			swap(array, start, end);
		if (array[midIndex] > array[end])
			swap(array, midIndex, end);
		swap(array, midIndex, end - 1);

		int left = start;
		int right = end - 1;
		while (true) {
			while (array[++left] < array[end - 1])
				;
			while (array[--right] > array[end - 1])
				;
			if (left > right)
				break;
			else {
				swap(array, left, right);
			}
		}

		swap(array, left, end - 1);

		quickSort2(array, start, left - 1);
		quickSort2(array, left + 1, end);
	}

	/**
	 * 快速排序：产生随机数来分割数组
	 * 
	 * @param array
	 * @param len
	 * @param start
	 * @param end
	 */
	public static void quickSort1(int[] array, int start, int end) {
		if (array == null || array.length <= 0 || start < 0 || end >= array.length)
			throw new RuntimeException("Invalid parameter!");

		if (start == end)
			return;

		int index = (int) (Math.random() * (end - start + 1) + start);
		swap(array, index, end);

		int minIndex = start - 1;
		for (index = start; index < end; index++) {
			if (array[index] < array[end]) {
				minIndex++;
				if (minIndex != index) {
					swap(array, index, minIndex);
				}
			}
		}

		minIndex++;
		swap(array, minIndex, end);

		if (minIndex > start) {
			quickSort1(array, start, minIndex - 1);
		}
		if (minIndex < end) {
			quickSort1(array, minIndex + 1, end);
		}
	}

	public static void swap(int[] array, int x, int y) {
		int tmp = array[x];
		array[x] = array[y];
		array[y] = tmp;
	}

}