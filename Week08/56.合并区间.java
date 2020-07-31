/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 *
 * https://leetcode-cn.com/problems/merge-intervals/description/
 *
 * algorithms
 * Medium (42.66%)
 * Likes:    526
 * Dislikes: 0
 * Total Accepted:    123K
 * Total Submissions: 287.8K
 * Testcase Example:  '[[1,3],[2,6],[8,10],[15,18]]'
 *
 * 给出一个区间的集合，请合并所有重叠的区间。
 * 
 * 示例 1:
 * 
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 
 * 
 * 示例 2:
 * 
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 1) {
            return new int[0][];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] m, int[] n) {
                return m[0] - n[0];
            }
        });
        int last = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > intervals[last][1]) {
                intervals[++last] = intervals[i];
            } else {
                intervals[last][1] = Math.max(intervals[last][1], intervals[i][1]);
            }
        }
        return Arrays.copyOf(intervals, last + 1);
    }
}
// @lc code=end

