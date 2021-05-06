//一只青蛙想要过河。 假定河流被等分为若干个单元格，并且在每一个单元格内都有可能放有一块石子（也有可能没有）。 青蛙可以跳上石子，但是不可以跳入水中。
//
// 给你石子的位置列表 stones（用单元格序号 升序 表示）， 请判定青蛙能否成功过河（即能否在最后一步跳至最后一块石子上）。
//
// 开始时， 青蛙默认已站在第一块石子上，并可以假定它第一步只能跳跃一个单位（即只能从单元格 1 跳至单元格 2 ）。
//
// 如果青蛙上一步跳跃了 k 个单位，那么它接下来的跳跃距离只能选择为 k - 1、k 或 k + 1 个单位。 另请注意，青蛙只能向前方（终点的方向）跳跃。
//
//
//
//
// 示例 1：
//
//
//输入：stones = [0,1,3,5,6,8,12,17]
//输出：true
//解释：青蛙可以成功过河，按照如下方案跳跃：跳 1 个单位到第 2 块石子, 然后跳 2 个单位到第 3 块石子, 接着 跳 2 个单位到第 4 块石子, 然
//后跳 3 个单位到第 6 块石子, 跳 4 个单位到第 7 块石子, 最后，跳 5 个单位到第 8 个石子（即最后一块石子）。
//
// 示例 2：
//
//
//输入：stones = [0,1,2,3,4,8,9,11]
//输出：false
//解释：这是因为第 5 和第 6 个石子之间的间距太大，没有可选的方案供青蛙跳跃过去。
//
//
//
// 提示：
//
//
// 2 <= stones.length <= 2000
// 0 <= stones[i] <= 231 - 1
// stones[0] == 0
//
// Related Topics 动态规划
// 👍 223 👎 0


import java.sql.Timestamp;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * create time: 2021-04-29 11:56:30
 */
public class _403_FrogJump {

    private static final Logger logger = Logger.getLogger(_403_FrogJump.class.toString());
    private static final long START_TIMESTAMP = Timestamp.valueOf("2021-04-29 11:56:30").getTime();

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _403_FrogJump().new Solution();

        assert solution.canCross(new int[]{0, 1, 3, 5, 6, 8, 12, 17});
        assert !solution.canCross(new int[]{0, 1, 2, 3, 4, 8, 9, 11});
        assert solution.canCross(new int[]{0, 1});
        assert !solution.canCross(new int[]{0, 2147483647});


        logger.log(Level.INFO, "time cost: [{0}] ms", (System.currentTimeMillis() - startTimeMillis));
        logger.log(Level.INFO, "solution cost: [{0}]", Duration.ofSeconds(
                (System.currentTimeMillis() - START_TIMESTAMP) / 1000));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canCross(int[] stones) {
            Set<Integer> stoneSet = Arrays.stream(stones).boxed().collect(Collectors.toSet());
            Map<Map.Entry<Integer, Integer>, Boolean> dp = new HashMap<>();
            for (int i = stones.length - 2; i >= 0; i--) {
                if (this.canCross(stoneSet, Map.entry(stones[i], stones[stones.length - 1] - stones[i]), dp)) {
                    return true;
                }
            }
            return false;
        }

        private boolean canCross(Set<Integer> stones, Map.Entry<Integer, Integer> entry, Map<Map.Entry<Integer, Integer>, Boolean> dp) {
            int index = entry.getKey();
            int nextStep = entry.getValue();
            if (index < 0 || nextStep <= 0) {
                return false;
            } else if (index == 0) {
                return nextStep == 1;
            }
            Boolean result = null;
            if (!dp.containsKey(entry)) {
                result = stones.contains(index) && (this.canCross(stones, Map.entry(index - nextStep, nextStep), dp) ||
                                                    this.canCross(stones,
                                                            Map.entry(index - nextStep + 1, nextStep - 1), dp) ||
                                                    this.canCross(stones,
                                                            Map.entry(index - nextStep - 1, nextStep + 1), dp));
                dp.put(entry, result);
            }
            return result == null ? dp.get(entry) : result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
