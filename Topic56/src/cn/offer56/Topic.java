package cn.offer56;

public class Topic {

    public static void main(String[] args) {
        // 牛客测试
        int[] num = new int[] {0};
        findNumsAppearOnce1(new int[] {1, 2, 3, 4, 1, 2, 3}, new int[] {0}, new int[] {0});
        findNumsAppearOnce2(new int[] {11, 12, 13, 11, 12, 13, 11, 13}, num);
        System.out.println(num[0]);
    }

    /**
     * 数组中只出现一次的一个数：有一个数只出现一次，起他数都出现三次
     * 一个int类型的有32位，统计数组中数字二进制中每个位上1出现的次数
     * 如果只出现一次的数字的二进制在第i位是0，那么第i位最后的统计结果肯定能被3整除，反之亦然
     * 
     * @param array
     * @param num
     */
    public static void findNumsAppearOnce2(int[] array, int num[]) {
        if (array == null || array.length == 0 || num == null)
            return;

        int[] bitCount = new int[32];
        for (int i = 0; i < array.length; i++) {
            int flag = 1;
            for (int j = 31; j >= 0; j--) {
                if ((array[i] & flag) != 0)
                    bitCount[j]++;
                flag = flag << 1;
            }
        }

        for (int i = 0; i < bitCount.length; i++) {
            if (bitCount[i] % 3 != 0)
                num[0] += (1 << (bitCount.length - 1 - i));
        }
    }

    /**
     * 数组中只出现一次的两个数：有两个数只出现一次，起他数都出现两次
     * 用二进制异或思路：相同的数异或为0，因此将这个数组异或，得到的结果其实就是将两个只出现一次的数异或
     * 求出异或的结果的二进制中，最高位的1的下标index，将整个数组分为两部分
     * 一部分是二进制中index位是1的，另一部分其index位不是1，而只出现一次的两个数刚好分别在这两部分里
     * 在将这两部分的数组分别异或，得到的结果就是对应的两个数
     * 
     * @param array
     * @param num1
     * @param num2
     */
    public static void findNumsAppearOnce1(int[] array, int num1[], int num2[]) {
        if (array == null || array.length == 0 || num1 == null || num2 == null)
            return;

        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result ^= array[i];
        }

        int index = 0;
        while (index <= 32 && (result = result >> 1) != 0)
            index++;

        int flag = 1 << index;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & flag) == 0)
                num1[0] ^= array[i];
            else
                num2[0] ^= array[i];
        }
    }

}