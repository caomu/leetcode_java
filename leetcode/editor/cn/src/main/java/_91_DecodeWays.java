//一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
//
//
//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
//
//
// 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
//
//
// "AAJF" ，将消息分组为 (1 1 10 6)
// "KJF" ，将消息分组为 (11 10 6)
//
//
// 注意，消息不能分组为 (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
//
// 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
//
// 题目数据保证答案肯定是一个 32 位 的整数。
//
//
//
// 示例 1：
//
//
//输入：s = "12"
//输出：2
//解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
//
//
// 示例 2：
//
//
//输入：s = "226"
//输出：3
//解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
//
//
// 示例 3：
//
//
//输入：s = "0"
//输出：0
//解释：没有字符映射到以 0 开头的数字。
//含有 0 的有效映射是 'J' -> "10" 和 'T'-> "20" 。
//由于没有字符，因此没有有效的方法对此进行解码，因为所有数字都需要映射。
//
//
// 示例 4：
//
//
//输入：s = "06"
//输出：0
//解释："06" 不能映射到 "F" ，因为字符串含有前导 0（"6" 和 "06" 在映射中并不等价）。
//
//
//
// 提示：
//
//
// 1 <= s.length <= 100
// s 只包含数字，并且可能包含前导零。
//
// Related Topics 字符串 动态规划
// 👍 686 👎 0


import java.sql.Timestamp;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * create time: 2021-04-21 09:16:43
 */
public class _91_DecodeWays {

    private static final Logger logger = Logger.getLogger(_91_DecodeWays.class.toString());
    private static final long START_TIMESTAMP = Timestamp.valueOf("2021-04-21 09:16:43").getTime();

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _91_DecodeWays().new Solution();

        assert solution.numDecodings("12") == 2;
        assert solution.numDecodings("226") == 3;
        assert solution.numDecodings("0") == 0;
        assert solution.numDecodings("06") == 0;
        assert solution.numDecodings("27") == 1;

        logger.log(Level.INFO, "time cost: [{0}] ms", (System.currentTimeMillis() - startTimeMillis));
        logger.log(Level.INFO, "solution cost: [{0}]", Duration.ofSeconds(
                (System.currentTimeMillis() - START_TIMESTAMP) / 1000));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDecodings(String s) {
            return this.numDecodings(s.toCharArray(), 0, new Integer[s.length()]);
        }

        private int numDecodings(char[] chars, int index, Integer[] dp) {
            if (index == chars.length - 1) {
                return chars[index] == '0' ? 0 : 1;
            } else if (index == chars.length) {
                return 1;
            } else if (dp[index] == null && chars[index] == '0') {
                dp[index] = 0;
            } else if (dp[index] == null && (chars[index] == '1' || (chars[index] == '2' && index < chars.length - 1 &&
                                                                     chars[index + 1] <= '6'))) {
                dp[index] = this.numDecodings(chars, index + 1, dp) + this.numDecodings(chars, index + 2, dp);
            } else if (dp[index] == null) {
                dp[index] = this.numDecodings(chars, index + 1, dp);
            }
            return dp[index];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
