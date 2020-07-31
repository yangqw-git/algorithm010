/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N皇后
 *
 * https://leetcode-cn.com/problems/n-queens/description/
 *
 * algorithms
 * Hard (69.90%)
 * Likes:    480
 * Dislikes: 0
 * Total Accepted:    52.4K
 * Total Submissions: 74.4K
 * Testcase Example:  '4'
 *
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 
 * 
 * 
 * 上图为 8 皇后问题的一种解法。
 * 
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * 
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * 
 * 示例:
 * 
 * 输入: 4
 * 输出: [
 * ⁠[".Q..",  // 解法 1
 * ⁠ "...Q",
 * ⁠ "Q...",
 * ⁠ "..Q."],
 * 
 * ⁠["..Q.",  // 解法 2
 * ⁠ "Q...",
 * ⁠ "...Q",
 * ⁠ ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 
 * 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一到七步，可进可退。（引用自
 * 百度百科 - 皇后 ）
 * 
 * 
 */

// @lc code=start
class Solution {
    
    private int mark;
    private int count;
    private List<List<String>> planList;

    public List<List<String>> solveNQueens(int n) {
        this.mark = (1 << n) - 1;
        this.count = 0;
        this.planList = new ArrayList<>();
        int[] plans = new int[n];
        this.solveNQueens(plans, 0, 0, 0, 0);
        return this.planList;
    }

    public void solveNQueens(int[] plans, int i, int cols, int pie, int na) {
        if (cols == this.mark) {
            List<String> plan = new ArrayList<>(i);
            for (int p : plans) {
                char[] cs = new char[i];
                for (int j = 0; j < i; j++) {
                    cs [j] = (p >> j) == 1 ? 'Q' : '.';
                }
                plan.add(String.valueOf(cs));
            }
            this.planList.add(plan);
            return;
        }
        int m = this.mark & (~(cols | pie | na));
        while (m > 0) {
            int cur = m & (-m);
            plans[i] = cur;
            this.solveNQueens(plans, i + 1, cols | cur, (pie | cur) << 1, (na | cur) >> 1);
            m -= cur;
        }
    }
}
// @lc code=end

