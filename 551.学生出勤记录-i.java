/*
 * @lc app=leetcode.cn id=551 lang=java
 *
 * [551] 学生出勤记录 I
 */

// @lc code=start
class Solution {
    public boolean checkRecord(String s) {
        int c = 0;
        for (int i = 0; i < s.length(); i++) {
            char st = s.charAt(i);
            if (st == 'A') {
                c++;
                if (c > 1) {
                    return false;
                }
            }
            if (i > 1 && st == 'L' && s.charAt(i - 1) == 'L' && s.charAt(i - 2) == 'L') {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
