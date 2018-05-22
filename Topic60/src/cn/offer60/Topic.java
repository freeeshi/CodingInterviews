package cn.offer60;

public class Topic {

    public static void main(String[] args) {
        int n = 1;
        long start = System.currentTimeMillis();
        System.out.println(printProbability1(n));
        System.out.println(System.currentTimeMillis()-start);
        start = System.currentTimeMillis();
        System.out.println(printProbability2(n));
        System.out.println(System.currentTimeMillis()-start);
        System.out.println();
    }

    /**
     * n个骰子的点数的概率，用循环求解
     * 
     * @param count
     * @return
     */
    public static int[] printProbability2(int count) {
        if (count <= 0)
            return null;

        int[] chance = new int[6 * count + 1];
        int point = 0;
        
        int[] touzi = new int[count];
        int currIndex = 0;
        while(currIndex >= 0) {
            if(currIndex == count-1) {
                for (int i = 1; i <= 6; i++)
                    chance[i + point]++;
                currIndex--;
            }else {
                if(touzi[currIndex] < 6) {
                    touzi[currIndex++]++;
                    point++;
                }else {
                    touzi[currIndex--] = 0;
                    point -= 6;
                }
            }
        }
        
        return chance;
    }

    /**
     * n个骰子的点数的概率，用递归求解
     * @param count
     * @return
     */
    public static int[] printProbability1(int count) {
        if (count <= 0)
            return null;

        int[] chance = new int[6 * count + 1];
        probabilityCore(count, 1, 0, chance);
        return chance;
    }

    public static void probabilityCore(int count, int n, int point, int[] chance) {
        if (n == count) {
            for (int i = 1; i <= 6; i++)
                chance[i + point]++;
        } else {
            for (int i = 1; i <= 6; i++)
                probabilityCore(count, n + 1, point + i, chance);
        }

    }

}