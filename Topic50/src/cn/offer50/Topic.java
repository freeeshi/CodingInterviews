package cn.offer50;

import java.util.Arrays;

public class Topic {

    public static void main(String[] args) {
        // ţ�Ͳ���
        System.out.println(firstNotRepeatingChar("a\0#sdf@sa"));
    }

    private int count[] = new int[256];
    private int counter = 1;

    /**
     * �ַ����е�һ��ֻ����һ�ε��ַ������룬�����ǰ�ַ�δ���ֹ�����¼���ַ����ֵĴ�������Ѿ����ֹ����ö�Ӧ��ֵΪ-1
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
     * �ַ����е�һ��ֻ����һ�ε��ַ������ص�һ������һ�ε��ַ���
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
     * ��һ��ֻ����һ�ε��ַ�����������ַ���λ�ã������ַ���8λASCII���ʾ�ķ�Χ֮��
     * ʹ��һ����СΪ256�����飬��¼�ַ����ֵ����
     * ��ʼ��Ϊ-1����ʾδ���֣�����һ�μ�¼����Ϊλ�ã����ֵӦ��>=0�����ֶ�μ�Ϊ-2
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