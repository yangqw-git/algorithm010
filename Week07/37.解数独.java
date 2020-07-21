//编写一个程序，通过已填充的空格来解决数独问题。 
//
// 一个数独的解法需遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 空白格用 '.' 表示。 
//
// 
//
// 一个数独。 
//
// 
//
// 答案被标成红色。 
//
// Note: 
//
// 
// 给定的数独序列只包含数字 1-9 和字符 '.' 。 
// 你可以假设给定的数独只有唯一解。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表 回溯算法 
// 👍 477 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int[][] rows;
    private int[][] cols;
    private int[][] boxs;

    public void solveSudoku(char[][] board) {
        rows = new int[9][9];
        cols = new int[9][9];
        boxs = new int[9][9];
        // init
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int num = board[i][j] - '1';
                int boxIndex = (i / 3) * 3 + j / 3;
                rows[i][num] = 1;
                cols[j][num] = 1;
                boxs[boxIndex][num] = 1;
            }
        }
        this.backTrack(board,0, 0);
    }

    public boolean backTrack(char[][] board, int row, int col) {
        if (row > 8) {
            return true;
        }
        if (board[row][col] == '.') {
            for (int i = 1; i < 10; i++) {
                int boxIndex = (row / 3) * 3 + col / 3;
                if (rows[row][i - 1] == 1 || cols[col][i - 1] == 1 || boxs[boxIndex][i - 1] == 1) {
                    continue;
                }
                // 添加当前值
                rows[row][i - 1] = 1;
                cols[col][i - 1] = 1;
                boxs[boxIndex][i - 1] = 1;
                board[row][col] = (char) ('0' + i);
                // next
                int nextRow = col == 8 ? row + 1 : row;
                int nextCol = col == 8 ? 0 : col + 1;
                if (this.backTrack(board, nextRow, nextCol)) {
                    return true;
                }
                // 回退
                rows[row][i - 1] = 0;
                cols[col][i - 1] = 0;
                boxs[boxIndex][i - 1] = 0;
                board[row][col] = '.';
            }
        } else {
            int nextRow = col == 8 ? row + 1 : row;
            int nextCol = col == 8 ? 0 : col + 1;
            return this.backTrack(board, nextRow, nextCol);
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
