//给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。 
//
// 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 121
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：x = -121
//输出：false
//解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3： 
//
// 
//输入：x = 10
//输出：false
//解释：从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 示例 4： 
//
// 
//输入：x = -101
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// -231 <= x <= 231 - 1 
// 
//
// 
//
// 进阶：你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学 
// 👍 1391 👎 0


public class _9_PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new _9_PalindromeNumber().new Solution();
        System.out.println(solution.isPalindrome(12261));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }
            int bit = 0;
            int t = x;
            while (t > 0) {
                bit++;
                t /= 10;
            }
            for (int i = 1; i <= (bit >> 1); i++) {
                if ((x % (int) Math.pow(10, i)) / (int) Math.pow(10, (i - 1)) !=
                    (x % (int) Math.pow(10, (bit - i + 1))) / (int) Math.pow(10, (bit - i))) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}