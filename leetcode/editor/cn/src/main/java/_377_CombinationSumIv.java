//给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
//
// 题目数据保证答案符合 32 位整数范围。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3], target = 4
//输出：7
//解释：
//所有可能的组合为：
//(1, 1, 1, 1)
//(1, 1, 2)
//(1, 2, 1)
//(1, 3)
//(2, 1, 1)
//(2, 2)
//(3, 1)
//请注意，顺序不同的序列被视作不同的组合。
//
//
// 示例 2：
//
//
//输入：nums = [9], target = 3
//输出：0
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 200
// 1 <= nums[i] <= 1000
// nums 中的所有元素 互不相同
// 1 <= target <= 1000
//
//
//
//
// 进阶：如果给定的数组中含有负数会发生什么？问题会产生何种变化？如果允许负数出现，需要向题目中添加哪些限制条件？
// Related Topics 动态规划
// 👍 326 👎 0


import java.sql.Timestamp;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * create time: 2021-04-24 08:49:52
 */
public class _377_CombinationSumIv {

    private static final Logger logger = Logger.getLogger(_377_CombinationSumIv.class.toString());
    private static final long START_TIMESTAMP = Timestamp.valueOf("2021-04-24 08:49:52").getTime();

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _377_CombinationSumIv().new Solution();

        assert solution.combinationSum4(new int[]{1, 2, 3}, 4) == 7;
        assert solution.combinationSum4(new int[]{9}, 3) == 0;
//        logger.log(Level.WARNING, String.valueOf(solution.combinationSum4(new int[]{1, 2, 3}, 4)));

        logger.log(Level.INFO, "time cost: [{0}] ms", (System.currentTimeMillis() - startTimeMillis));
        logger.log(Level.INFO, "solution cost: [{0}]", Duration.ofSeconds(
                (System.currentTimeMillis() - START_TIMESTAMP) / 1000));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int combinationSum4(int[] nums, int target) {
            return this.combinationSum4(nums, target, new Integer[target + 1]);
        }

        private int combinationSum4(int[] nums, int target, Integer[] dp) {
            if (target == 0) {
                return 1;
            } else if (target < 0) {
                return 0;
            } else if (dp[target] == null) {
                dp[target] = 0;
                for (int num : nums) {
                    dp[target] += this.combinationSum4(nums, target - num, dp);
                }
            }
            return dp[target];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
