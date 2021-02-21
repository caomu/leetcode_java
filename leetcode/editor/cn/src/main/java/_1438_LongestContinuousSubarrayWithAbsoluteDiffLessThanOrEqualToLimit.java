//给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limi
//t 。 
//
// 如果不存在满足条件的子数组，则返回 0 。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [8,2,4,7], limit = 4
//输出：2 
//解释：所有子数组如下：
//[8] 最大绝对差 |8-8| = 0 <= 4.
//[8,2] 最大绝对差 |8-2| = 6 > 4. 
//[8,2,4] 最大绝对差 |8-2| = 6 > 4.
//[8,2,4,7] 最大绝对差 |8-2| = 6 > 4.
//[2] 最大绝对差 |2-2| = 0 <= 4.
//[2,4] 最大绝对差 |2-4| = 2 <= 4.
//[2,4,7] 最大绝对差 |2-7| = 5 > 4.
//[4] 最大绝对差 |4-4| = 0 <= 4.
//[4,7] 最大绝对差 |4-7| = 3 <= 4.
//[7] 最大绝对差 |7-7| = 0 <= 4. 
//因此，满足题意的最长子数组的长度为 2 。
// 
//
// 示例 2： 
//
// 输入：nums = [10,1,2,4,7,2], limit = 5
//输出：4 
//解释：满足题意的最长子数组是 [2,4,7,2]，其最大绝对差 |2-7| = 5 <= 5 。
// 
//
// 示例 3： 
//
// 输入：nums = [4,2,2,2,4,4,2,2], limit = 0
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// 1 <= nums[i] <= 10^9 
// 0 <= limit <= 10^9 
// 
// Related Topics 数组 Sliding Window 
// 👍 128 👎 0


public class _1438_LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
    public static void main(String[] args) {
        Solution solution = new _1438_LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit().new Solution();
        assert solution.longestSubarray(new int[]{10, 1, 2, 4, 7, 2}, 5) == 4;
        assert solution.longestSubarray(new int[]{8, 2, 4, 7}, 4) == 2;
        assert solution.longestSubarray(new int[]{9, 10, 1, 7, 9, 3, 9, 9}, 7) == 5;
        assert solution.longestSubarray(new int[]{1, 5, 6, 7, 8, 10, 6, 5, 6}, 4) == 5;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestSubarray(int[] nums, int limit) {
            int left = 0;
            int right = 0;
            int min = nums[0];
            int minIdx = 0;
            int maxIdx = 0;
            int max = nums[0];
            int longestIndex = 0;
            loop:
            while (left <= right) {
                boolean isMoveRight = false;
                while (max - min <= limit) {
                    if (nums[right] <= min) {
                        min = nums[right];
                        minIdx = right;
                    }
                    if (nums[right] >= max) {
                        max = nums[right];
                        maxIdx = right;
                    }
                    right++;
                    isMoveRight = true;
                    if (max - min <= limit && right == nums.length) {
                        longestIndex = Math.max(longestIndex, right - left);
                        break loop;
                    }
                }
                if (isMoveRight) {
                    right--;
                }
                longestIndex = Math.max(longestIndex, right - left);
                if (left == minIdx) {
                    min = Integer.MAX_VALUE;
                    for (int i = left + 1; i <= right; i++) {
                        if (nums[i] <= min) {
                            min = nums[i];
                            minIdx = i;
                        }
                    }
                }
                if (left == maxIdx) {
                    max = 0;
                    for (int i = left + 1; i <= right; i++) {
                        if (nums[i] >= max) {
                            max = nums[i];
                            maxIdx = i;
                        }
                    }
                }
                left++;
            }

            return longestIndex;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}