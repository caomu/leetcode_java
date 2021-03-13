//给定一组非负整数 nums，重新排列它们每个数字的顺序（每个数字不可拆分）使之组成一个最大的整数。
//
// 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
//
//
//
// 示例 1：
//
//
//输入：nums = [10,2]
//输出："210"
//
// 示例 2：
//
//
//输入：nums = [3,30,34,5,9]
//输出："9534330"
//
//
// 示例 3：
//
//
//输入：nums = [1]
//输出："1"
//
//
// 示例 4：
//
//
//输入：nums = [10]
//输出："10"
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 100
// 0 <= nums[i] <= 109
//
// Related Topics 排序
// 👍 485 👎 0


import java.util.Objects;
import java.util.PriorityQueue;
import java.util.logging.Logger;

/**
 * create time: 2021-03-13 21:06:15
 */
public class _179_LargestNumber {

    private static final Logger logger = Logger.getLogger(_179_LargestNumber.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _179_LargestNumber().new Solution();

        assert Objects.equals(solution.largestNumber(new int[]{3, 30, 34, 5, 9}), "9534330");
//        logger.warning(String.valueOf(solution.largestNumber(new int[]{3, 30, 34, 5, 9})));
        logger.warning(String.valueOf(solution.largestNumber(new int[]{3, 34})));
        logger.warning(String.valueOf(solution.largestNumber(new int[]{3, 30})));
        logger.warning(String.valueOf(solution.largestNumber(new int[]{34323, 3432})));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String largestNumber(int[] nums) {
            PriorityQueue<String> numsString = new PriorityQueue<>((s1, s2) -> CharSequence.compare(s2 + s1, s1 + s2));
            boolean isAllZero = true;
            for (int n : nums) {
                if (n != 0) {
                    isAllZero = false;
                }
                numsString.add(String.valueOf(n));
            }
            if (isAllZero) {
                return "0";
            }
            StringBuilder sb = new StringBuilder();
            while (!numsString.isEmpty()) {
                sb.append(numsString.poll());
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
