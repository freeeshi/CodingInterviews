package cn.offer41;

/**
 * ��һ����������������λ��������������insert��getMedian��ʱ�临�Ӷ�ΪO(nlogk)
 * ��������������������洢�����Ѵ洢��СԪ�أ���С�Ѵ洢�ϴ�Ԫ�أ������ѵĴ�Сʼ�ղ�0��1
 * �������ѷ����ݣ�Ȼ����С�ѣ�����ִ�У�Ԫ�ط��뵱ǰ��ǰ�ȼ���Ƿ���ڻ���С����һ���ѵĶѶ�Ԫ��
 * ����Ҫ���ֱ�ӷ��뵱ǰ�ѣ������ϵĻ������һ���ѳ�����ӣ��ڶԷ��뵱ǰ��
 * �������λ��ֻ��Ҫ������������Զ���Ԫ�ؼ���
 * 
 * @author ʯ����
 *
 */
public class Topic {

	private MaxHeap maxHeap = new MaxHeap();
	private MinHeap minHeap = new MinHeap();

	public static void main(String[] args) {
		// ţ�Ͳ���
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