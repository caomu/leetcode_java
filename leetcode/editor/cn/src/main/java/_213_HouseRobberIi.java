//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的
//房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,2]
//输出：3
//解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,1]
//输出：4
//解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 1000 
// 
// Related Topics 动态规划 
// 👍 462 👎 0


import com.caomu.util.Utils;

import java.util.HashMap;
import java.util.Map;

public class _213_HouseRobberIi {
    public static void main(String[] args) {
        Solution solution = new _213_HouseRobberIi().new Solution();
        System.out.println(solution.rob(Utils.stringToArray(
                "[226,174,214,16,218,48,153,131,128,17,157,142,88,43,37,157,43,221,191,68,206,23,225,82,54,118," +
                "111,46,80,49,245,63,25,194,72,80,143,55,209,18,55,122,65,66,177,101,63,201,172,130,103,225,142,46,86," +
                "185,62,138,212,192,125,77,223,188,99,228,90,25,193,211,84,239,119,234,85,83,123,120,131,203,219,10," +
                "82,35,120,180,249,106,37,169,225,54,103,55,166,124]")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            if (nums.length == 1) {
                return nums[0];
            }
            return Math.max(this.rob(nums, new HashMap<>(), 0, nums.length - 2),
                    this.rob(nums, new HashMap<>(), 1, nums.length - 1));
        }

        private int rob(int[] nums, Map<Integer, Integer> robRecordMap, int left, int right) {
            if (left == right) {
                return nums[left];
            } else if (left + 1 == right) {
                return Math.max(nums[left], nums[right]);
            }

            if (robRecordMap.containsKey(right)) {
                return robRecordMap.get(right);
            }
            int result = Math.max(this.rob(nums, robRecordMap, left, right - 2) + nums[right],
                    this.rob(nums, robRecordMap, left, right - 1));
            robRecordMap.put(right, result);
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}