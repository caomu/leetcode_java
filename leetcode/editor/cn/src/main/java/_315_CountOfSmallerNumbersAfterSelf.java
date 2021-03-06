//给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是 nums[i] 右侧小于 num
//s[i] 的元素的数量。
//
//
//
// 示例：
//
// 输入：nums = [5,2,6,1]
//输出：[2,1,1,0]
//解释：
//5 的右侧有 2 个更小的元素 (2 和 1)
//2 的右侧仅有 1 个更小的元素 (1)
//6 的右侧有 1 个更小的元素 (1)
//1 的右侧有 0 个更小的元素
//
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 10^5
// -10^4 <= nums[i] <= 10^4
//
// Related Topics 排序 树状数组 线段树 二分查找 分治算法
// 👍 540 👎 0


import java.util.*;
import java.util.logging.Logger;

public class _315_CountOfSmallerNumbersAfterSelf {

    private static final Logger logger = Logger.getLogger(_315_CountOfSmallerNumbersAfterSelf.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _315_CountOfSmallerNumbersAfterSelf().new Solution();

        // assert solution == ;
        logger.warning(String.valueOf(solution.countSmaller(new int[]{5, 2, 6, 1})));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> countSmaller(int[] nums) {
            TreeMap<Integer, Integer> numFrequency = new TreeMap<>();
            Arrays.stream(nums).forEach(n -> numFrequency.put(n, numFrequency.getOrDefault(n, 0) + 1));
            List<Integer> smallerList = new ArrayList<>(nums.length);
            for (int n : nums) {
                int frequency = numFrequency.get(n);
                if (frequency == 1) {
                    numFrequency.remove(n);
                } else {
                    numFrequency.put(n, frequency - 1);
                }
                int smallerCount = 0;
                for (Map.Entry<Integer, Integer> numEntry : numFrequency.entrySet()) {
                    if (numEntry.getKey() < n) {
                        smallerCount += numEntry.getValue();
                    }
                }
                smallerList.add(smallerCount);
            }
            return smallerList;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
