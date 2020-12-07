/*
 * @lc app=leetcode.cn id=509 lang=java
 *
 * [509] 斐波那契数
 */

// @lc code=start
class Solution {
    public int fib(int N) {
        if (1 == N) {
            return 1;
        } else if (0 == N) {
            return 0;
        }
        return fib(N - 1) + fib(N - 2);
    }
}
// @lc code=end
