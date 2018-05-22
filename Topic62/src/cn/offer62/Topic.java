package cn.offer62;

import java.util.LinkedList;

public class Topic {

    public static void main(String[] args) {
        // 牛客测试
        System.out.println(lastRemaining(5, 2));
    }

    /**
     * 圆圈中最后剩下的数字，用一个队列来模拟圆圈，先将所有人入队，然后依次出队，并且计数
     * 当当前出队人对应的序号不是m时，那么入队，如果是m，不再入队，计数器置0
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