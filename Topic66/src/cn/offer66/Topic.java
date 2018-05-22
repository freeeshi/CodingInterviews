package cn.offer66;

public class Topic {

    public static void main(String[] args) {
        // 牛客测试
    }

    /**
     * 构建乘积矩阵，先求左下部分的乘积，再求右下部份的乘积，再将两者相乘就是需要的结果
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