//给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
//
// 说明： 
//
// 
// 拆分时可以重复使用字典中的单词。 
// 你可以假设字典中没有重复的单词。 
// 
//
// 示例 1： 
//
// 输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
// 
//
// 示例 2： 
//
// 输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
// Related Topics 动态规划 
// 👍 829 👎 0


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _139_WordBreak {
    public static void main(String[] args) {
        Solution solution = new _139_WordBreak().new Solution();
//        System.out.println(solution.wordBreak("aa", Arrays.asList("a")));
        System.out.println(solution.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")));

//        System.out.println(solution.wordBreak("leetcode", Arrays.asList("leet", "code")));
//        System.out.println(solution.wordBreak("goalspecial", Arrays.asList("go", "goal", "goals", "special")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            if (wordDict.isEmpty()) {
                return false;
            }
            Set<String> wordSet = new HashSet<>(wordDict);
            int maxLength = 0;
            int minLength = Integer.MAX_VALUE;
            for (String word : wordDict) {
                maxLength = Math.max(maxLength, word.length());
                minLength = Math.min(minLength, word.length());
            }
            return this.wordBreak(s, minLength, maxLength, wordSet, new boolean[s.length()], 0);
        }

        private boolean wordBreak(String s, int minLength, int maxLength, Set<String> wordSet, boolean[] checked, int idx) {
            if (idx == s.length()) {
                return true;
            }
            if (idx + minLength > s.length() || checked[idx]) {
                return false;
            }
            for (int i = minLength; i <= Math.min(maxLength, s.length() - idx); i++) {
                if (wordSet.contains(s.substring(idx, idx + i))) {
                    if (this.wordBreak(s, minLength, maxLength, wordSet, checked, idx + i)) {
                        return true;
                    }
                }
            }
            checked[idx] = true;
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
