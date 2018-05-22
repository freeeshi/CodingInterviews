package cn.offer61;

public class Topic {

    public static void main(String[] args) {
        // ţ�Ͳ���
    }

    /**
     * �˿���˳�ӣ������������������ĸ�����������֮��ļ����ֻ�д����������ڵ��ڼ�������������˳��
     * �м���������ظ����ƣ��ǾͲ������˳��
     * 
     * @param numbers
     * @return
     */
    public static boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return false;

        int[] poker = new int[14];
        int first = 13, last = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0)
                poker[numbers[i]]++;
            else {
                if (poker[numbers[i]] != 0)
                    return false;

                if (first > numbers[i])
                    first = numbers[i];
                if (last < numbers[i])
                    last = numbers[i];
                poker[numbers[i]]++;

            }
        }

        int space = last - first + 1 - (numbers.length - poker[0]);
        if (space > poker[0])
            return false;

        return true;
    }

}