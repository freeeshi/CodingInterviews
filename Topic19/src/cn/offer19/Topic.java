package cn.offer19;

public class Topic {

	public static void main(String[] args) {
		System.out.println(regexpMatch2("ab*a", "a"));
	}

	/**
	 * �ݹ�ƥ������
	 * 
	 * @param tmplate
	 * @param src
	 * @return
	 */
	public static boolean regexpMatch2(String tmplate, String src) {
		if (tmplate == null || src == null)
			throw new RuntimeException("Invalid parameter!");

		return matching(tmplate, src, 0, 0);
	}

	/**
	 * �ݹ�ƥ�䣺��ͬƥ���.��ƥ����ͬ����Ҫ���*��ƥ�䣬����*��1)���ԣ�2)ƥ��һ����3)ƥ����������һ��ƥ�伴Ϊƥ��
	 * 
	 * @param tmplate
	 * @param src
	 * @param ti
	 * @param si
	 * @return
	 */
	public static boolean matching(String tmplate, String src, int ti, int si) {
		int tmplateLen = tmplate.length();
		int srcLen = src.length();

		if (ti == tmplateLen && si == srcLen)
			return true;
		if (si != srcLen && ti == tmplateLen)
			return false;

		if (ti < tmplateLen - 1 && tmplate.charAt(ti + 1) == '*') {
			if (si < srcLen && (tmplate.charAt(ti) == src.charAt(si) || tmplate.charAt(ti) == '.'))
				return matching(tmplate, src, ti + 2, si) || matching(tmplate, src, ti + 2, si++)
						|| matching(tmplate, src, ti, si++);
			else
				return matching(tmplate, src, ti + 2, si);
		}

		if (si < srcLen) {
			if ((tmplate.charAt(ti) == '.' || tmplate.charAt(ti) == src.charAt(si)))
				return matching(tmplate, src, ti + 1, si + 1);
		}

		return false;
	}

	/**
	 * һ��ʧ�ܵĴ��룬û�п��ǵ�.*�����������ba*ab��˼·Ҳ��̫��
	 * 
	 * @param tmplate
	 * @param src
	 * @return
	 */
	public static boolean regexpMatch1(String tmplate, String src) {
		int tmplateLen = tmplate.length();
		int srcLen = src.length();
		int ti = 0;
		int si = 0;
		boolean isMatch = true;
		while (isMatch && ti != tmplateLen) {
			if (tmplate.charAt(ti) == '.') {
				ti++;
				si++;
			} else if (ti < tmplateLen - 1 && tmplate.charAt(ti + 1) == '*') {
				char ch = tmplate.charAt(ti);
				while (si != srcLen && ch == src.charAt(si))
					si++;
				ti += 2;
			} else {
				if (tmplate.charAt(ti) == src.charAt(si)) {
					ti++;
					si++;
				} else {
					isMatch = false;
					break;
				}
			}
		}

		if (!isMatch || ti != tmplateLen || si != srcLen)
			isMatch = false;

		return isMatch;
	}

}