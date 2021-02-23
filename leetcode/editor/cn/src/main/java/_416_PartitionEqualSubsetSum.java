//给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 注意: 
//
// 
// 每个数组中的元素不会超过 100 
// 数组的大小不会超过 200 
// 
//
// 示例 1: 
//
// 输入: [1, 5, 11, 5]
//
//输出: true
//
//解释: 数组可以分割成 [1, 5, 5] 和 [11].
// 
//
// 
//
// 示例 2: 
//
// 输入: [1, 2, 3, 5]
//
//输出: false
//
//解释: 数组不能分割成两个元素和相等的子集.
// 
//
// 
// Related Topics 动态规划 
// 👍 679 👎 0


import java.util.Arrays;

public class _416_PartitionEqualSubsetSum {
    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _416_PartitionEqualSubsetSum().new Solution();
//        System.out.println(solution.canPartition(new int[]{1, 5, 11, 5}));
//        System.out.println(solution.canPartition(new int[]{1, 2, 3, 5}));
//        System.out.println(solution.canPartition(new int[]{1, 2, 5}));
        System.out.println(solution.canPartition(new int[]{100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 99, 97}));
        System.out.println("time cost: " + (System.currentTimeMillis() - startTimeMillis) + " ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPartition(int[] nums) {
            int sum = Arrays.stream(nums).sum();
            if (1 == (sum & 1)) {
                return false;
            }
            Arrays.sort(nums);
            sum /= 2;
            return this.canPartition(nums, 0, sum, new Boolean[nums.length + 1][sum + 1]);
        }

        private boolean canPartition(int[] nums, int start, int sum, Boolean[][] dp) {
            if (start == nums.length || sum < 1) {
                return false;
            }
            if (dp[start][sum] != null) {
                return dp[start][sum];
            }
            if (sum == nums[start]) {
                dp[start][sum] = true;
            } else if (sum < nums[start]) {
                dp[start][sum] = false;
            } else {
                dp[start][sum] =
                        this.canPartition(nums, start + 1, sum - nums[start], dp) ||
                        this.canPartition(nums, start + 1, sum, dp);
            }
            return dp[start][sum];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}