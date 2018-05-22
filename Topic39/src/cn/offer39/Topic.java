package cn.offer39;

public class Topic {

	public static void main(String[] args)
	{
		int[] array = new int[] {1, 2, 3, 2, 2, 2, 4, 2, 5, 2, 3};
		System.out.println(moreThanHalfNum2(array));
	}

	/**
	 * 不需要对数组做出修改，时间复杂度O(N)
	 * 给定两个标志value和times，value表示元素的值，times表示一种自定义的value的出现次数
	 * 遍历数组，当遇到和value相等的元素，times++，不同时times--
	 * 当times--前发现times已经是0，那就设置value为当前元素的值，times=1
	 * 
	 * @param array
	 * @return
	 */
	public static int moreThanHalfNum2(int[] array)
	{
		if (array == null || array.length <= 0)
			throw new RuntimeException("输入无效！");

		int value = array[0];
		int times = 1;

		for (int i = 1; i < array.length; i++) {
			if (array[i] == value)
				times++;
			else {
				if (times != 0)
					times--;
				else {
					value = array[i];
					times = 1;
				}
			}
		}

		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == value)
				count++;
		}

		if (count * 2 <= array.length)
			return 0;
		else
			return value;
	}

	/**
	 * 需要对数组做出修改，时间复杂度O(N)
	 * 如果一个数字出现次数超过一半，那么把这个数组排序后，中间元素一定是该元素
	 * 用快排的思想，将数组分割为左右两部分，当快排中中间元素的下表与数组中间元素相同时，此时就找到了这个元素
	 * 如果考虑如存在出现次数超过一半的元素，那么最后还需遍历一次数组，统计我们的得到的中间元素出现的次数
	 * 
	 * @param array
	 * @return
	 */
	public static int moreThanHalfNum1(int[] array)
	{
		if (array == null || array.length <= 0)
			throw new RuntimeException("输入无效！");

		int mid = array.length / 2;
		int start = 0;
		int end = array.length - 1;
		int index = Partition(array, start, end);
		while (mid != index) {
			if (index > mid) {
				end = index - 1;
				index = Partition(array, start, end);
			} else {
				start = index + 1;
				index = Partition(array, start, end);
			}
		}

		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == array[mid])
				count++;
		}

		if (count * 2 <= array.length)
			return 0;
		else
			return array[mid];
	}

	/**
	 * 快排核心方法
	 * 
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 */
	public static int Partition(int[] array, int start, int end)
	{
		if (array == null || array.length == 0 || start < 0 || end >= array.length || start > end)
			throw new RuntimeException("输入无效！");

		int mid = (start + end) / 2;
		if (array[start] > array[mid])
			swap(array, start, mid);
		if (array[start] > array[end])
			swap(array, start, end);
		if (array[mid] > array[end])
			swap(array, mid, end);

		if (end - start < 3)
			return mid;

		int endTmp = end;
		int midValue = array[mid];
		swap(array, mid, end - 1);

		end--;
		while (true) {
			while (array[++start] < midValue);
			while (array[--end] > midValue);

			if (start < end)
				swap(array, start, end);
			else {
				swap(array, start, endTmp - 1);
				break;
			}
		}

		return start;
	}

	public static void swap(int[] a, int x, int y)
	{
		int tmp = a[x];
		a[x] = a[y];
		a[y] = tmp;
	}

}