package cn.offer67;

public class Topic {

    public static void main(String[] args) {
        // 牛客测试
        System.out.println(strToInt("+123"));
    }

    /**
     * 将字符串转换成整数
     * 
     * @param str
     * @return
     */
    public static int strToInt(String str) {
        if (str == null || str.length() == 0)
            return 0;

        int result = 0;
        int sign = 0;
        int index = 0;
        if (str.charAt(0) == '-')
            sign = -1;
        if (str.charAt(0) == '+')
            sign = 1;
        if (sign != 0)
            index++;

        int mask = 1;
        int i;
        for (i = str.length() - 1; i >= index; i--, mask *= 10) {
            if (check(str.charAt(i)))
                result += (str.charAt(i) - '0') * mask;
            else
                return 0;
        }

        if (sign != 0)
            return result * sign;
        return result;
    }

    public static boolean check(char ch) {
        return ch >= '0' && ch <= '9';
    }

}