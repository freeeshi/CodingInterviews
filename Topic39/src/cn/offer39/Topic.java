package cn.offer39;

public class Topic {

	public static void main(String[] args)
	{
		int[] array = new int[] {1, 2, 3, 2, 2, 2, 4, 2, 5, 2, 3};
		System.out.println(moreThanHalfNum2(array));
	}

	/**
	 * ����Ҫ�����������޸ģ�ʱ�临�Ӷ�O(N)
	 * ����������־value��times��value��ʾԪ�ص�ֵ��times��ʾһ���Զ����value�ĳ��ִ���
	 * �������飬��������value��ȵ�Ԫ�أ�times++����ͬʱtimes--
	 * ��times--ǰ����times�Ѿ���0���Ǿ�����valueΪ��ǰԪ�ص�ֵ��times=1
	 * 
	 * @param array
	 * @return
	 */
	public static int moreThanHalfNum2(int[] array)
	{
		if (array == null || array.length <= 0)
			throw new RuntimeException("������Ч��");

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
	 * ��Ҫ�����������޸ģ�ʱ�临�Ӷ�O(N)
	 * ���һ�����ֳ��ִ�������һ�룬��ô���������������м�Ԫ��һ���Ǹ�Ԫ��
	 * �ÿ��ŵ�˼�룬������ָ�Ϊ���������֣����������м�Ԫ�ص��±��������м�Ԫ����ͬʱ����ʱ���ҵ������Ԫ��
	 * �����������ڳ��ִ�������һ���Ԫ�أ���ô��������һ�����飬ͳ�����ǵĵõ����м�Ԫ�س��ֵĴ���
	 * 
	 * @param array
	 * @return
	 */
	public static int moreThanHalfNum1(int[] array)
	{
		if (array == null || array.length <= 0)
			throw new RuntimeException("������Ч��");

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
	 * ���ź��ķ���
	 * 
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 */
	public static int Partition(int[] array, int start, int end)
	{
		if (array == null || array.length == 0 || start < 0 || end >= array.length || start > end)
			throw new RuntimeException("������Ч��");

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