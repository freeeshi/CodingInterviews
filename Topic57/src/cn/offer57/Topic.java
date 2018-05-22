package cn.offer57;

import java.util.ArrayList;

public class Topic {

    public static void main(String[] args) {
        // ţ�Ͳ���
        ArrayList<ArrayList<Integer>> list = findContinuousSequence(3);
        System.out.println(list);
    }

    /**
     * ��ΪS�������������У�һ����ʼ����start=1��end=2�������к�С��Ŀ���ʱend++������ʱstart++
     * 
     * @param sum
     * @return
     */
    public static ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (sum < 3)
            return list;

        int mid = (sum + 1) / 2;
        int start = 1, end = 2;
        int currSum = 3;
        while (end <= mid) {
            if (currSum == sum) {
                ArrayList<Integer> tmp = new ArrayList<>();
                for (int i = start; i <= end; i++)
                    tmp.add(i);
                list.add(tmp);
                end++;
                currSum += end;
            } else if (currSum < sum) {
                end++;
                currSum += end;
            } else {
                currSum -= start;
                start++;
            }
        }

        return list;
    }

    /**
     * ��ΪS���������֣�һ�ּ�ֱ�۵ķ����Ƕ�ÿ������ƥ���������֣�ʱ�临�Ӷ�ΪO(N^2)
     * ���������±꣬start��end�����������λ�õĺʹ���Sʱ��end--������start++
     * 
     * @param array
     * @param sum
     * @return
     */
    public static ArrayList<Integer> findNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if (array == null || array.length == 0)
            return list;

        int start = 0, end = array.length - 1;
        while (start < end) {
            if (array[start] + array[end] == sum)
                break;
            if (array[start] + array[end] > sum)
                end--;
            else
                start++;
        }

        if (start < end) {
            list.add(array[start]);
            list.add(array[end]);
        }

        return list;
    }

}