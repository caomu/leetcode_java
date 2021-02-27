//给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。 
//
// 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使
//用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l"
//,"v"]], words = ["oath","pea","eat","rain"]
//输出：["eat","oath"]
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], words = ["abcb"]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 12 
// board[i][j] 是一个小写英文字母 
// 1 <= words.length <= 3 * 104 
// 1 <= words[i].length <= 10 
// words[i] 由小写英文字母组成 
// words 中的所有字符串互不相同 
// 
// Related Topics 字典树 回溯算法 
// 👍 336 👎 0


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class _212_WordSearchIi {

    private static final Logger logger = Logger.getLogger(_212_WordSearchIi.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _212_WordSearchIi().new Solution();

        // assert solution == ;
//        logger.warning(String.valueOf(solution.findWords(new char[][]{{'a'}}, new String[]{"a"})));
//        logger.warning(String.valueOf(solution.findWords(new char[][]{{'o', 'a', 'b', 'n'}, {'o', 't', 'a', 'e'},
//                {'a', 'h', 'k', 'r'}, {'a', 'f', 'l', 'v'}}, new String[]{"oa", "oaa"})));
//        logger.warning(String.valueOf(solution.findWords(new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'},
//                        {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}},
//                new String[]{"oath", "pea", "eat", "rain", "oathi", "oathk", "oathf", "oate", "oathii", "oathfi", "oathfii"})));

        logger.warning(String.valueOf(solution.findWords(new char[][]{{'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
                        {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
                        {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
                        {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
                        {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
                        {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
                        {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
                        {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
                        {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
                        {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
                        {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
                        {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'}},
                new String[]{"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"})));


        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        final int[][] deltas = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        public List<String> findWords(char[][] board, String[] words) {
            Trie trie = new Trie();
            for (String word : words) {
                trie.insert(word);
            }
            List<String> foundWords = new ArrayList<>();
            loop:
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (trie.children[board[i][j] - 'a'] != null) {
                        this.findAll(trie, trie.children[board[i][j] - 'a'],
                                board, foundWords, i, j, new boolean[board.length][board[0].length]);
                        boolean isEmpty = true;
                        for (Trie child : trie.children) {
                            if (child != null) {
                                isEmpty = false;
                                break;
                            }
                        }
                        if (isEmpty) {
                            break loop;
                        }
                    }
                }
            }
            return foundWords;
        }

        private void findAll(Trie root, Trie curr, char[][] board, List<String> foundWords, int i, int j, boolean[][] visited) {
            if (curr == null) {
                return;
            }
            if (curr.word != null) {
                foundWords.add(curr.word);
                this.delete(root, curr.word);
                curr.word = null;
            }
            visited[i][j] = true;
            for (int[] delta : this.deltas) {
                int nextI = i + delta[0];
                int nextJ = j + delta[1];
                if (nextI < 0 || nextI == board.length || nextJ < 0 || nextJ == board[0].length ||
                    visited[nextI][nextJ]) {
                    continue;
                }
                this.findAll(root, curr.children[board[nextI][nextJ] - 'a'], board, foundWords, nextI, nextJ, visited);
            }
            visited[i][j] = false;
        }

        private void delete(Trie trie, String word) {
            Trie curr = trie;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (curr.children[c - 'a'].times == 1) {
                    curr.children[c - 'a'] = null;
                    return;
                }
                curr.children[c - 'a'].times--;
                if (i == word.length() - 1) {
                    curr.children[c - 'a'].word = null;
                }
                curr = curr.children[c - 'a'];
            }
        }
    }

    class Trie {
        public Trie[] children;
        public String word;
        public int times;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            this.children = new Trie[26];
            this.times = 0;
        }

        public void insert(String word) {
            Trie curr = this;
            for (char c : word.toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new Trie();
                }
                curr.children[c - 'a'].times++;
                curr = curr.children[c - 'a'];
            }
            curr.word = word;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
