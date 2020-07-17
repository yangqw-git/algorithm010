/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 *
 * https://leetcode-cn.com/problems/decode-ways/description/
 *
 * algorithms
 * Medium (23.70%)
 * Likes:    440
 * Dislikes: 0
 * Total Accepted:    56.2K
 * Total Submissions: 234.3K
 * Testcase Example:  '"12"'
 *
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * 
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * 
 * 示例 1:
 * 
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 
 * 
 * 示例 2:
 * 
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        if (s.length() < 1) {
            return 0;
        }
        int[] dp = new int[s.length()];
        dp[0] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < s.length(); i++) {
            int temp = i > 1 ? dp[i - 2] : 1;
            if (s.charAt(i) == '0') {
                if ((s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2')) {
                    dp[i] = temp;
                } else {
                    dp[i] = 0;
                    continue;
                }
            } else {
                dp[i] = dp[i - 1];
            }
            if ((s.charAt(i - 1) == '2' && s.charAt(i) < '7' && s.charAt(i) > '0')
                    || (s.charAt(i - 1) == '1' && s.charAt(i) != '0')) {
                dp[i] += temp;
            }
        }
        return dp[s.length() - 1];
    }
}
// @lc code=end

