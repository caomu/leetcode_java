//给定一个未排序的整数数组，找到最长递增子序列的个数。
//
// 示例 1:
//
//
//输入: [1,3,5,4,7]
//输出: 2
//解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
//
//
// 示例 2:
//
//
//输入: [2,2,2,2,2]
//输出: 5
//解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
//
//
// 注意: 给定的数组长度不超过 2000 并且结果一定是32位有符号整数。
// Related Topics 动态规划
// 👍 280 👎 0


import java.util.Arrays;
import java.util.logging.Logger;

public class _673_NumberOfLongestIncreasingSubsequence {

    private static final Logger logger = Logger.getLogger(_673_NumberOfLongestIncreasingSubsequence.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _673_NumberOfLongestIncreasingSubsequence().new Solution();

        assert solution.findNumberOfLIS(new int[]{1, 3, 5, 4, 7}) == 2;
        assert solution.findNumberOfLIS(new int[]{2, 2, 2, 2, 2}) == 5;

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findNumberOfLIS(int[] nums) {
            if (nums.length <= 1) {
                return nums.length;
            }
            int[] dp = new int[nums.length];
            int[] count = new int[nums.length];

            for (int i = 0; i < nums.length; i++) {
                dp[i] = 1;
                count[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        if (dp[j] >= dp[i]) {
                            dp[i] = dp[j] + 1;
                            count[i] = count[j];
                        } else if (dp[j] + 1 == dp[i]) {
                            count[i] += count[j];
                        }
                    }
                }
            }

            int longest = Arrays.stream(dp).max().getAsInt();
            int ans = 0;
            for (int i = 0; i < nums.length; ++i) {
                if (dp[i] == longest) {
                    ans += count[i];
                }
            }
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
