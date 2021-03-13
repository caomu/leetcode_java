//给你一个整数数组 nums，请你将该数组升序排列。
//
//
//
//
//
//
// 示例 1：
//
// 输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
//
//
// 示例 2：
//
// 输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 50000
// -50000 <= nums[i] <= 50000
//
// 👍 232 👎 0


import java.util.logging.Logger;

/**
 * create time: 2021-03-13 19:50:46
 */
public class _912_SortAnArray {

    private static final Logger logger = Logger.getLogger(_912_SortAnArray.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _912_SortAnArray().new Solution();

        // assert solution == ;
        logger.warning(String.valueOf(solution));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArray(int[] nums) {
            this.quickSort(nums, 0, nums.length - 1);
            return nums;
        }

        private void quickSort(int[] arr, int start, int end) {
            // 如果区域内的数字少于 2 个，退出递归
            if (start >= end) {
                return;
            }
            // 将 arr 从 start 到 end 分区，左边区域比基数小，右边区域比基数大，然后返回中间值的下标
            // 取第一个数为基数
            int pivot = arr[start];
            // 从第二个数开始分区
            int left = start + 1;
            // 右边界
            int right = end;
            while (left < right) {
                // 找到第一个大于基数的位置
                while (left < right && arr[left] <= pivot) {
                    left++;
                }
                // 找到第一个小于基数的位置
                while (left < right && arr[right] >= pivot) {
                    right--;
                }
                // 交换这两个数，使得左边分区都小于或等于基数，右边分区大于或等于基数
                if (left < right) {
                    this.exchange(arr, left, right);
                    left++;
                    right--;
                }
            }
            // 如果 left 和 right 相等，单独比较 arr[right] 和 pivot
            if (left == right && arr[right] > pivot) {
                right--;
            }
            // 将基数和轴交换
            this.exchange(arr, start, right);

            // 对左边区域快速排序
            this.quickSort(arr, start, right - 1);
            // 对右边区域快速排序
            this.quickSort(arr, right + 1, end);
        }

        private void exchange(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
