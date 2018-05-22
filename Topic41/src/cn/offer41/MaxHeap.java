package cn.offer41;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxHeap extends PriorityQueue<Integer> {

	private static final long serialVersionUID = 1L;

	public MaxHeap() {
		super(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2)
			{
				if (o1 > o2)
					return -1;
				else if (o1 < o2)
					return 1;
				else
					return 0;
			}
		});
	}

	public MaxHeap(int size) {
		super(size);
	}
}
