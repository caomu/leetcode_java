//传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
//
// 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
//
// 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
//
//
//
// 示例 1：
//
// 输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
//输出：15
//解释：
//船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
//第 1 天：1, 2, 3, 4, 5
//第 2 天：6, 7
//第 3 天：8
//第 4 天：9
//第 5 天：10
//
//请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (1
//0) 是不允许的。
//
//
// 示例 2：
//
// 输入：weights = [3,2,2,4,1,4], D = 3
//输出：6
//解释：
//船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
//第 1 天：3, 2
//第 2 天：2, 4
//第 3 天：1, 4
//
//
// 示例 3：
//
// 输入：weights = [1,2,3,1,1], D = 4
//输出：3
//解释：
//第 1 天：1
//第 2 天：2
//第 3 天：3
//第 4 天：1, 1
//
//
//
//
// 提示：
//
//
// 1 <= D <= weights.length <= 50000
// 1 <= weights[i] <= 500
//
// Related Topics 数组 二分查找
// 👍 209 👎 0


import java.sql.Timestamp;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * create time: 2021-04-26 09:24:40
 */
public class _1011_CapacityToShipPackagesWithinDDays {

    private static final Logger logger = Logger.getLogger(_1011_CapacityToShipPackagesWithinDDays.class.toString());
    private static final long START_TIMESTAMP = Timestamp.valueOf("2021-04-26 09:24:40").getTime();

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _1011_CapacityToShipPackagesWithinDDays().new Solution();

        assert solution.shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5) == 15;
        assert solution.shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3) == 6;
        // logger.log(Level.WARNING, solution);

        logger.log(Level.INFO, "time cost: [{0}] ms", (System.currentTimeMillis() - startTimeMillis));
        logger.log(Level.INFO, "solution cost: [{0}]", Duration.ofSeconds(
                (System.currentTimeMillis() - START_TIMESTAMP) / 1000));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shipWithinDays(int[] weights, int D) {
            var max = 0;
            var sum = 0;
            for (int weight : weights) {
                max = Math.max(max, weight);
                sum += weight;
            }
            int left = Math.max(max, sum / D);
            int right = sum;
            var shipWithinDays = 0;
            while (left <= right) {
                shipWithinDays = left + ((right - left) >> 1);
                boolean canShipWithinDays = this.canShipWithinDays(weights, D, shipWithinDays);
                boolean canShipWithinDays1 = this.canShipWithinDays(weights, D, shipWithinDays - 1);
                if (canShipWithinDays && !canShipWithinDays1) {
                    return shipWithinDays;
                } else if (!canShipWithinDays) {
                    left = shipWithinDays + 1;
                } else {
                    right = shipWithinDays - 1;
                }
            }
            return shipWithinDays;
        }

        boolean canShipWithinDays(int[] weights, int D, int shipment) {
            var i = 0;
            var d = 0;
            while (d < D) {
                var dailyShipment = 0;
                while (i < weights.length && dailyShipment + weights[i] <= shipment) {
                    dailyShipment += weights[i];
                    i++;
                }
                d++;
            }
            return i == weights.length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
