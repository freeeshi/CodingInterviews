package cn.offer50;

import java.util.Arrays;

public class Topic {

    public static void main(String[] args) {
        // 牛客测试
        System.out.println(firstNotRepeatingChar("a\0#sdf@sa"));
    }

    private int count[] = new int[256];
    private int counter = 1;

    /**
     * 字符流中第一个只出现一次的字符：插入，如果当前字符未出现过，记录此字符出现的次序，如果已经出现过，置对应的值为-1
     * 
     * @return
     */
    public void Insert(char ch) {
        if (count[ch] == 0)
            count[ch] = counter++;
        else
            count[ch] = -1;
    }

    /**
     * 字符流中第一个只出现一次的字符：返回第一个出现一次的字符，
     * 
     * @return
     */
    public char FirstAppearingOnce() {
        char result = '#';
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 256; i++) {
            if (count[i] > 0 && min > count[i]) {
                result = (char) i;
                min = count[i];
            }
        }
        return result;
    }

    /**
     * 第一个只出现一次的字符，返回这个字符的位置，假设字符在8位ASCII码表示的范围之内
     * 使用一个大小为256的数组，记录字符出现的情况
     * 初始化为-1，表示未出现，出现一次记录出现为位置，这个值应该>=0，出现多次记为-2
     * 
     * @param str
     * @return
     */
    public static int firstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0)
            return -1;

        int count[] = new int[256];
        Arrays.fill(count, -1);
        char ch = 0;

        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            if (count[ch] == -1)
                count[ch] = i;
            else if (count[ch] >= 0)
                count[ch] = -2;
        }

        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            if (count[ch] >= 0)
                break;
        }

        return count[ch];
    }

}