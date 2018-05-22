package cn.offer59;

import java.util.ArrayList;
import java.util.LinkedList;

public class Topic {

    public static void main(String[] args) {
        // ţ�Ͳ���
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
     * �������ڵ����ֵ����һ��˫���ж��������п��ܳ�Ϊ���ֵ��Ԫ�ض�Ӧ���±꣬���ҽ����ֵ���±걣���ڶ���
     * ��ǰ��ӵ�ֵС�ڶ��׶�Ӧ��ֵʱ��Ӧ����������������Ԫ�أ��������Ӧ���±���ӣ���Ϊ֮ǰ���е�ֵ�������ܳ�Ϊ�Ժ󻬶����ڵ����ֵ��
     * ��С�ڶ��׶�Ӧ��ֵʱ���Ӷ�β��ʼ���Ƴ����бȵ�ǰֵС��Ԫ�أ���󽫸�Ԫ�����
     * ����ÿ���������ڵ����ֵ���ǵ�ǰ˫�˶��ж���Ԫ���±��Ӧ��ֵ
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