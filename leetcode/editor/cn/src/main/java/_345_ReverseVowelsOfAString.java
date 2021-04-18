//编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
//
//
//
// 示例 1：
//
// 输入："hello"
//输出："holle"
//
//
// 示例 2：
//
// 输入："leetcode"
//输出："leotcede"
//
//
//
// 提示：
//
//
// 元音字母不包含字母 "y" 。
//
// Related Topics 双指针 字符串
// 👍 149 👎 0


import java.util.logging.Logger;

/**
 * create time: 2021-04-18 08:49:42
 */
public class _345_ReverseVowelsOfAString {

    private static final Logger logger = Logger.getLogger(_345_ReverseVowelsOfAString.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _345_ReverseVowelsOfAString().new Solution();

        assert solution.reverseVowels("hello").equals("holle");

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseVowels(String s) {
            char[] chars = s.toCharArray();
            int left = 0;
            int right = chars.length - 1;
            while (left < right) {
                boolean isVowelsLeft = this.isVowels(chars[left]);
                while (!isVowelsLeft && left < right) {
                    left++;
                    isVowelsLeft = this.isVowels(chars[left]);
                }
                boolean isVowelsRight = this.isVowels(chars[right]);
                while (!this.isVowels(chars[right]) && left < right) {
                    right--;
                    isVowelsRight = this.isVowels(chars[right]);
                }
                if (isVowelsLeft && isVowelsRight) {
                    char tmp = chars[right];
                    chars[right] = chars[left];
                    chars[left] = tmp;
                    right--;
                    left++;
                }
            }
            return new String(chars);
        }

        private boolean isVowels(char c) {
            return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' ||
                   c == 'O' || c == 'U';
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
