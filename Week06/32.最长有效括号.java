//给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。 
//
// 示例 1: 
//
// 输入: "(()"
//输出: 2
//解释: 最长有效括号子串为 "()"
// 
//
// 示例 2: 
//
// 输入: ")()())"
//输出: 4
//解释: 最长有效括号子串为 "()()"
// 
// Related Topics 字符串 动态规划 
// 👍 853 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestValidParentheses(String s) {
        int len = s.length();
        if (len < 1) {
            return 0;
        }
        int res = 0;
        int[] dp = new int[len];
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == '(') {
                continue;
            }
            if (s.charAt(i - 1) == '(') {
                dp[i] = i - 2 >= 0 ? dp[i - 2] + 2 : 2;
            } else if (i - dp[i - 1] >= 1 && s.charAt(i - dp[i - 1] - 1) == '(') {
                dp[i] = (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0) + dp[i - 1] + 2;
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
