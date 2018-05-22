package cn.offer40;

import java.util.ArrayList;

public class Topic {

	public static void main(String[] args) {
		int[] arary = new int[] {4, 5, 1, 6, 2, 7, 3, 8};
		System.out.println(getLeastNumbers2(arary, 4));

	}

	/**
	 * ʹ��һ����СΪk���������������ĿǰΪֹ��С��k������������������������ǹؼ�
	 * �������е�Ԫ������С��kʱ��ֱ�Ӽӽ�ȥ����������С�ﵽk����
	 * �����ǰֵС���������ֵ��ɾ���������ֵ�����뵱ǰֵ�������ù�
	 * �������ʹ�����ѣ���PriorityQueue��ʵ��
	 * 
	 * @param input
	 * @param k
	 * @return
	 */
	public static ArrayList<Integer> getLeastNumbers2(int[] input, int k) {
		ArrayList<Integer> list = new ArrayList<>();
		if (input == null || input.length <= 0 || k > input.length || k == 0)
			return list;

		MaxHeap queue = new MaxHeap();
		for (int i = 0; i < input.length; i++) {
			if (queue.size() < k)
				queue.offer(input[i]);
			else {
				if (input[i] < queue.peek()) {
					queue.poll();
					queue.offer(input[i]);
				}
			}
		}

		while (!queue.isEmpty()) {
			list.add(queue.poll());
		}

		return list;
	}

	/**
	 * �ÿ��ŵ�˼���ҳ�ǰk����С��Ԫ��
	 * 
	 * @param input
	 * @param k
	 * @return
	 */
	public static ArrayList<Integer> getLeastNumbers1(int[] input, int k) {
		ArrayList<Integer> list = new ArrayList<>();
		if (input == null || input.length <= 0 || k > input.length || k == 0)
			return list;

		int start = 0;
		int end = input.length - 1;
		int index = Partition(input, start, end);
		while (index != k - 1) {
			if (index > k - 1) {
				end = index - 1;
				index = Partition(input, start, end);
			} else {
				start = index + 1;
				index = Partition(input, start, end);
			}
		}

		for (int i = 0; i < k; i++) {
			list.add(input[i]);
		}

		return list;
	}

	public static int Partition(int[] array, int start, int end) {
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

	public static void swap(int[] a, int x, int y) {
		int tmp = a[x];
		a[x] = a[y];
		a[y] = tmp;
	}
}