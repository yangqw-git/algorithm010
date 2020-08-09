/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长上升子序列
 *
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/description/
 *
 * algorithms
 * Medium (44.89%)
 * Likes:    881
 * Dislikes: 0
 * Total Accepted:    126.6K
 * Total Submissions: 281.3K
 * Testcase Example:  '[10,9,2,5,3,7,101,18]'
 *
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * 
 * 示例:
 * 
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4 
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 
 * 说明:
 * 
 * 
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n^2) 。
 * 
 * 
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 * 
 */

// @lc code=start
class Solution {
    // 动态规划
    public int lengthOfLIS(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int res = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    // 贪心
    public int lengthOfLIS2(int[] nums) {
        int res = 0;
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                temp[res++] = nums[i];
                continue;
            }
            if (nums[i] > temp[res - 1]) {
                temp[res++] = nums[i];
            } else {
                for (int j = i; j >= 0; j--) {
                    if (nums[i] < temp[j] && (j == 0 || (j > 0 && nums[i] > temp[j - 1]))) {
                        temp[j] = nums[i];
                        break;
                    }
                }
            }
        }
        return res;
    }

    // 贪心 + 二分
    public int lengthOfLIS3(int[] nums) {
        int res = 0;
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                temp[res++] = nums[i];
                continue;
            }
            if (nums[i] > temp[res - 1]) {
                temp[res++] = nums[i];
            } else {
                int left = 0,right = res - 1;
                while (left < right) {
                    int mid = (left + right) >> 1;
                    if (temp[mid] < nums[i]) {
                        left = mid+ 1;
                    } else {
                        right = mid;
                    }
                }
                temp[left] = nums[i];
            }
        }
        return res;
    }
}
// @lc code=end

