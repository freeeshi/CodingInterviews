package cn.offer41;

/**
 * 求一个输入数据流的中位数，有两个方法insert和getMedian，时间复杂度为O(nlogk)
 * 输入的数据用两个堆来存储，最大堆存储较小元素，最小堆存储较大元素，两个堆的大小始终差0或1
 * 先往最大堆放数据，然后最小堆，依次执行，元素放入当前堆前先检查是否大于或者小于另一个堆的堆顶元素
 * 符合要求就直接放入当前堆，不符合的话需对另一个堆出对入队，在对放入当前堆
 * 最后求中位数只需要查找这个两个碓顶的元素即可
 * 
 * @author 石龙飞
 *
 */
public class Topic {

	private MaxHeap maxHeap = new MaxHeap();
	private MinHeap minHeap = new MinHeap();

	public static void main(String[] args) {
		// 牛客测试
		Topic topic = new Topic();
		topic.Insert(5);
		System.out.println(topic.getMedian());
		topic.Insert(2);
		System.out.println(topic.getMedian());
		topic.Insert(3);
		System.out.println(topic.getMedian());
		topic.Insert(4);
		System.out.println(topic.getMedian());
		topic.Insert(1);
		System.out.println(topic.getMedian());
		topic.Insert(6);
		System.out.println(topic.getMedian());
		topic.Insert(7);
		System.out.println(topic.getMedian());
		topic.Insert(0);
		System.out.println(topic.getMedian());
		topic.Insert(8);
		System.out.println(topic.getMedian());
	}

	public void Insert(Integer num) {
		if (maxHeap.isEmpty())
			maxHeap.offer(num);
		else if (maxHeap.size() == minHeap.size()) {
			if (num > minHeap.peek()) {
				int tmp = minHeap.poll();
				minHeap.offer(num);
				num = tmp;
			}
			maxHeap.offer(num);
		} else {
			if (num < maxHeap.peek()) {
				int tmp = maxHeap.poll();
				maxHeap.offer(num);
				num = tmp;
			}
			minHeap.offer(num);
		}
	}

	public Double getMedian() {
		if (minHeap.size() == maxHeap.size()) {
			return (double) (minHeap.peek() + maxHeap.peek()) / 2;
		} else {
			return (double) maxHeap.peek();
		}
	}

}