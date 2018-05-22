package cn.offer47;

public class Topic {

    public static void main(String[] args) {
        // 牛客测试
        getMaxValue(new int[][] {{1}});
        String src = "AAAAAAAAAAAA";
        String dst = "AAAAAAAAAAAA";
        hasPath(src.toCharArray(), 3, 4, dst.toCharArray());
    }

    /**
     * 矩阵中的路径
     * 
     * @param matrix
     * @param rows
     * @param cols
     * @param str
     * @return
     */
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || rows == 0 || cols == 0)
            return false;

        char[][] table = new char[rows][cols];
        boolean[][] status = new boolean[rows][cols];
        int row = 0, col = 0;
        for (int i = 0; i < matrix.length; i++) {
            table[row][col++] = matrix[i];
            if (col == cols) {
                col = 0;
                row++;
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (findPathCore(table, status, str, i, j, 0))
                    return true;
            }
        }

        return false;
    }

    /**
     * 递归搜索路径
     * 
     * @param table
     * @param status
     * @param str
     * @param row
     * @param col
     * @param index
     * @return
     */
    public static boolean findPathCore(char[][] table, boolean[][] status, char[] str, int row, int col, int index) {
        if (str[index] == table[row][col]) {
            if (index == str.length - 1)
                return true;
            status[row][col] = true;
        } else
            return false;

        boolean result = false;
        int rows = table.length;
        int cols = table[0].length;
        if (row != 0 && !status[row - 1][col])
            result = findPathCore(table, status, str, row - 1, col, index + 1);
        if (!result && row != rows - 1 && !status[row + 1][col])
            result = findPathCore(table, status, str, row + 1, col, index + 1);
        if (!result && col != 0 && !status[row][col - 1])
            result = findPathCore(table, status, str, row, col - 1, index + 1);
        if (!result && col != cols - 1 && !status[row][col + 1])
            result = findPathCore(table, status, str, row, col + 1, index + 1);
        status[row][col] = false;

        return result;
    }

    /**
     * 给出一个矩阵，找出从左上角到右下角经过路径的和的最大值，规则是每次只能向右或者向下走
     * 一个典型的DP问题，到达每个位置的路径和只由它上边和左边的格子确定，可以用用个一大小为列数的一维维数组记录状态
     * 
     * @param box
     * @return
     */
    public static int getMaxValue(int[][] box) {
        if (box == null || box.length == 0 || box[0].length == 0)
            return 0;

        int[] currValue = new int[box[0].length];
        currValue[0] = box[0][0];
        for (int row = 0; row < box.length; row++) {
            for (int col = 0; col < box[0].length; col++) {
                if (row + col == 0)
                    continue;
                if (col == 0)
                    currValue[col] = box[row][col] + currValue[col];
                else if (row == 0)
                    currValue[col] = box[row][col] + currValue[col - 1];
                else {
                    int left = currValue[col - 1];
                    int up = currValue[col];
                    currValue[col] = box[row][col] + (left > up ? left : up);
                }
            }
        }

        return 0;
    }

}