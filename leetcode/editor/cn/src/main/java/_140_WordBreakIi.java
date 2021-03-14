//给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的
//句子。
//
// 说明：
//
//
// 分隔时可以重复使用字典中的单词。
// 你可以假设字典中没有重复的单词。
//
//
// 示例 1：
//
// 输入:
//s = "catsanddog"
//wordDict = ["cat", "cats", "and", "sand", "dog"]
//输出:
//[
//  "cats and dog",
//  "cat sand dog"
//]
//
//
// 示例 2：
//
// 输入:
//s = "pineapplepenapple"
//wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
//输出:
//[
//  "pine apple pen apple",
//  "pineapple pen apple",
//  "pine applepen apple"
//]
//解释: 注意你可以重复使用字典中的单词。
//
//
// 示例 3：
//
// 输入:
//s = "catsandog"
//wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出:
//[]
//
// Related Topics 动态规划 回溯算法
// 👍 428 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * create time: 2021-03-14 09:46:42
 */
public class _140_WordBreakIi {

    private static final Logger logger = Logger.getLogger(_140_WordBreakIi.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _140_WordBreakIi().new Solution();

        // assert solution == ;
        logger.warning(String.valueOf(solution.wordBreak("catsanddog",
                Arrays.asList("cat", "cats", "and", "sand", "dog"))));
        logger.warning(String.valueOf(solution.wordBreak("pineapplepenapple",
                Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"))));
        logger.warning(String.valueOf(solution.wordBreak("catsandog",
                Arrays.asList("cats", "dog", "sand", "and", "cat"))));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> wordBreak(String s, List<String> wordDict) {
            Trie trie = new Trie();
            for (String word : wordDict) {
                trie.insert(word);
            }
            List<String> sentences = new ArrayList<>();
            this.wordBreak(s.toCharArray(), trie, 0, trie, new StringBuilder(), sentences);
            return sentences;
        }

        private void wordBreak(char[] chars, Trie trie, int index, Trie currentTrie, StringBuilder sentence, List<String> sentences) {
            if (index == chars.length) {
                return;
            }
            Trie child = currentTrie.getChild(chars[index]);
            if (child == null) {
                return;
            }
            sentence.append(chars[index]);
            if (child.isWord) {
                if (index < chars.length - 1) {
                    this.wordBreak(chars, trie,
                            index + 1, trie, new StringBuilder(sentence).append(' '), sentences);
                } else {
                    sentences.add(sentence.toString());
                }
            }
            this.wordBreak(chars, trie, index + 1, child, sentence, sentences);
        }

        private class Trie {
            protected Trie[] children;
            protected boolean isWord;

            protected Trie() {
                this.children = new Trie[26];
                this.isWord = false;
            }

            protected Trie getChild(char c) {
                return this.children[c - 'a'];
            }

            protected void insert(String word) {
                Trie curr = this;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if (curr.children[c - 'a'] == null) {
                        curr.children[c - 'a'] = new Trie();
                    }
                    curr = curr.children[c - 'a'];
                }
                curr.isWord = true;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
