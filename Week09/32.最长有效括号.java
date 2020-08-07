/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 *
 * https://leetcode-cn.com/problems/longest-valid-parentheses/description/
 *
 * algorithms
 * Hard (30.69%)
 * Likes:    763
 * Dislikes: 0
 * Total Accepted:    71.6K
 * Total Submissions: 225.8K
 * Testcase Example:  '"(()"'
 *
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * 
 * 示例 1:
 * 
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 
 * 
 * 示例 2:
 * 
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 * 
 * 
 */

// @lc code=start
class Solution {

    // 动态规划
    public int longestValidParentheses(String s) {
        // dp[i]表示以下标i结尾的最长有效括号
        int[] dp = new int[s.length()];
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            // 当前为左括号，以左括号结尾的有效括号为0
            if (s.charAt(i) == '(') {
                continue;
            }
            // 当前以右括号结尾
            if (i - 1 > -1 && s.charAt(i - 1) == '(') {
                // 当前状态为 "()",dp[i] = dp[i-2] + 2
                dp[i] = (i - 2 > -1 ? dp[i - 2] : 0) + 2;
            } else if (i - 1 > -1 && i - dp[i - 1] - 1 > -1 && s.charAt(i - dp[i - 1] - 1) == '(') {
                // 当前状态为"))";
                // 如果s.charAt(i-dp[i-1]-1) != '('的话，dp[i]=0; --> )(...))
                // 否则的话dp[i] = dp[i-dp[i-1]-2] + dp[i-1] + 2; --> ((...))
                dp[i] = (i - dp[i - 1] - 2 > -1 ? dp[i - dp[i - 1] - 2] : 0) + dp[i - 1] + 2;
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    // 栈解法
    public int longestValidParentheses2(String s) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int res = 0;
        // 存储前一个不匹配的下标
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                stack.poll();
                if (stack.isEmpty()){
                    stack.push(i);
                } else {
                    res = Math.max((i - stack.peek()), res);
                }
            }
        }
        return res;
    }
}
// @lc code=end

