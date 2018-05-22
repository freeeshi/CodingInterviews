package cn.offer03;

public class Topic {

	public static void main(String[] args) {
		int[] array1 = { 1, 0, 3, 4, 7, 2, 1, 5 };
		int[] array2 = {};
		int[] array3 = null;
		System.out.println(getDuplication2(array1));
		System.out.println(getDuplication2(array2));
		System.out.println(getDuplication2(array3));
		
		System.out.println(getDuplication1(array1));
		System.out.println(getDuplication1(array2));
		System.out.println(getDuplication1(array3));
	}

	/**
	 * n+1�����֣���Χ��1-n�����ܸı�ԭ����Ԫ�ص�λ�� �����ٿ���һ�����飬����ǰһ��������˼�룬�ռ临�Ӷ�ΪO(N)
	 * 
	 * 
	 * @param array
	 * @return
	 */
	public static int getDuplication2(int[] array) {
		if (array == null || array.length <= 0)
			return -1;

		int end = array.length - 1;
		int start = 1;
		while(end >= start) {
			int mid = (start+end)/2;
			int count = countRange(array, start, mid);
			
			if(start == end) {
				if(count > 1)
					return start;
				else
					break;
			}
			
			if(count > mid-start+1) {
				end = mid;
			}else {
				start = mid+1;
			}
		}

		return -1;
	}
	
	public static int countRange(int[] array, int start, int end) {
		int count = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] >= start && array[i] <= end) {
				count++;
			}
		}
		
		return count;
	}

	/**
	 * n�����֣���Χ��0~n-1 ���Ͻ���Ԫ�أ��ҳ�ͬһ�±�������ε����֣���Ϊ�ظ�����
	 * 
	 * @param array
	 * @return
	 */
	public static int getDuplication1(int[] array) {
		if (array == null || array.length <= 0)
			return -1;

		for (int i = 0; i < array.length; i++) {
			if (array[i] > array.length - 1)
				return -1;
		}

		for (int i = 0; i < array.length; i++) {
			while (array[i] != i) {
				if (array[i] != array[array[i]]) {
					int tmp = array[i];
					array[i] = array[tmp];
					array[tmp] = tmp;
				} else {
					return array[i];
				}
			}
		}

		return -1;
	}

}
