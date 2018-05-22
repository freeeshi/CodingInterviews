package cn.offer57;

import java.util.ArrayList;

public class Topic {

    public static void main(String[] args) {
        // 牛客测试
        ArrayList<ArrayList<Integer>> list = findContinuousSequence(3);
        System.out.println(list);
    }

    /**
     * 和为S的连续正数序列，一个初始序列start=1和end=2，当序列和小于目标和时end++，大于时start++
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
     * 和为S的两个数字，一种简单直观的方法是对每个数字匹配其他数字，时间复杂度为O(N^2)
     * 定义两个下标，start和end，当这个两个位置的和大于S时，end--，否则start++
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