//给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
//
//
// 注意：字符串长度 和 k 不会超过 104。
//
//
//
// 示例 1：
//
//
//输入：s = "ABAB", k = 2
//输出：4
//解释：用两个'A'替换为两个'B',反之亦然。
//
//
// 示例 2：
//
//
//输入：s = "AABABBA", k = 1
//输出：4
//解释：
//将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
//子串 "BBBB" 有最长重复字母, 答案为 4。
//
// Related Topics 双指针 Sliding Window
// 👍 401 👎 0


import java.util.logging.Logger;

/**
 * create time: 2021-03-07 17:04:55
 */
public class _424_LongestRepeatingCharacterReplacement {

    private static final Logger logger = Logger.getLogger(_424_LongestRepeatingCharacterReplacement.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _424_LongestRepeatingCharacterReplacement().new Solution();

        assert solution.characterReplacement("ABAB", 2) == 4;
        assert solution.characterReplacement("AABABBA", 1) == 4;
        assert solution.characterReplacement("AAAA", 2) == 4;

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int characterReplacement(String s, int k) {
            int i = 0;
            int j = 0;
            int max = Math.min(s.length(), k + 1);
            int[] charFrequency = new int[26];
            while (i < s.length() - k - 1 && j < s.length()) {
                charFrequency[s.charAt(j) - 'A']++;
                int maxFrequency = 0;
                for (int p = 0; p < 26; p++) {
                    maxFrequency = Math.max(maxFrequency, charFrequency[p]);
                }
                if (j - i + 1 > maxFrequency + k) {
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
