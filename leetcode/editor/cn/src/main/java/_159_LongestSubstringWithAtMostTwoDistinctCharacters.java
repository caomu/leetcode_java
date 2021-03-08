//给定一个字符串 s ，找出 至多 包含两个不同字符的最长子串 t ，并返回该子串的长度。
//
// 示例 1:
//
// 输入: "eceba"
//输出: 3
//解释: t 是 "ece"，长度为3。
//
//
// 示例 2:
//
// 输入: "ccaabbb"
//输出: 5
//解释: t 是 "aabbb"，长度为5。
//
// Related Topics 哈希表 双指针 字符串 Sliding Window
// 👍 105 👎 0


import java.util.logging.Logger;

/**
 * create time: 2021-03-07 23:30:06
 */
public class _159_LongestSubstringWithAtMostTwoDistinctCharacters {

    private static final Logger logger = Logger.getLogger(_159_LongestSubstringWithAtMostTwoDistinctCharacters.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _159_LongestSubstringWithAtMostTwoDistinctCharacters().new Solution();

        logger.warning(String.valueOf(solution.lengthOfLongestSubstringTwoDistinct(
                "abzAZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZYX")));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstringTwoDistinct(String s) {
            int i = 0;
            int j = 0;
            int max = 1;
            int[] charFrequency = new int[58];
            while (j < s.length() && i < s.length()) {
                charFrequency[s.charAt(j) - 'A']++;
                int charCount = 0;
                for (int p = 0; p < 58; p++) {
                    if (charFrequency[p] > 0) {
                        charCount++;
                    }
                }
                if (charCount > 2) {
                    charFrequency[s.charAt(i) - 'A']--;
                    i++;
                } else {
                    max = Math.max(max, j - i + 1);
                }
                j++;
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
