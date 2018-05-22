package cn.offer53;

public class Topic {

    public static void main(String[] args) {
        // 牛客测试
        System.out.println(getNumberOfK(new int[] {1, 1, 2, 3, 3, 4, 4, 4, 4, 5}, 7));
        System.out.println(getMissingNumber(new int[] {0, 1, 2, 3, 4}));
    }

    /**
     * 0~n-1中缺失的数字
     * 
     * @param array
     * @return
     */
    public static int getMissingNumber(int[] array) {
        if (array == null || array.length == 0)
            return 0;

        int start = 0, end = array.length - 1;
        int mid = (start + end) / 2;
        while (start <= end) {
            if (array[mid] == mid)
                start = mid + 1;
            else
                end = mid - 1;
            mid = (start + end) / 2;
        }

        if (end == -1)
            mid = 0;
        else if (start == array.length)
            mid = array.length;
        else
            mid = end + 1;

        return mid;
    }

    /**
     * 数字在排序数组中出现的次数
     * 
     * @param array
     * @param k
     * @return
     */
    public static int getNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0)
            return 0;

        int start = 0, end = array.length - 1;
        int mid = (start + end) / 2;
        int first = -1, last = -1;
        while (start <= end) {
            if (array[mid] == k && (mid == 0 || array[mid - 1] != k)) {
                first = mid;
                break;
            }
            if (array[mid] > k || array[mid] == k)
                end = mid - 1;
            else
                start = mid + 1;
            mid = (start + end) / 2;
        }

        start = 0;
        end = array.length - 1;
        mid = (start + end) / 2;
        while (start <= end) {
            if (array[mid] == k && (mid == array.length - 1 || array[mid + 1] != k)) {
                last = mid;
                break;
            }
            if (array[mid] == k || array[mid] < k)
                start = mid + 1;
            else
                end = mid - 1;
            mid = (start + end) / 2;
        }

        if (first != -1)
            return last - first + 1;
        else
            return 0;
    }

}