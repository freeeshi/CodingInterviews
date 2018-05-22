package cn.offer16;

public class Topic {

	public static void main(String[] args) {
		double n = 2;
		int e = 40;
		System.out.println(power(n, e));
	}
	
	public static double power(double n, int e) {
		if (n == 0) {
			if (e <= 0)
				throw new RuntimeException("Invalid parameter!");
			else
				return 0.0;
		}
		
		int abse = e < 0 ? -e : e;
//		double result = forPower(n, abse);
		double result = recPower(n, abse);
		result = e < 0 ? 1.0 / result : result;
		
		return result;
	}

	/**
	 * �õݹ��������㣬���Դ�����Ч�ʣ�ʱ�临�Ӷ�ΪO(logN)
	 * @param n
	 * @param e
	 * @return
	 */
	public static double recPower(double n, int e) {
		if (e == 0)
			return 1;

		double result = recPower(n, e >> 1);
		result *= result;
		
		if((e & 1) != 0)
			result *= n;
		
		return result;
	}
	
	/**
	 * ʹ�ó����forѭ�����ݣ�ʱ�临�Ӷ�ΪO(N)
	 * @param n
	 * @param e
	 * @return
	 */
	public static double forPower(double n, int e) {
		double result = 1;
		for (int i = 0; i < e; i++) {
			result *= n;
		}
		return result;
	}

}