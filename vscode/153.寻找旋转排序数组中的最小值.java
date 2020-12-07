/*
 * @lc app=leetcode.cn id=153 lang=java
 *
 * [153] 寻找旋转排序数组中的最小值
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        int l = Integer.MIN_VALUE;
        for (int n : nums) {
            if (n > l) {
                l = n;
            } else if (n < l) {
                return n;
            }
        }
        return nums[0];
    }
}
// @lc code=end
