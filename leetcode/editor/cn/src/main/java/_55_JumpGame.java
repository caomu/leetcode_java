//给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
// 判断你是否能够到达最后一个下标。
//
//
//
// 示例 1：
//
//
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
//
//
// 示例 2：
//
//
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 3 * 104
// 0 <= nums[i] <= 105
//
// Related Topics 贪心算法 数组
// 👍 1152 👎 0


import java.sql.Timestamp;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * create time: 2021-04-20 11:47:34
 */
public class _55_JumpGame {

    private static final Logger logger = Logger.getLogger(_55_JumpGame.class.toString());
    private static final long START_TIMESTAMP = Timestamp.valueOf("2021-04-20 11:47:34").getTime();

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _55_JumpGame().new Solution();

        assert solution.canJump(new int[]{2, 3, 1, 1, 4});
        assert !solution.canJump(new int[]{3, 2, 1, 0, 4});
        assert solution.canJump(new int[]{0});
        // logger.log(Level.warning, solution);

        logger.log(Level.INFO, "time cost: [{0}] ms", (System.currentTimeMillis() - startTimeMillis));
        logger.log(Level.INFO, "solution cost: [{0}]", Duration.ofSeconds(
                (System.currentTimeMillis() - START_TIMESTAMP) / 1000));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canJump(int[] nums) {
            return this.canJump(nums, nums.length - 1, new Boolean[nums.length]);
        }

        private boolean canJump(int[] nums, int index, Boolean[] dp) {
            if (index == 0) {
                dp[0] = true;
            } else if (dp[index] == null) {
                boolean canJump = false;
                for (int i = index - 1; i >= 0; i--) {
                    if (i + nums[i] >= index) {
                        canJump = this.canJump(nums, i, dp);
                        if (canJump) {
                            break;
                        }
                    }
                }
                dp[index] = canJump;
            }
            return dp[index];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
