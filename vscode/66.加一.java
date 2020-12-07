/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        if (digits[digits.length - 1] != 9) {
            digits[digits.length - 1] += 1;
            return digits;
        }
        for (int i = digits.length - 2; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] += 1;
                for (int j = i + 1; j < digits.length; j++) {
                    digits[j] = 0;
                }
                return digits;
            }
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        for (int i = 1; i < digits.length + 1; i++) {
            result[i] = 0;
        }
        return result;
    }
}
// @lc code=end
