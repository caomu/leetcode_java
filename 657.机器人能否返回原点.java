/*
 * @lc app=leetcode.cn id=657 lang=java
 *
 * [657] 机器人能否返回原点
 */

// @lc code=start
class Solution {
    public boolean judgeCircle(String moves) {
        int p[] = new int[] { 0, 0 };
        for (char m : moves.toCharArray()) {
            switch (m) {
                case 'U':
                    p[1] += 1;
                    break;
                case 'D':
                    p[1] -= 1;
                    break;
                case 'L':
                    p[0] -= 1;
                    break;
                case 'R':
                    p[0] += 1;
                    break;
                default:
                    break;
            }
        }
        return p[0] == 0 && p[1] == 0;
    }
}
// @lc code=end
