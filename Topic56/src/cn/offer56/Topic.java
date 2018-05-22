package cn.offer56;

public class Topic {

    public static void main(String[] args) {
        // ţ�Ͳ���
        int[] num = new int[] {0};
        findNumsAppearOnce1(new int[] {1, 2, 3, 4, 1, 2, 3}, new int[] {0}, new int[] {0});
        findNumsAppearOnce2(new int[] {11, 12, 13, 11, 12, 13, 11, 13}, num);
        System.out.println(num[0]);
    }

    /**
     * ������ֻ����һ�ε�һ��������һ����ֻ����һ�Σ�����������������
     * һ��int���͵���32λ��ͳ�����������ֶ�������ÿ��λ��1���ֵĴ���
     * ���ֻ����һ�ε����ֵĶ������ڵ�iλ��0����ô��iλ����ͳ�ƽ���϶��ܱ�3��������֮��Ȼ
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
     * ������ֻ����һ�ε�����������������ֻ����һ�Σ�����������������
     * �ö��������˼·����ͬ�������Ϊ0����˽����������򣬵õ��Ľ����ʵ���ǽ�����ֻ����һ�ε������
     * ������Ľ���Ķ������У����λ��1���±�index�������������Ϊ������
     * һ�����Ƕ�������indexλ��1�ģ���һ������indexλ����1����ֻ����һ�ε��������պ÷ֱ�������������
     * �ڽ��������ֵ�����ֱ���򣬵õ��Ľ�����Ƕ�Ӧ��������
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