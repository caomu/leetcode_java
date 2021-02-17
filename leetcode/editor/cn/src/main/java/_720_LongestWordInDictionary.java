//给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返
//回答案中字典序最小的单词。 
//
// 若无答案，则返回空字符串。 
//
// 
//
// 示例 1： 
//
// 输入：
//words = ["w","wo","wor","worl", "world"]
//输出："world"
//解释： 
//单词"world"可由"w", "wo", "wor", 和 "worl"添加一个字母组成。
// 
//
// 示例 2： 
//
// 输入：
//words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
//输出："apple"
//解释：
//"apply"和"apple"都能由词典中的单词组成。但是"apple"的字典序小于"apply"。
// 
//
// 
//
// 提示： 
//
// 
// 所有输入的字符串都只包含小写字母。 
// words数组长度范围为[1,1000]。 
// words[i]的长度范围为[1,30]。 
// 
// Related Topics 字典树 哈希表 
// 👍 124 👎 0


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class _720_LongestWordInDictionary {
    public static void main(String[] args) {
        Solution solution = new _720_LongestWordInDictionary().new Solution();
        System.out.println(solution.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestWord(String[] words) {
            Trie trie = new Trie();
            Queue<String> wordQueue = new PriorityQueue<>((Comparator) (o1, o2) -> {
                String a = (String) o1;
                String b = (String) o2;
                if (a.length() > b.length()) {
                    return -1;
                } else if (a.length() < b.length()) {
                    return 1;
                } else {
                    return a.compareTo(b);
                }
            });
            for (String word : words) {
                wordQueue.offer(word);
                trie.insert(word);
            }
            while (!wordQueue.isEmpty()) {
                String word = wordQueue.poll();
                boolean isAnswer = true;
                for (int i = 1; i <= word.length(); i++) {
                    if (!trie.search(word.substring(0, i))) {
                        isAnswer = false;
                        break;
                    }
                }
                if (isAnswer) {
                    return word;
                }
            }
            return "";
        }

        class Trie {
            Trie[] children;
            boolean isWord;

            /**
             * Initialize your data structure here.
             */
            public Trie() {
                this.children = new Trie[26];
                this.isWord = false;
            }

            /**
             * Inserts a word into the trie.
             */
            public void insert(String word) {
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

            /**
             * Returns if the word is in the trie.
             */
            public boolean search(String word) {
                Trie leaf = this.findLeafTrie(word);
                return leaf != null && leaf.isWord;
            }

            /**
             * Returns if there is any word in the trie that starts with the given prefix.
             */
            public boolean startsWith(String prefix) {
                return this.findLeafTrie(prefix) != null;
            }

            private Trie findLeafTrie(String word) {
                Trie curr = this;
                for (int i = 0; i < word.length(); i++) {
                    curr = curr.children[word.charAt(i) - 'a'];
                    if (curr == null) {
                        return null;
                    }
                }
                return curr;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}