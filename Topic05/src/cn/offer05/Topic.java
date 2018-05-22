package cn.offer05;

import java.util.ArrayList;
import java.util.List;

public class Topic {

	public static void main(String[] args) {
		String str = "6644664464464646464";
		System.out.println(str);
		System.out.println(replaceSubstr1("6644664464464646464", "46", "--"));
	}

	/**
	 * ���ַ�����ָ�����ִ�ȫ���滻Ϊ��һ���ַ���
	 * ����ǰ�벿�ֲ�������forѭ����ʱ�临�ӶȽϸߣ����������KMP�����Ż�
	 * @param str
	 * @param src
	 * @param dist
	 * @return
	 */
	public static String replaceSubstr1(String str, String src, String dist) {
		if (str == null || src == null || dist == null)
			return null;

		if (str.length() == 0 || src.length() == 0)
			return str;

		int subCount = 0;
		int strLen = str.length();
		int srcLen = src.length();
		List<Integer> indexs = new ArrayList<>();

		for (int i = 0; i < strLen; i++) {
			if (str.charAt(i) == src.charAt(0)) {
				int count = 1;
				for (int j = 1; j < srcLen && i + j < strLen && str.charAt(i + j) == src.charAt(j); j++) {
					count++;
				}
				if (count == srcLen) {
					indexs.add(i);
					i += srcLen - 1;
					subCount++;
				}
			}
		}

		StringBuilder newStr = new StringBuilder();
		int start = 0;
		for (int i = 0; i < subCount; i++) {
			int index = indexs.get(i);
			newStr.append(str.substring(start, index)).append(dist);
			start = index + srcLen;
		}
		if (start != strLen)
			newStr.append(str.substring(start, strLen));

		return new String(newStr);
	}

}
