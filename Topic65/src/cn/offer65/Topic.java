package cn.offer65;

public class Topic {

    public static void main(String[] args) {
        // ţ�Ͳ���
        System.out.println(add(3, -5));
    }

    /**
     * ���üӼ��˳����ӷ����ؼ��㣬���������Ϊ��ӣ��ٿ��ƺý�λ����
     * 
     * @param num1
     * @param num2
     * @return
     */
    public static int add(int num1, int num2) {
        int carry = 0;
        int mask = 1;
        int result = 0;
        for (int i = 0; i < 32; i++, mask = mask << 1) {
            int bit1 = num1 & mask;
            int bit2 = num2 & mask;
            result += bit1 ^ bit2 ^ carry;

            if ((bit1 & bit2) != 0 || (bit1 & carry) != 0 || (bit2 & carry) != 0)
                carry = mask << 1;
            else
                carry = 0;
        }

        return result;
    }

}