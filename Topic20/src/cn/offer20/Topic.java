package cn.offer20;

public class Topic {

	public static void main(String[] args) {
		System.out.println(isNumeric("123.".toCharArray()));
	}

	/**
	 * 需要扫描的有五个部分，且按序扫描：整数-小数点-小数-e-指数
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(char[] str) {
		if (str == null || str.length == 0)
			return false;

		int index = matchInteger(str, 0);

		if (index < str.length - 1 && str[index] == '.') {
			index = matchUnsignedInteger(str, index + 1);
		}

		if (index < str.length - 1 && (str[index] == 'e' || str[index] == 'E')) {
			index = matchInteger(str, index + 1);
		}

		return index == str.length;
	}

	public static int matchUnsignedInteger(char[] numStr, int index) {
		for (; index < numStr.length && numStr[index] >= '0' && numStr[index] <= '9'; index++)
			;
		return index;
	}

	public static int matchInteger(char[] numStr, int index) {
		if (index < numStr.length) {
			if (numStr[index] == '+' || numStr[index] == '-') {
				index = matchUnsignedInteger(numStr, index + 1);
			} else {
				index = matchUnsignedInteger(numStr, index);
			}
		}

		return index;
	}

}