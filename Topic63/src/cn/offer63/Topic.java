package cn.offer63;

public class Topic {

    public static void main(String[] args) {
        System.out.println(maxDiff(new int[] {9, 11, 8, 5, 7, 12, 16, 14}));
    }

    /**
     * ��Ʊ��������󣬹ؼ����ڼ�¼��ǰ������ǰ����Сֵ�͵�ǰ�������
     * 
     * @param numbers
     * @return
     */
    public static int maxDiff(int[] numbers) {
        if (numbers == null || numbers.length <= 1)
            return 0;

        int min = numbers[0];
        int maxDiff = numbers[1] - numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            int currDiff = numbers[i] - min;
            if (numbers[i] < min)
                min = numbers[i];
            if (currDiff > maxDiff)
                maxDiff = currDiff;
        }

        return maxDiff;
    }

}