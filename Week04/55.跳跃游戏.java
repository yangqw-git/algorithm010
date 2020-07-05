/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 *
 * https://leetcode-cn.com/problems/jump-game/description/
 *
 * algorithms
 * Medium (40.07%)
 * Likes:    723
 * Dislikes: 0
 * Total Accepted:    125.7K
 * Total Submissions: 311.2K
 * Testcase Example:  '[2,3,1,1,4]'
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 
 * 判断你是否能够到达最后一个位置。
 * 
 * 示例 1:
 * 
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 
 * 
 * 示例 2:
 * 
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 * 
 * 
 */

// @lc code=start
class Solution {

    // 大神解法
    public boolean canJump3(int[] nums) {
        int canReach = nums.length - 1;
        for (int i = canReach; i >= 0; i--) {
            if (nums[i] + i >= canReach) {
                canReach = i;
            }
        }
        return canReach == 0;
    }

    // 优秀解法
    public boolean canJump2(int[] nums) {
        int rightMax = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > rightMax) {
                return false;
            }
            rightMax = Math.max(rightMax, i + nums[i]);
        }
        return true;
    }

    // 我的解法(-_-)
    private int[] memo;
    public boolean canJump(int[] nums) {
        if (nums.length < 1) {
            return true;
        }
        this.memo = new int[nums.length];
        return recursion(nums, 0);
    }
    public boolean recursion (int[] nums,int cur) {
        if (cur >= nums.length - 1) {
            return true;
        }
        if (memo[cur] != 0) {
            return memo[cur] == 1;
        }
        int len = Math.min(nums[cur], nums.length - cur - 1);
        boolean flag = false;
        while (len > 0) {
            boolean res = this.recursion(nums, cur + len);
            if (res) {
                flag = true;
                break;
            }
        }
        memo[cur] = flag ? 1 : -1;
        return flag;
    }
}
// @lc code=end

