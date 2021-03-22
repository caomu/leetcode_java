//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。
//
// 进阶：
//
//
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
//
//
//
//
// 示例 1：
//
//
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4]
//
// 示例 2：
//
//
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1]
//
// 示例 3：
//
//
//输入：nums = [], target = 0
//输出：[-1,-1]
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 105
// -109 <= nums[i] <= 109
// nums 是一个非递减数组
// -109 <= target <= 109
//
// Related Topics 数组 二分查找
// 👍 906 👎 0


import java.util.Arrays;
import java.util.logging.Logger;

/**
 * create time: 2021-03-21 17:22:03
 */
public class _34_FindFirstAndLastPositionOfElementInSortedArray {

    private static final Logger logger = Logger.getLogger(_34_FindFirstAndLastPositionOfElementInSortedArray.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _34_FindFirstAndLastPositionOfElementInSortedArray().new Solution();

        // assert solution == ;
//        logger.warning(Arrays.toString(solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        logger.warning(Arrays.toString(solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
//        logger.warning(Arrays.toString(solution.searchRange(new int[]{}, 0)));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            if (nums.length == 0) {
                return new int[]{-1, -1};
            }
            int left = 0;
            int right = nums.length - 1;
            int mid;
            int starting = 0;
            while (left <= right) {
                mid = (left + right) >> 1;
                if (nums[mid] > target || (mid > 0 && nums[mid - 1] == target)) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    starting = mid;
                    break;
                }
            }
            if (left > right) {
                return new int[]{-1, -1};
            }
            left = 0;
            right = nums.length - 1;
            int ending = 0;
            while (left <= right) {
                mid = (left + right) >> 1;
                if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] < target || (mid < nums.length - 1 && nums[mid + 1] == target)) {
                    left = mid + 1;
                } else {
                    ending = mid;
                    break;
                }
            }
            return new int[]{starting, ending};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
