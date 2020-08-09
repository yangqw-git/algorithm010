/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 *
 * https://leetcode-cn.com/problems/decode-ways/description/
 *
 * algorithms
 * Medium (24.05%)
 * Likes:    463
 * Dislikes: 0
 * Total Accepted:    60.4K
 * Total Submissions: 250K
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
        int len = s.length();
        int[] dp = new int[len];
        // 以0开头，解码总数为0
        if (s.charAt(0) == '0') {
            return 0;
        }
        // basecase
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            char cur = s.charAt(i);
            char pre = s.charAt(i - 1);
            // 如果当前字符是0，则前一个字符只能是1或2，dp[i] = dp[i-2]
            if (cur == '0') {
                if (pre == '1' || pre == '2') {
                    dp[i] = i < 2 ? 1 : dp[i - 2];
                } else {
                    // 当前字符为0，前一个字符不是1和2，退出循环，返回0
                    break;
                }
            } else {
                // 如果当前字符不是0，则当前字符可以独立解析，dp[i] = dp[i-1]
                dp[i] = dp[i - 1];
                // 如果前一个字符是1，或者是21～26，可以和前一个字符一起解析，测试dp[i] = dp[i-2]
                if (pre == '1' || (pre == '2' && cur > '0' && cur < '7')) {
                    dp[i] += i < 2 ? 1 : dp[i - 2];
                }
            }
        }
        return dp[len - 1];
    }
}
// @lc code=end

