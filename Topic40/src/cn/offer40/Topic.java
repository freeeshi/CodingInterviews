package cn.offer40;

import java.util.ArrayList;

public class Topic {

	public static void main(String[] args) {
		int[] arary = new int[] {4, 5, 1, 6, 2, 7, 3, 8};
		System.out.println(getLeastNumbers2(arary, 4));

	}

	/**
	 * 使用一个大小为k的容器来保存截至目前为止最小的k个数，这个容器的数据类型是关键
	 * 当容器中的元素数量小于k时，直接加进去，当容器大小达到k，、
	 * 如果当前值小于容器最大值，删除容器最大值，放入当前值，否则不用管
	 * 因此这里使用最大堆，用PriorityQueue类实现
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
	 * 用快排的思想找出前k个最小的元素
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

	public static void swap(int[] a, int x, int y) {
		int tmp = a[x];
		a[x] = a[y];
		a[y] = tmp;
	}
}