package cn.offer62;

import java.util.LinkedList;

public class Topic {

    public static void main(String[] args) {
        // ţ�Ͳ���
        System.out.println(lastRemaining(5, 2));
    }

    /**
     * ԲȦ�����ʣ�µ����֣���һ��������ģ��ԲȦ���Ƚ���������ӣ�Ȼ�����γ��ӣ����Ҽ���
     * ����ǰ�����˶�Ӧ����Ų���mʱ����ô��ӣ������m��������ӣ���������0
     * 
     * @param n
     * @param m
     * @return
     */
    public static int lastRemaining(int n, int m) {
        if (n <= 0 || m <= 0)
            return -1;

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++)
            queue.offer(i);

        int last = -1;
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int curr = queue.poll();
            if (count != m)
                queue.offer(curr);
            else {
                count = 0;
                last = curr;
            }
        }

        return last;
    }

}