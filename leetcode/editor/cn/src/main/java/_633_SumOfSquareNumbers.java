//给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
//
//
//
// 示例 1：
//
// 输入：c = 5
//输出：true
//解释：1 * 1 + 2 * 2 = 5
//
//
// 示例 2：
//
// 输入：c = 3
//输出：false
//
//
// 示例 3：
//
// 输入：c = 4
//输出：true
//
//
// 示例 4：
//
// 输入：c = 2
//输出：true
//
//
// 示例 5：
//
// 输入：c = 1
//输出：true
//
//
//
// 提示：
//
//
// 0 <= c <= 231 - 1
//
// Related Topics 数学
// 👍 180 👎 0


import java.sql.Timestamp;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * create time: 2021-04-28 08:21:16
 */
public class _633_SumOfSquareNumbers {

    private static final Logger logger = Logger.getLogger(_633_SumOfSquareNumbers.class.toString());
    private static final long START_TIMESTAMP = Timestamp.valueOf("2021-04-28 08:21:17").getTime();

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _633_SumOfSquareNumbers().new Solution();

        assert solution.judgeSquareSum(1);
        assert solution.judgeSquareSum(2);
        assert !solution.judgeSquareSum(3);
        assert solution.judgeSquareSum(4);
        assert solution.judgeSquareSum(5);

        logger.log(Level.INFO, "time cost: [{0}] ms", (System.currentTimeMillis() - startTimeMillis));
        logger.log(Level.INFO, "solution cost: [{0}]", Duration.ofSeconds(
                (System.currentTimeMillis() - START_TIMESTAMP) / 1000));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean judgeSquareSum(int c) {
            var array = new Integer[46340];
            for (var i = 0; i < 46340; i++) {
                array[i] = i * i;
            }
            Set<Integer> set = new HashSet(Arrays.asList(array));
            for (int i = (int) Math.sqrt(c >> 1); i < (int) Math.sqrt(c) + 1; i++) {
                if (set.contains(c - i * i)) {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
