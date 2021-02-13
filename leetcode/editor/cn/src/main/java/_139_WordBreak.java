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


import java.util.*;

public class _139_WordBreak {
    public static void main(String[] args) {
        Solution solution = new _139_WordBreak().new Solution();
        System.out.println(solution.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            Map<String, List<Integer>> wordIndex = new HashMap<>();
            wordDict.forEach(word -> {
                List<Integer> indexList = new ArrayList();
                int idx = 0;
                while (idx > -1) {
                    idx = s.indexOf(word, idx);
                    if (idx > -1) {
                        indexList.add(idx);
                        idx++;
                    }
                }
                if (!indexList.isEmpty()) {
                    wordIndex.put(word, indexList);
                }
            });
            return this.wordBreak(s, 0, wordIndex);
        }

        private boolean wordBreak(String s, int idx, Map<String, List<Integer>> wordIndex) {
            if (idx == s.length()) {
                return true;
            }
            for (Map.Entry<String, List<Integer>> entry : wordIndex.entrySet()) {
                for (int sIndex : entry.getValue()) {
                    if (sIndex == idx && this.wordBreak(s, idx + entry.getKey().length(), wordIndex)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}