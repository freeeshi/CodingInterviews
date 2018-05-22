package cn.offer58;

public class Topic {

    public static void main(String[] args) {
        // 牛客测试
        StringBuilder str = new StringBuilder("hello");
        reverseCore(str, 0, str.length() - 1);
        System.out.println(str);
        System.out.println(reverseSentence("this is a fool!"));
    }
    
    /**
     * 左旋字符串，先将整体旋转，再根据n分为前后两部分，分别旋转
     * @param str
     * @param n
     * @return
     */
    public static String leftRotateString(String str,int n) {
        if(str == null || str.length() == 0 || n <= 0)
            return str;
        
        StringBuilder builder = new StringBuilder(str);
        reverseCore(builder, 0, builder.length() - 1);
        reverseCore(builder, 0, builder.length()-n-1);
        reverseCore(builder, builder.length()-n, builder.length()-1);
        
        return new String(builder);
    }

    /**
     * 反转单词顺序，先整体反转，再将单词反转
     * 
     * @param str
     * @return
     */
    public static String reverseSentence(String str) {
        if (str == null || str.length() == 0)
            return str;

        StringBuilder builder = new StringBuilder(str);
        reverseCore(builder, 0, builder.length() - 1);

        int start = 0, end = 0;
        while (start < builder.length()) {
            if (end == builder.length() || builder.charAt(end) == ' ') {
                reverseCore(builder, start, end - 1);
                end++;
                start = end;
            } else {
                end++;
            }
        }

        return new String(builder);
    }

    public static void reverseCore(StringBuilder str, int start, int end) {
        if (str == null || str.length() == 0 || start >= end)
            return;

        while (start < end) {
            char ch = str.charAt(start);
            str.setCharAt(start++, str.charAt(end));
            str.setCharAt(end--, ch);
        }
    }
}