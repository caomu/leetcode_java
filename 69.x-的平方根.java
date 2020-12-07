/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        for (int i = x / 2; i > 0; i--) {
            if ((i * i) > x && (i - 1) * (i - 1) <= x) {
                return i - 1;
            } else if (i * i == x) {
                return i;
            } else if (i * i <= x && (i + 1) * (i + 1) > x) {
                return i;
            }
        }
        if (0 == x) {
            return 0;
        }
        return 1;
    }
}
// @lc code=end
