//外国友人仿照中国字谜设计了一个英文版猜字谜小游戏，请你来猜猜看吧。 
//
// 字谜的迷面 puzzle 按字符串形式给出，如果一个单词 word 符合下面两个条件，那么它就可以算作谜底： 
//
// 
// 单词 word 中包含谜面 puzzle 的第一个字母。 
// 单词 word 中的每一个字母都可以在谜面 puzzle 中找到。 
// 例如，如果字谜的谜面是 "abcdefg"，那么可以作为谜底的单词有 "faced", "cabbage", 和 "baggage"；而 "beefed"
//（不含字母 "a"）以及 "based"（其中的 "s" 没有出现在谜面中）都不能作为谜底。 
// 
//
// 返回一个答案数组 answer，数组中的每个元素 answer[i] 是在给出的单词列表 words 中可以作为字谜迷面 puzzles[i] 所对应的谜
//底的单词数目。 
//
// 
//
// 示例： 
//
// 
//输入：
//words = ["aaaa","asas","able","ability","actt","actor","access"], 
//puzzles = ["aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"]
//输出：[1,1,3,2,4,0]
//解释：
//1 个单词可以作为 "aboveyz" 的谜底 : "aaaa" 
//1 个单词可以作为 "abrodyz" 的谜底 : "aaaa"
//3 个单词可以作为 "abslute" 的谜底 : "aaaa", "asas", "able"
//2 个单词可以作为 "absoryz" 的谜底 : "aaaa", "asas"
//4 个单词可以作为 "actresz" 的谜底 : "aaaa", "asas", "actt", "access"
//没有单词可以作为 "gaswxyz" 的谜底，因为列表中的单词都不含字母 'g'。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 10^5 
// 4 <= words[i].length <= 50 
// 1 <= puzzles.length <= 10^4 
// puzzles[i].length == 7 
// words[i][j], puzzles[i][j] 都是小写英文字母。 
// 每个 puzzles[i] 所包含的字符都不重复。 
// 
// Related Topics 位运算 哈希表 
// 👍 148 👎 0


import java.util.*;
import java.util.logging.Logger;

public class _1178_NumberOfValidWordsForEachPuzzle {

    private static final Logger logger = Logger.getLogger(_1178_NumberOfValidWordsForEachPuzzle.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _1178_NumberOfValidWordsForEachPuzzle().new Solution();

//        assert Arrays.asList(new Integer[]{1, 1, 3, 2, 4, 0}).equals(solution.findNumOfValidWords(
//                new String[]{"aaaa", "asas", "able", "ability", "actt", "actor", "access"},
//                new String[]{"aboveyz", "abrodyz", "abslute", "absoryz", "actresz", "gaswxyz"}));
//        logger.warning(String.valueOf(solution.findNumOfValidWords(
//                new String[]{"aaaa", "asas", "able", "ability", "actt", "actor", "access"},
//                new String[]{"aboveyz", "abrodyz", "abslute", "absoryz", "actresz", "gaswxyz"})));
//        assert Arrays.asList(new Integer[]{0, 1, 3, 2, 0}).equals(solution.findNumOfValidWords(
//                new String[]{"apple", "pleas", "please"},
//                new String[]{"aelwxyz", "aelpxyz", "aelpsxy", "saelpxy", "xaelpsy"}));
//        logger.warning(String.valueOf(solution.findNumOfValidWords(
//                new String[]{"apple", "pleas", "please"},
//                new String[]{"aelwxyz", "aelpxyz", "aelpsxy", "saelpxy", "xaelpsy"})));
//        assert Arrays.asList(new Integer[]{6}).equals(solution.findNumOfValidWords(
//                new String[]{"kkaz", "kaaz", "aazk", "aaaz", "abcdefghijklmnopqrstuvwxyz", "kkka", "kkkz", "aaaa", "kkkk", "zzzz"},
//                new String[]{"kazxyuv"}));
        logger.warning(String.valueOf(solution.findNumOfValidWords(
                new String[]{"kkaz", "kaaz", "aazk", "aaaz", "abcdefghijklmnopqrstuvwxyz", "kkka", "kkkz", "aaaa", "kkkk", "zzzz"},
                new String[]{"kazxyuv"})));
        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
            Trie trie = new Trie();
            for (String word : words) {
                Set<Character> wordSet = new TreeSet<>();
                for (char c : word.toCharArray()) {
                    wordSet.add(c);
                }
                if (wordSet.size() <= 7) {
                    trie.insert(wordSet);
                }
            }
            List<Integer> numOfValidWords = new ArrayList<>();
            for (String puzzle : puzzles) {
                char[] puzzleArray = puzzle.toCharArray();
                Arrays.sort(puzzleArray);
                numOfValidWords.add(this.findNumOfValidWords(trie, puzzleArray, puzzle.charAt(0), 0));
            }
            return numOfValidWords;
        }

        private int findNumOfValidWords(Trie trie, char[] puzzle, char requiredCharacter, int pos) {
            if (trie == null) {
                return 0;
            }
            if (pos == 7) {
                return trie.times;
            }
            int num =
                    this.findNumOfValidWords(trie.children[puzzle[pos] - 'a'], puzzle, requiredCharacter, pos + 1);
            if (puzzle[pos] != requiredCharacter) {
                num += this.findNumOfValidWords(trie, puzzle, requiredCharacter, pos + 1);
            }
            return num;
        }
    }

    class Trie {
        Trie[] children;
        int times;
        Character c;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            this.children = new Trie[26];
            this.times = 0;
            this.c = ' ';
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(Set<Character> wordCollection) {
            Trie curr = this;
            for (char c : wordCollection) {
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new Trie();
                    curr.children[c - 'a'].c = c;
                }
                curr = curr.children[c - 'a'];
            }
            curr.times++;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
