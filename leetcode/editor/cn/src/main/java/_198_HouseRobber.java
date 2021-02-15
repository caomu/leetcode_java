//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 输入：[1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 输入：[2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
// Related Topics 动态规划 
// 👍 1278 👎 0


import com.caomu.util.Utils;

import java.util.HashMap;
import java.util.Map;

public class _198_HouseRobber {
    public static void main(String[] args) {
        Solution solution = new _198_HouseRobber().new Solution();
        System.out.println(solution.rob(Utils.stringToArray("[4,1,2,7,5,3,1]")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            return this.rob(nums, new HashMap<>(), nums.length - 1);
        }

        private int rob(int[] nums, Map<Integer, Integer> robRecordMap, int endIndex) {
            if (endIndex == 0) {
                return nums[0];
            } else if (endIndex == 1) {
                return Math.max(nums[0], nums[1]);
            }

            if (robRecordMap.containsKey(endIndex)) {
                return robRecordMap.get(endIndex);
            }
            int result = Math.max(this.rob(nums, robRecordMap, endIndex - 2) + nums[endIndex],
                    this.rob(nums, robRecordMap, endIndex - 1));
            robRecordMap.put(endIndex, result);
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}