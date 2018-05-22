package cn.offer48;

import java.util.Arrays;

public class Topic {

	public static void main(String[] args) {
		System.out.println(getLongestSubString("adfjbkkhbfcerxnfefwerfurnfirmzfzma"));
	}

	/**
	 * 最长不含重复字符的子串
	 * 
	 * @param src
	 * @return
	 */
	public static int getLongestSubString(String src) {
		if (src == null || src.length() == 0)
			return 0;

		int[] position = new int[26];
		Arrays.fill(position, -1);
		int currLen = 0;
		int maxLen = 0;

		for (int i = 0; i < src.length(); i++) {
			if (position[src.charAt(i) - 'a'] == -1)
				currLen++;
			else {
				int len = i - position[src.charAt(i) - 'a'];
				if (len > currLen)
					currLen++;
				else {
					if (maxLen < currLen)
						maxLen = currLen;
					currLen = len;
				}
			}
			position[src.charAt(i) - 'a'] = i;
		}

		if (maxLen < currLen)
			maxLen = currLen;

		return maxLen;
	}

}