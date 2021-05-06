//给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
//
//
//
// 示例 1：
//
//
//输入：nums = [2,2,3,2]
//输出：3
//
//
// 示例 2：
//
//
//输入：nums = [0,1,0,1,0,1,99]
//输出：99
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 3 * 104
// -231 <= nums[i] <= 231 - 1
// nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次
//
//
//
//
// 进阶：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
// Related Topics 位运算
// 👍 577 👎 0


import java.sql.Timestamp;
import java.time.Duration;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * create time: 2021-04-30 07:41:03
 */
public class _137_SingleNumberIi {

    private static final Logger logger = Logger.getLogger(_137_SingleNumberIi.class.toString());
    private static final long START_TIMESTAMP = Timestamp.valueOf("2021-04-30 07:41:03").getTime();

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _137_SingleNumberIi().new Solution();

        assert solution == null;
        // logger.log(Level.WARNING, solution);

        logger.log(Level.INFO, "time cost: [{0}] ms", (System.currentTimeMillis() - startTimeMillis));
        logger.log(Level.INFO, "solution cost: [{0}]", Duration.ofSeconds(
                (System.currentTimeMillis() - START_TIMESTAMP) / 1000));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }
            Arrays.sort(nums);
            if (nums[0] != nums[1]) {
                return nums[0];
            }
            if (nums[nums.length - 1] != nums[nums.length - 2]) {
                return nums[nums.length - 1];
            }
            for (int i = 1; i < nums.length - 1; i++) {
                if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                    return nums[i];
                }
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
