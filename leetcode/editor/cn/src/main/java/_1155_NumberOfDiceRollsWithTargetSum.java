//这里有 d 个一样的骰子，每个骰子上都有 f 个面，分别标号为 1, 2, ..., f。 
//
// 我们约定：掷骰子的得到总点数为各骰子面朝上的数字的总和。 
//
// 如果需要掷出的总点数为 target，请你计算出有多少种不同的组合情况（所有的组合情况总共有 f^d 种），模 10^9 + 7 后返回。 
//
// 
//
// 示例 1： 
//
// 输入：d = 1, f = 6, target = 3
//输出：1
// 
//
// 示例 2： 
//
// 输入：d = 2, f = 6, target = 7
//输出：6
// 
//
// 示例 3： 
//
// 输入：d = 2, f = 5, target = 10
//输出：1
// 
//
// 示例 4： 
//
// 输入：d = 1, f = 2, target = 3
//输出：0
// 
//
// 示例 5： 
//
// 输入：d = 30, f = 30, target = 500
//输出：222616187 
//
// 
//
// 提示： 
//
// 
// 1 <= d, f <= 30 
// 1 <= target <= 1000 
// 
// Related Topics 动态规划 
// 👍 73 👎 0


import java.util.HashMap;
import java.util.Map;

public class _1155_NumberOfDiceRollsWithTargetSum {
    public static void main(String[] args) {
        Solution solution = new _1155_NumberOfDiceRollsWithTargetSum().new Solution();
        System.out.println(Math.pow(10, 9) + 7);
        System.out.println(solution.numRollsToTarget(new HashMap<>(), 30, 30, 500));
        System.out.println(solution.numRollsToTarget(30, 30, 500));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numRollsToTarget(int d, int f, int target) {
            return (int) (this.numRollsToTarget(new HashMap<>(), d, f, target) % 1000000007);
        }

        public long numRollsToTarget(Map<Map.Entry<Integer, Integer>, Long> storage, int d, int f, int target) {
            Map.Entry<Integer, Integer> entry = Map.entry(d, target);
            if (storage.containsKey(entry)) {
                return storage.get(entry);
            }
            long sum = 0;
            if (d * f < target || target < d) {
                sum = 0;
            } else if (d == 1 && target <= f) {
                sum = 1;
            } else {
                for (int i = 1; i <= f; i++) {
                    sum += this.numRollsToTarget(storage, d - 1, f, target - i);
                }
            }
            sum %= 1000000007;
            storage.put(entry, sum);
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}