//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。 
//
// 示例 1: 
//
// 
//输入: "abc"
//输出: 3
//解释: 三个回文子串: "a", "b", "c".
// 
//
// 示例 2: 
//
// 
//输入: "aaa"
//输出: 6
//说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
// 
//
// 注意: 
//
// 
// 输入的字符串长度不会超过1000。 
// 
// Related Topics 字符串 动态规划 
// 👍 282 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        int len = s.length();
        int p = 2 * len - 1;
        for (int i = 0; i < p; i++) {
            int left = i / 2;
            int right = left + i % 2;
            while (left > -1 && right < len && s.charAt(left) == s.charAt(right)) {
                res++;
                left--;
                right++;
            }
        }
        return res;
    }
    public int countSubstrings2(String s) {
        int res = 0;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = len - 1; i > -1 ; i--) {
            for (int j = i; j < len; j++) {
                if (i == j) {
                    dp[i][j] = true;
                    res++;
                } else if (s.charAt(i) == s.charAt(j) && (j == i + 1 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    res++;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
