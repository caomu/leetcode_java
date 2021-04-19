//请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
//
//
// 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2
//, 1, 1, 0, 0]。
//
// 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
// Related Topics 栈 哈希表
// 👍 722 👎 0


import java.sql.Timestamp;
import java.time.Duration;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.logging.Logger;

/**
 * create time: 2021-04-19 18:18:46
 */
public class _739_DailyTemperatures {

    private static final Logger logger = Logger.getLogger(_739_DailyTemperatures.class.toString());
    private static final long startTimestamp = Timestamp.valueOf("2021-04-19 18:18:46").getTime();

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _739_DailyTemperatures().new Solution();

        assert Arrays.equals(solution.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}),
                new int[]{1, 1, 4, 2, 1, 1, 0, 0});

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
        logger.info("solution cost: [" +
                    Duration.ofSeconds((System.currentTimeMillis() - startTimestamp) / 1000).toString() + "]");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] dailyTemperatures(int[] T) {
            Deque<Integer> temperatureIndex = new LinkedList<>();
            int[] daily = new int[T.length];
            for (int i = 0; i < T.length; i++) {
                int t = T[i];
                while (!temperatureIndex.isEmpty() && t > T[temperatureIndex.peekLast()]) {
                    int index = temperatureIndex.pollLast();
                    daily[index] = i - index;
                }
                temperatureIndex.addLast(i);
            }
            while (!temperatureIndex.isEmpty()) {
                daily[temperatureIndex.pollLast()] = 0;
            }
            return daily;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
