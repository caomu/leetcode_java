//给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。 
//
// 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：[1, 2, 2, 3, 1]
//输出：2
//解释：
//输入数组的度是2，因为元素1和2的出现频数最大，均为2.
//连续子数组里面拥有相同度的有如下所示:
//[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
//最短连续子数组[2, 2]的长度为2，所以返回2.
// 
//
// 示例 2： 
//
// 
//输入：[1,2,2,3,1,4,2]
//输出：6
// 
//
// 
//
// 提示： 
//
// 
// nums.length 在1到 50,000 区间范围内。 
// nums[i] 是一个在 0 到 49,999 范围内的整数。 
// 
// Related Topics 数组 
// 👍 270 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _697_DegreeOfAnArray {
    public static void main(String[] args) {
        Solution solution = new _697_DegreeOfAnArray().new Solution();
        System.out.println(solution.findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findShortestSubArray(int[] nums) {
            Map<Integer, List<Integer>> numFrequency = new HashMap<>();
            int maxFrequency = 1;
            for (int i = 0; i < nums.length; i++) {
                List<Integer> frequency;
                if (numFrequency.containsKey(nums[i])) {
                    frequency = numFrequency.get(nums[i]);
                    int f = frequency.get(0) + 1;
                    maxFrequency = Math.max(maxFrequency, f);
                    frequency.set(0, f);
                    frequency.set(2, i - frequency.get(1));
                } else {
                    frequency = new ArrayList<>(3);
                    frequency.add(1);
                    frequency.add(i);
                    frequency.add(0);
                    numFrequency.put(nums[i], frequency);
                }
            }
            int minLength = Integer.MAX_VALUE;
            for (List<Integer> frequency : numFrequency.values()) {
                if (frequency.get(0) == maxFrequency) {
                    minLength = Math.min(minLength, frequency.get(2));
                }
            }
            return minLength + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}