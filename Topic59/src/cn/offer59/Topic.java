package cn.offer59;

import java.util.ArrayList;
import java.util.LinkedList;

public class Topic {

    public static void main(String[] args) {
        // 牛客测试
        System.out.println(maxInWindows(new int[] {2, 3, 4, 2, 6, 2, 5, 1}, 3));
        
        QueueWithMax queue = new QueueWithMax();
        queue.offer(3);
        System.out.println(queue.max());
        queue.offer(6);
        System.out.println(queue.max());
        queue.poll();
        System.out.println(queue.max());
        queue.offer(0);
        System.out.println(queue.max());
        queue.offer(22);
        System.out.println(queue.max());
        queue.offer(9);
        System.out.println(queue.max());
        queue.offer(1);
        System.out.println(queue.max());
    }

    /**
     * 滑动窗口的最大值，用一个双端列队来保存有可能成为最的值的元素对应的下标，并且将最大值得下标保存在队首
     * 当前入队的值小于队首对应的值时，应该是清除队里的所有元素，将这个对应的下标入队，因为之前所有的值都不可能成为以后滑动窗口的最大值了
     * 当小于队首对应的值时，从队尾开始，移出所有比当前值小的元素，最后将该元素入队
     * 这样每个滑动窗口的最大值就是当前双端队列队首元素下标对应的值
     * 
     * @param num
     * @param size
     * @return
     */
    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if (num == null || num.length == 0 || size <= 0 || size > num.length)
            return list;

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            while (!queue.isEmpty() && num[i] > num[queue.getLast()])
                queue.removeLast();
            queue.addLast(i);
        }

        list.add(num[queue.getFirst()]);
        for (int i = size; i < num.length; i++) {
            if (queue.getFirst() == i - size)
                queue.removeFirst();
            while (!queue.isEmpty() && num[i] > num[queue.getLast()])
                queue.removeLast();
            queue.addLast(i);
            list.add(num[queue.getFirst()]);
        }

        return list;
    }

}

class QueueWithMax {
    private LinkedList<Integer> queue;
    private LinkedList<Integer> max;

    public QueueWithMax() {
        this.queue = new LinkedList<>();
        this.max = new LinkedList<>();
    }
    
    public int max() {
        return max.getFirst();
    }
    
    public int poll() {
        int result = queue.poll();
        if(result == max.getFirst())
            max.removeFirst();
        return result;
    }

    public boolean offer(int value) {
        boolean result = queue.offer(value);
        if (result) {
            while (!max.isEmpty() && value > max.getLast())
                max.removeLast();
            max.addLast(value);
        }

        return result;
    }
}