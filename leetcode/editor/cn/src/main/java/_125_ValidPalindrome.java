//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//
// 说明：本题中，我们将空字符串定义为有效的回文串。
//
// 示例 1:
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
//
//
// 示例 2:
//
// 输入: "race a car"
//输出: false
//
// Related Topics 双指针 字符串
// 👍 347 👎 0


import java.util.logging.Logger;

/**
 * create time: 2021-03-13 20:08:04
 */
public class _125_ValidPalindrome {

    private static final Logger logger = Logger.getLogger(_125_ValidPalindrome.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _125_ValidPalindrome().new Solution();

        // assert solution == ;
        logger.warning(String.valueOf(solution.isPalindrome("A man, a plan, a canal: Panama")));
        logger.warning(String.valueOf(solution.isPalindrome("race a car")));
        logger.warning(String.valueOf(solution.isPalindrome(".,")));
        logger.warning(String.valueOf(solution.isPalindrome("0P")));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            int left = 0;
            int right = s.length() - 1;
            while (left < right) {
                char leftChar = s.charAt(left);
                while (!Character.isDigit(leftChar) && !Character.isAlphabetic(leftChar)) {
                    left++;
                    if (left >= s.length()) {
                        break;
                    }
                    leftChar = s.charAt(left);
                }
                char rightChar = s.charAt(right);
                while (!Character.isDigit(rightChar) && !Character.isAlphabetic(rightChar)) {
                    right--;
                    if (right < 0) {
                        break;
                    }
                    rightChar = s.charAt(right);
                }
                if (left > right) {
                    break;
                }
                if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
