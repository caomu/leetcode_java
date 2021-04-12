//已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变
//化后可能得到：
//
// 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
// 若旋转 4 次，则可以得到 [0,1,2,4,5,6,7]
//
//
// 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2],
//..., a[n-2]] 。
//
// 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
//
//
//
// 示例 1：
//
//
//输入：nums = [3,4,5,1,2]
//输出：1
//解释：原数组为 [1,2,3,4,5] ，旋转 3 次得到输入数组。
//
//
// 示例 2：
//
//
//输入：nums = [4,5,6,7,0,1,2]
//输出：0
//解释：原数组为 [0,1,2,4,5,6,7] ，旋转 4 次得到输入数组。
//
//
// 示例 3：
//
//
//输入：nums = [11,13,15,17]
//输出：11
//解释：原数组为 [11,13,15,17] ，旋转 4 次得到输入数组。
//
//
//
//
// 提示：
//
//
// n == nums.length
// 1 <= n <= 5000
// -5000 <= nums[i] <= 5000
// nums 中的所有整数 互不相同
// nums 原来是一个升序排序的数组，并进行了 1 至 n 次旋转
//
// Related Topics 数组 二分查找
// 👍 396 👎 0


import java.util.logging.Logger;

/**
 * create time: 2021-04-08 09:35:20
 */
public class _153_FindMinimumInRotatedSortedArray {

    private static final Logger logger = Logger.getLogger(_153_FindMinimumInRotatedSortedArray.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _153_FindMinimumInRotatedSortedArray().new Solution();

        // assert solution == ;
        logger.warning(String.valueOf(solution));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMin(int[] nums) {
//            int left = 1;
//            int right = nums.length - 1;
//            int mid;
//            while (left <= right) {
//                mid = (left + right) >> 1;
//                if (nums[mid] < nums[mid - 1]) {
//                    return mid;
//                } else if (nums[mid] < key) {
//                    left = mid + 1;
//                } else {
//                    return mid;
//                }
//            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
