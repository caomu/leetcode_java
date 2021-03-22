//给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
//
// 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列
//，而 "AEC" 不是）
//
// 题目数据保证答案符合 32 位带符号整数范围。
//
//
//
// 示例 1：
//
//
//输入：s = "rabbbit", t = "rabbit"
//输出：3
//解释：
//如下图所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
//(上箭头符号 ^ 表示选取的字母)
//rabbbit
//^^^^ ^^
//rabbbit
//^^ ^^^^
//rabbbit
//^^^ ^^^
//
//
// 示例 2：
//
//
//输入：s = "babgbag", t = "bag"
//输出：5
//解释：
//如下图所示, 有 5 种可以从 s 中得到 "bag" 的方案。
//(上箭头符号 ^ 表示选取的字母)
//babgbag
//^^ ^
//babgbag
//^^    ^
//babgbag
//^    ^^
//babgbag
//  ^  ^^
//babgbag
//    ^^^
//
//
//
// 提示：
//
//
// 0 <= s.length, t.length <= 1000
// s 和 t 由英文字母组成
//
// Related Topics 字符串 动态规划
// 👍 325 👎 0


import java.util.Arrays;
import java.util.logging.Logger;

/**
 * create time: 2021-03-17 08:52:33
 */
public class _115_DistinctSubsequences {

    private static final Logger logger = Logger.getLogger(_115_DistinctSubsequences.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _115_DistinctSubsequences().new Solution();

        assert solution.numDistinct("rabbbit", "rabbit") == 3;
        assert solution.numDistinct("babgbag", "bag") == 5;
//        logger.warning(String.valueOf(solution.numDistinct("rabbbit", "rabbit")));
//        logger.warning(String.valueOf(solution.numDistinct("bb", "b")));
//        logger.warning(String.valueOf(solution.numDistinct("babgbag", "bag")));
//        logger.warning(String.valueOf(solution.numDistinct(
//                "adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc", "bcddceeeebecbc")));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDistinct(String s, String t) {
            int[][] num = new int[s.length() + 1][t.length() + 1];
            for (int i = 0; i < s.length(); i++) {
                Arrays.fill(num[i], -1);
            }
            return this.numDistinct(s.toCharArray(), t.toCharArray(), 0, 0, num);
        }

        private int numDistinct(char[] source, char[] target, int m, int n, int[][] dp) {
            if (n == target.length) {
                dp[m][n] = 1;
                return 1;
            } else if (m == source.length) {
                dp[m][n] = 0;
                return 0;
            } else if (dp[m][n] >= 0) {
                return dp[m][n];
            }
            dp[m][n] = 0;
            if (source[m] == target[n]) {
                dp[m][n] += this.numDistinct(source, target, m + 1, n + 1, dp);
            }
            dp[m][n] += this.numDistinct(source, target, m + 1, n, dp);
            return dp[m][n];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
