//给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
//
// 如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true
// ；否则，返回 false 。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3,4,5]
//输出：true
//解释：任何 i < j < k 的三元组都满足题意
//
//
// 示例 2：
//
//
//输入：nums = [5,4,3,2,1]
//输出：false
//解释：不存在满足题意的三元组
//
// 示例 3：
//
//
//输入：nums = [2,1,5,0,4,6]
//输出：true
//解释：三元组 (3, 4, 5) 满足题意，因为 nums[3] == 0 < nums[4] == 4 < nums[5] == 6
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 105
// -231 <= nums[i] <= 231 - 1
//
//
//
//
// 进阶：你能实现时间复杂度为 O(n) ，空间复杂度为 O(1) 的解决方案吗？
// 👍 282 👎 0


import java.util.logging.Logger;

/**
 * create time: 2021-03-14 14:59:39
 */
public class _334_IncreasingTripletSubsequence {

    private static final Logger logger = Logger.getLogger(_334_IncreasingTripletSubsequence.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _334_IncreasingTripletSubsequence().new Solution();

        assert solution.increasingTriplet(new int[]{1, 2, 3, 4, 5}) == true;
        assert solution.increasingTriplet(new int[]{5, 4, 3, 2, 1}) == false;
        assert solution.increasingTriplet(new int[]{2, 1, 5, 0, 4, 6}) == true;
        assert solution.increasingTriplet(new int[]{5, 1, 5, 5, 2, 5, 4}) == true;
        assert solution.increasingTriplet(new int[]{5, 1, 6}) == false;
//        logger.warning(String.valueOf(solution.increasingTriplet(new int[]{2, 1, 5, 0, 4, 6}));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean increasingTriplet(int[] nums) {
            if (nums.length < 3) {
                return false;
            }
            int one = nums[0];
            Integer two = null;
            for (int i = 1; i < nums.length; i++) {
                if (two == null) {
                    if (nums[i] > one) {
                        two = nums[i];
                    } else if (nums[i] < one) {
                        one = nums[i];
                    }
                } else if (nums[i] > two) {
                    return true;
                } else if (nums[i] < two && nums[i] > one) {
                    two = nums[i];
                } else if (nums[i] < one) {
                    one = nums[i];
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
