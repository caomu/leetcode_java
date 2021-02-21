//给定一个整数数组 nums ，你可以对它进行一些操作。 
//
// 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除每个等于 nums[i] - 1 或 nums[i] +
// 1 的元素。 
//
// 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。 
//
// 示例 1: 
//
// 
//输入: nums = [3, 4, 2]
//输出: 6
//解释: 
//删除 4 来获得 4 个点数，因此 3 也被删除。
//之后，删除 2 来获得 2 个点数。总共获得 6 个点数。
// 
//
// 示例 2: 
//
// 
//输入: nums = [2, 2, 3, 3, 3, 4]
//输出: 9
//解释: 
//删除 3 来获得 3 个点数，接着要删除两个 2 和 4 。
//之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
//总共获得 9 个点数。
// 
//
// 注意: 
//
// 
// nums的长度最大为20000。 
// 每个整数nums[i]的大小都在[1, 10000]范围内。 
// 
// Related Topics 动态规划 
// 👍 219 👎 0


import java.util.*;

public class _740_DeleteAndEarn {
    public static void main(String[] args) {
        Solution solution = new _740_DeleteAndEarn().new Solution();
        System.out.println(solution.deleteAndEarn(new int[]{1, 1, 1, 2, 4, 5, 5, 5, 6}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int deleteAndEarn(int[] nums) {
            Map<Integer, Integer> numPoints = new HashMap<>();
            int maxNum = Arrays.stream(nums).max().getAsInt();
            Arrays.stream(nums).forEach(n -> numPoints.put(n, numPoints.getOrDefault(n, 0) + n));
            List<Integer> numList = new ArrayList<>(numPoints.keySet());
            Collections.sort(numList);
            return this.deleteAndEarn(numList, numPoints, maxNum, new int[maxNum]);
        }

        private int deleteAndEarn(List<Integer> numList, Map<Integer, Integer> numPoints, int i, int[] dp) {
            if (dp[i - 1] > 0) {
                return dp[i - 1];
            }
            if (numList.get(0) == i) {
                dp[i - 1] = numPoints.get(numList.get(0));
            } else if (numList.get(0) + 1 == i) {
                dp[i - 1] = Math.max(numPoints.get(numList.get(0)), numPoints.getOrDefault(i, 0));
            } else {
                dp[i - 1] = Math.max(this.deleteAndEarn(numList, numPoints, i - 2, dp) + numPoints.getOrDefault(i, 0),
                        this.deleteAndEarn(numList, numPoints, i - 1, dp));
            }
            return dp[i - 1];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}