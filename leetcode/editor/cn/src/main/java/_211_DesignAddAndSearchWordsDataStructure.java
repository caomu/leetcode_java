//请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。 
//
// 实现词典类 WordDictionary ： 
//
// 
// WordDictionary() 初始化词典对象 
// void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配 
// bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回 false 。word 中可能包含一些 '
//.' ，每个 . 都可以表示任何一个字母。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["WordDictionary","addWord","addWord","addWord","search","search","search","se
//arch"]
//[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
//输出：
//[null,null,null,null,false,true,true,true]
//
//解释：
//WordDictionary wordDictionary = new WordDictionary();
//wordDictionary.addWord("bad");
//wordDictionary.addWord("dad");
//wordDictionary.addWord("mad");
//wordDictionary.search("pad"); // return False
//wordDictionary.search("bad"); // return True
//wordDictionary.search(".ad"); // return True
//wordDictionary.search("b.."); // return True
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 500 
// addWord 中的 word 由小写英文字母组成 
// search 中的 word 由 '.' 或小写英文字母组成 
// 最多调用 50000 次 addWord 和 search 
// 
// Related Topics 深度优先搜索 设计 字典树 回溯算法 
// 👍 208 👎 0


import java.util.LinkedList;
import java.util.Queue;

public class _211_DesignAddAndSearchWordsDataStructure {
    public static void main(String[] args) {
        WordDictionary wordDictionary = new _211_DesignAddAndSearchWordsDataStructure().new WordDictionary();
        wordDictionary.addWord("at");
        wordDictionary.addWord("and");
        wordDictionary.addWord("an");
        wordDictionary.addWord("add");
        System.out.println(wordDictionary.search("a"));
        System.out.println(wordDictionary.search(".at"));
        wordDictionary.addWord("bat");
        System.out.println(wordDictionary.search(".at"));
        System.out.println(wordDictionary.search("an."));
        System.out.println(wordDictionary.search("a.d."));
        System.out.println(wordDictionary.search("b."));
        System.out.println(wordDictionary.search("a.d"));
        System.out.println(wordDictionary.search("."));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class WordDictionary {
        protected WordDictionary[] children;
        protected boolean isWord;

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
            this.children = new WordDictionary[26];
            this.isWord = false;
        }

        /**
         * Inserts a word into the trie.
         */
        public void addWord(String word) {
            WordDictionary curr = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new WordDictionary();
                }
                curr = curr.children[c - 'a'];
            }
            curr.isWord = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            char[] wordCharacter = word.toCharArray();
            Queue<WordDictionary> q = new LinkedList<>(); // 核心数据结构
            if (wordCharacter[0] == '.') {
                for (WordDictionary wd : this.children) {
                    q.offer(wd);
                }
            } else {
                q.offer(this.children[wordCharacter[0] - 'a']); // 将起点加入队列
            }
            int index = 0;
            while (!q.isEmpty()) {
                index++;
                /* 将当前队列中的所有节点向四周扩散 */
                int width = q.size();

                for (int i = 0; i < width; i++) {
                    WordDictionary cur = q.poll();
                    /* 划重点：这里判断是否到达终点 */
                    if (cur == null) {
                        continue;
                    }
                    if (index == wordCharacter.length) {
                        if (cur.isWord) {
                            return true;
                        }
                    } else {
                        /* 将 cur 的相邻节点加入队列 */
                        if (wordCharacter[index] == '.') {
                            for (WordDictionary wd : cur.children) {
                                q.offer(wd);
                            }
                        } else {
                            q.offer(cur.children[wordCharacter[index] - 'a']); // 将起点加入队列
                        }
                    }
                }
            }
            return false;
        }
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
//leetcode submit region end(Prohibit modification and deletion)

}