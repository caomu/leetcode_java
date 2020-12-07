/*
 * @lc app=leetcode.cn id=453 lang=java
 *
 * [453] 最小移动次数使数组元素相等
 */

// @lc code=start
class Solution {
    public int minMoves(int[] nums) {
        int sum = 0;
        boolean same = true;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (same && i > 0) {
                same = nums[i - 1] == nums[i];
            }
        }
        if (same) {
            return 0;
        }
        int l = nums.length;
        int r = 1;
        while (true) {
            if ((sum + r * (l - 1)) % l == 0) {
                return r;
            }
            r++;
        }
    }
}
// @lc code=end
