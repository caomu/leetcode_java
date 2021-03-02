//给定一个整数数组 nums，求出数组从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点。
//
//
//
// 实现 NumArray 类：
//
//
// NumArray(int[] nums) 使用数组 nums 初始化对象
// int sumRange(int i, int j) 返回数组 nums 从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点（也就是 s
//um(nums[i], nums[i + 1], ... , nums[j])）
//
//
//
//
// 示例：
//
//
//输入：
//["NumArray", "sumRange", "sumRange", "sumRange"]
//[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
//输出：
//[null, 1, -1, -3]
//
//解释：
//NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
//numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
//numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
//numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
//
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 104
// -105 <= nums[i] <= 105
// 0 <= i <= j < nums.length
// 最多调用 104 次 sumRange 方法
//
//
//
// Related Topics 动态规划
// 👍 249 👎 0


import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class _303_RangeSumQueryImmutable {

    private static final Logger logger = Logger.getLogger(_303_RangeSumQueryImmutable.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        NumArray numArray = new _303_RangeSumQueryImmutable().new NumArray(null);

        // assert solution == ;
        logger.warning(String.valueOf(numArray));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class NumArray {
        private Map<Integer, Integer> sumHashMap;

        public NumArray(int[] nums) {
            this.sumHashMap = new HashMap<>();
            this.sumHashMap.put(-1, 0);
            for (int i = 0; i < nums.length; i++) {
                this.sumHashMap.put(i, nums[i] + this.sumHashMap.get(i - 1));
            }
        }

        public int sumRange(int i, int j) {
            return this.sumHashMap.get(j) - this.sumHashMap.get(i - 1);
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
