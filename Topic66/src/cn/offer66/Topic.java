package cn.offer66;

public class Topic {

    public static void main(String[] args) {
        // ţ�Ͳ���
    }

    /**
     * �����˻������������²��ֵĳ˻����������²��ݵĳ˻����ٽ�������˾�����Ҫ�Ľ��
     * 
     * @param A
     * @return
     */
    public static int[] multiply(int[] A) {
        if (A == null || A.length == 0)
            return new int[0];

        int[] B = new int[A.length];
        B[0] = 1;
        for (int i = 1; i < A.length; i++)
            B[i] = B[i - 1] * A[i - 1];

        int tmp = 1;
        for (int i = A.length - 2; i >= 0; i--) {
            tmp *= A[i + 1];
            B[i] *= tmp;
        }

        return B;
    }

}