/*
 * @lc app=leetcode.cn id=493 lang=java
 *
 * [493] 翻转对
 *
 * https://leetcode-cn.com/problems/reverse-pairs/description/
 *
 * algorithms
 * Hard (25.45%)
 * Likes:    115
 * Dislikes: 0
 * Total Accepted:    5.9K
 * Total Submissions: 21.7K
 * Testcase Example:  '[1,3,2,3,1]'
 *
 * 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
 * 
 * 你需要返回给定数组中的重要翻转对的数量。
 * 
 * 示例 1:
 * 
 * 
 * 输入: [1,3,2,3,1]
 * 输出: 2
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: [2,4,3,5,1]
 * 输出: 3
 * 
 * 
 * 注意:
 * 
 * 
 * 给定数组的长度不会超过50000。
 * 输入数组中的所有数字都在32位整数的表示范围内。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int reversePairs(int[] nums) {
        return this.mergeSort(nums, 0, nums.length - 1);
    }

    public int mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = (left + right) >> 1;
        int res = this.mergeSort(nums, left, mid) + this.mergeSort(nums, mid + 1, right);
        int[] temp = new int[right - left + 1];
        int k = 0, l = mid + 1, j = mid + 1;
        for (int i = left; i <= mid; i++) {
            // 校验翻转对
            while ((j <= right && ((nums[i] + 1) >> 1) > nums[j])) {
                j++;
            }
            // 合并子数组
            while (l <= right && nums[l] <= nums[i]) {
                temp[k++] = nums[l++];
            }
            temp[k++] = nums[i];
            res += j - mid - 1;
        }
        while (l <= right) {
            temp[k++] = nums[l++];
        }
        System.arraycopy(temp, 0, nums, left, temp.length);
        return res;
    }
}
// @lc code=end

