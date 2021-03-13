//你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。
//
// 注意：本题中，每个活字字模只能使用一次。
//
//
//
// 示例 1：
//
// 输入："AAB"
//输出：8
//解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
//
//
// 示例 2：
//
// 输入："AAABBC"
//输出：188
//
//
//
//
// 提示：
//
//
// 1 <= tiles.length <= 7
// tiles 由大写英文字母组成
//
// Related Topics 回溯算法
// 👍 105 👎 0


import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.logging.Logger;

/**
 * create time: 2021-03-12 23:03:32
 */
public class _1079_LetterTilePossibilities {

    private static final Logger logger = Logger.getLogger(_1079_LetterTilePossibilities.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _1079_LetterTilePossibilities().new Solution();

        assert solution.numTilePossibilities("AAB") == 8;
        assert solution.numTilePossibilities("AAABBC") == 188;
        assert solution.numTilePossibilities("V") == 1;
        assert solution.numTilePossibilities("CDC") == 8;
//        logger.warning(String.valueOf(solution.numTilePossibilities("AAB")));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numTilePossibilities(String tiles) {
            char[] charArray = tiles.toCharArray();
            Arrays.sort(charArray);
            return this.numTilePossibilities(charArray, new LinkedList<>(), new boolean[charArray.length], 0);
        }

        private int numTilePossibilities(char[] charArray, Deque<Character> path, boolean[] used, int count) {
            if (!path.isEmpty()) {
//                System.out.println("递归命中 => " + path);
                count++;
            }
            for (int i = 0; i < charArray.length; i++) {
                if (used[i] || (i > 0 && charArray[i] == charArray[i - 1] && !used[i - 1])) {
                    continue;
                }
                path.addLast(charArray[i]);
                used[i] = true;
//                System.out.println("递归之前 => " + path);
                count = this.numTilePossibilities(charArray, path, used, count);
                used[i] = false;
                path.removeLast();
//                System.out.println("递归之后 => " + path);
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
