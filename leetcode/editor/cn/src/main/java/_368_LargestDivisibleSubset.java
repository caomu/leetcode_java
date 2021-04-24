//给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[
//j]) 都应当满足：
//
// answer[i] % answer[j] == 0 ，或
// answer[j] % answer[i] == 0
//
//
// 如果存在多个有效解子集，返回其中任何一个均可。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：[1,2]
//解释：[1,3] 也会被视为正确答案。
//
//
// 示例 2：
//
//
//输入：nums = [1,2,4,8]
//输出：[1,2,4,8]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 1000
// 1 <= nums[i] <= 2 * 109
// nums 中的所有整数 互不相同
//
// Related Topics 数学 动态规划
// 👍 306 👎 0


import java.sql.Timestamp;
import java.time.Duration;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * create time: 2021-04-23 21:19:57
 */
public class _368_LargestDivisibleSubset {

    private static final Logger logger = Logger.getLogger(_368_LargestDivisibleSubset.class.toString());
    private static final long START_TIMESTAMP = Timestamp.valueOf("2021-04-23 21:19:58").getTime();

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _368_LargestDivisibleSubset().new Solution();

        logger.log(Level.WARNING, solution.largestDivisibleSubset(new int[]{1, 2, 3}).toString());
        logger.log(Level.WARNING, solution.largestDivisibleSubset(new int[]{1, 2, 4, 8}).toString());
        logger.log(Level.WARNING, solution.largestDivisibleSubset(new int[]{4, 8, 10, 240}).toString());

        logger.log(Level.INFO, "time cost: [{0}] ms", (System.currentTimeMillis() - startTimeMillis));
        logger.log(Level.INFO, "solution cost: [{0}]", Duration.ofSeconds(
                (System.currentTimeMillis() - START_TIMESTAMP) / 1000));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int largestDivisibleSubset(int[] nums, int index, Integer[] dp) {
            if (dp[index] == null && index == 0) {
                dp[0] = 1;
            } else if (dp[index] == null) {
                dp[index] = 1;
                for (int i = 0; i < index; i++) {
                    if (nums[index] % nums[i] == 0) {
                        dp[index] = Math.max(dp[index], this.largestDivisibleSubset(nums, i, dp) + 1);
                    }
                }
            }
            return dp[index];
        }

        public List<Integer> largestDivisibleSubset(int[] nums) {
            LinkedList<Integer> largestDivisibleSubset = new LinkedList<>();
            Arrays.sort(nums);
            Integer[] dp = new Integer[nums.length];
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                max = Math.max(max, this.largestDivisibleSubset(nums, i, dp));
            }
            Integer[] maxArray = new Integer[max];
            int index = max;
            for (int i = dp.length - 1; i >= 0; i--) {
                if (dp[i] == index &&
                    (index == max || maxArray[index] % nums[i] == 0)) {
                    largestDivisibleSubset.add(nums[i]);
                    maxArray[index - 1] = nums[i];
                    index--;
                }
            }
            return Arrays.asList(maxArray);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
