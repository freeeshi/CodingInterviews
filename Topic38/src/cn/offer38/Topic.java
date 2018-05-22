package cn.offer38;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class Topic {

	public static void main(String[] args) {
		ArrayList<String> list = Permutation1("baaaa");
		System.out.println(list.size());

		System.out.println("queen\tscheme");
		for (int i = 17; i <= 17; i++) {
			System.out.print(i + "\t");
			nQueen(i);
		}

		System.out.println();
	}

	/**
	 * 八皇后问题
	 * 分别用数组保存列和两个对角线的状态，用数字记录，初始化为0，表示当前没有皇后放入
	 * 每放入一个皇后就将对应的三个量+1，移出皇后要记得减一
	 * 
	 * @return
	 */
	public static ArrayList<int[]> nQueen(int QUEEN_COUNT) {
		ArrayList<int[]> list = new ArrayList<>();
		Stack<Queen> stack = new Stack<>();
		int[] cols = new int[QUEEN_COUNT];
		int[] cols45 = new int[QUEEN_COUNT * 2 - 1];
		int[] cols135 = new int[QUEEN_COUNT * 2 - 1];
		int currQueenNum = 0;
		int schemeCount = 0;

		stack.push(new Queen(0, 0));
		cols[0]++;
		cols45[0]++;
		cols135[QUEEN_COUNT - 1]++;
		currQueenNum++;

		while (!stack.isEmpty()) {
			if (currQueenNum == QUEEN_COUNT) {
				// 记录详细方案，GC不过来
//				int[] scheme = new int[QUEEN_COUNT];
//				for (int i = 0; i < QUEEN_COUNT; i++) {
//					Queen tmp = stack.get(i);
//					scheme[i] = tmp.x;
//				}
//				list.add(scheme);
				
				// 不记录详细方案，记录总数
				schemeCount++;
				
				currQueenNum--;
				continue;
			}

			Queen queen = null;
			int start = 0;
			if (stack.size() == currQueenNum) {
				start = 0;
			} else {
				queen = stack.pop();
				start = queen.x + 1;
				cols[queen.x]--;
				cols45[queen.x + currQueenNum]--;
				cols135[queen.x - currQueenNum + QUEEN_COUNT - 1]--;
			}

			for (int i = start; i < QUEEN_COUNT; i++, start++) {
				if (currQueenNum != 0) {
					if (cols[i] != 0)
						continue;
					else if (cols45[i + currQueenNum] != 0)
						continue;
					else if (cols135[i - currQueenNum + QUEEN_COUNT - 1] != 0)
						continue;
				}

				stack.push(new Queen(currQueenNum, i));
				cols[i]++;
				cols45[i + currQueenNum]++;
				cols135[i - currQueenNum + QUEEN_COUNT - 1]++;
				currQueenNum++;
				break;
			}

			if (start == QUEEN_COUNT)
				currQueenNum--;
		}

		System.out.println(schemeCount);
		return list;
	}

	public static ArrayList<String> Permutation2(String str) {
		ArrayList<String> list = new ArrayList<>();
		if (str == null || str.length() <= 0)
			return list;

		return null;
	}

	public static void Permutation2LenM(char[] charArray, int len) {

	}

	/**
	 * 输入一个字符串，其中可以有重复字符，求出这些字符所有的排列组合
	 * 
	 * @param str
	 * @return
	 */
	public static ArrayList<String> Permutation1(String str) {
		ArrayList<String> list = new ArrayList<>();
		if (str == null || str.length() <= 0)
			return list;

		char[] charArray = str.toCharArray();
		Permutation1Core(charArray, 0, list);
		return list;
	}

	/**
	 * 用回溯法，降低时间复杂度
	 * 
	 * @param charArray
	 * @param index
	 * @param list
	 */
	public static void Permutation1Core(char[] charArray, int index, ArrayList<String> list) {
		if (index == charArray.length - 1) {
			list.add(new String(charArray));
			return;
		}

		HashSet<Character> set = new HashSet<>();
		for (int i = index; i < charArray.length; i++) {
			if (index != i && charArray[index] == charArray[i])
				continue;

			if (set.contains(charArray[i]))
				continue;
			set.add(charArray[i]);

			swap(charArray, i, index);
			Permutation1Core(charArray, index + 1, list);
			swap(charArray, i, index);
		}
		set = null;
	}

	public static void swap(char[] charArray, int i, int j) {
		char tmp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = tmp;
	}

}

class Queen {
	int num;
	int x;

	public Queen(int num, int x) {
		this.num = num;
		this.x = x;
	}
}