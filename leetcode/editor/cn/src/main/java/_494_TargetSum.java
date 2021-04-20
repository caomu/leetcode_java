//给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选
//择一个符号添加在前面。
//
// 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
//
//
//
// 示例：
//
// 输入：nums: [1, 1, 1, 1, 1], S: 3
//输出：5
//解释：
//
//-1+1+1+1+1 = 3
//+1-1+1+1+1 = 3
//+1+1-1+1+1 = 3
//+1+1+1-1+1 = 3
//+1+1+1+1-1 = 3
//
//一共有5种方法让最终目标和为3。
//
//
//
//
// 提示：
//
//
// 数组非空，且长度不会超过 20 。
// 初始的数组的和不会超过 1000 。
// 保证返回的最终结果能被 32 位整数存下。
//
// Related Topics 深度优先搜索 动态规划
// 👍 645 👎 0


import java.sql.Timestamp;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * create time: 2021-04-20 13:15:12
 */
public class _494_TargetSum {

    private static final Logger logger = Logger.getLogger(_494_TargetSum.class.toString());
    private static final long START_TIMESTAMP = Timestamp.valueOf("2021-04-20 13:15:12").getTime();

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _494_TargetSum().new Solution();

        assert solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3) == 5;
        assert solution.findTargetSumWays(new int[]{1}, 1) == 1;
        assert solution.findTargetSumWays(new int[]{1, 0}, 1) == 2;
//        assert solution.findTargetSumWays(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}, 1) ==
//               1;
        logger.log(Level.WARNING, String.valueOf(solution.findTargetSumWays(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}, 1)));

        logger.log(Level.INFO, "time cost: [{0}] ms", (System.currentTimeMillis() - startTimeMillis));
        logger.log(Level.INFO, "solution cost: [{0}]", Duration.ofSeconds(
                (System.currentTimeMillis() - START_TIMESTAMP) / 1000));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findTargetSumWays(int[] nums, int target) {
            return this.findTargetSumWays(nums, target, 0, new HashMap<>());
        }

        private int findTargetSumWays(int[] nums, int target, int count, Map<Map.Entry<Integer, Integer>, Integer> dp) {
            if (count == nums.length) {
                return target == 0 ? 1 : 0;
            }
            Map.Entry<Integer, Integer> key = Map.entry(count, target);
            if (!dp.containsKey(key)) {
                dp.put(key, this.findTargetSumWays(nums, target + nums[count], count + 1, dp) +
                            this.findTargetSumWays(nums, target - nums[count], count + 1, dp));
            }
            return dp.get(key);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
