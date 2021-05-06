//未知 整数数组 arr 由 n 个非负整数组成。
//
// 经编码后变为长度为 n - 1 的另一个整数数组 encoded ，其中 encoded[i] = arr[i] XOR arr[i + 1] 。例如，a
//rr = [1,0,2,1] 经编码后得到 encoded = [1,2,3] 。
//
// 给你编码后的数组 encoded 和原数组 arr 的第一个元素 first（arr[0]）。
//
// 请解码返回原数组 arr 。可以证明答案存在并且是唯一的。
//
//
//
// 示例 1：
//
//
//输入：encoded = [1,2,3], first = 1
//输出：[1,0,2,1]
//解释：若 arr = [1,0,2,1] ，那么 first = 1 且 encoded = [1 XOR 0, 0 XOR 2, 2 XOR 1] = [
//1,2,3]
//
//
// 示例 2：
//
//
//输入：encoded = [6,2,7,3], first = 4
//输出：[4,2,0,7,4]
//
//
//
//
// 提示：
//
//
// 2 <= n <= 104
// encoded.length == n - 1
// 0 <= encoded[i] <= 105
// 0 <= first <= 105
//
// Related Topics 位运算
// 👍 23 👎 0


import java.sql.Timestamp;
import java.time.Duration;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * create time: 2021-05-06 08:59:55
 */
public class _1720_DecodeXoredArray {

    private static final Logger logger = Logger.getLogger(_1720_DecodeXoredArray.class.toString());
    private static final long START_TIMESTAMP = Timestamp.valueOf("2021-05-06 08:59:55").getTime();

    public static void main(String[] args) {
        var startTimeMillis = System.currentTimeMillis();
        var solution = new _1720_DecodeXoredArray().new Solution();

        assert Arrays.equals(solution.decode(new int[]{1, 2, 3}, 1), new int[]{1, 0, 2, 1});
        assert Arrays.equals(solution.decode(new int[]{6, 2, 7, 3}, 4), new int[]{4, 2, 0, 7, 4});

        logger.log(Level.INFO, "time cost: [{0}] ms", (System.currentTimeMillis() - startTimeMillis));
        logger.log(Level.INFO, "solution cost: [{0}]", Duration.ofSeconds(
                (System.currentTimeMillis() - START_TIMESTAMP) / 1000));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] decode(int[] encoded, int first) {
            int len = encoded.length;
            var decoded = new int[len + 1];
            decoded[0] = first;
            for (var i = 0; i < len; i++) {
                decoded[i + 1] = decoded[i] ^ encoded[i];
            }
            return decoded;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
