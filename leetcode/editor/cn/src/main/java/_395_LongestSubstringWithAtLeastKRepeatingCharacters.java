//给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aaabb", k = 3
//输出：3
//解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
// 
//
// 示例 2： 
//
// 
//输入：s = "ababbc", k = 2
//输出：5
//解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由小写英文字母组成 
// 1 <= k <= 105 
// 
// Related Topics 递归 分治算法 Sliding Window 
// 👍 310 👎 0


import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class _395_LongestSubstringWithAtLeastKRepeatingCharacters {

    private static final Logger logger = Logger.getLogger(_395_LongestSubstringWithAtLeastKRepeatingCharacters.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _395_LongestSubstringWithAtLeastKRepeatingCharacters().new Solution();

        // assert solution == ;
        logger.warning(String.valueOf(solution.longestSubstring("aaabbbcdefcdefgggggggggggggggcde", 3)));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestSubstring(String s, int k) {
            return this.longestSubstring(s.toCharArray(), 0, s.length() - 1, k, 0);
        }

        private int longestSubstring(char[] chars, int i, int j, int k, int longest) {
            Map<Character, Integer> charFrequency = new HashMap<>();
            for (int p = i; p <= j; p++) {
                charFrequency.put(chars[p], charFrequency.getOrDefault(chars[p], 0) + 1);
            }
            Set<Character> lessChars = charFrequency.entrySet().stream().filter(entry ->
                    entry.getValue() < k).map(Map.Entry::getKey).collect(Collectors.toSet());
            PriorityQueue<Map.Entry<Integer, Integer>> divide = new PriorityQueue<>((Comparator) (o1, o2) -> {
                Map.Entry<Integer, Integer> entry1 = (Map.Entry<Integer, Integer>) o1;
                Map.Entry<Integer, Integer> entry2 = (Map.Entry<Integer, Integer>) o2;
                return Integer.compare(entry2.getValue() - entry2.getKey(), entry1.getValue() - entry1.getKey());
            });
            if (lessChars.isEmpty()) {
                return j - i + 1;
            } else {
                for (int left = -1, right = i; right <= j; right++) {
                    if (lessChars.contains(chars[right])) {
                        if (right - left >= k) {
                            divide.add(Map.entry(left == 0 ? 0 : left + 1, right - 1));
                        }
                        left = right;
                    }
                    if (right == j && right - left >= k) {
                        divide.add(Map.entry(left + 1, right));
                    }
                }
            }
            while (!divide.isEmpty()) {
                Map.Entry<Integer, Integer> d = divide.poll();
                Map<Character, Integer> dividedCharFrequency = new HashMap<>();
                int length = d.getValue() - d.getKey() + 1;
                if (length <= longest) {
                    break;
                }
                for (int p = d.getKey(); p <= d.getValue(); p++) {
                    dividedCharFrequency.put(chars[p], dividedCharFrequency.getOrDefault(chars[p], 0) + 1);
                }
                if (dividedCharFrequency.values().stream().filter(freq -> freq < k).count() == 0) {
                    return length;
                } else {
                    longest = Math.max(longest, this.longestSubstring(chars, d.getKey(), d.getValue(), k, longest));
                }
            }
            return longest;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
