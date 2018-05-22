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
	 * n+1个数字，范围在1-n，不能改变原数组元素的位置 可以再开辟一个数组，利用前一个方法的思想，空间复杂度为O(N)
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
	 * n个数字，范围在0~n-1 不断交换元素，找出同一下表出现两次的数字，即为重复数字
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
