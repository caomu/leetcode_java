//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
//
//
//
// 示例 1：
//
// 输入：m = 2, n = 3, k = 1
//输出：3
//
//
// 示例 2：
//
// 输入：m = 3, n = 1, k = 0
//输出：1
//
//
// 提示：
//
//
// 1 <= n,m <= 100
// 0 <= k <= 20
//
// 👍 231 👎 0


import java.util.*;
import java.util.logging.Logger;

/**
 * create time: 2021-03-08 21:17:58
 */
public class _JZ_Offer_13_JiQiRenDeYunDongFanWeiLcof {

    private static final Logger logger = Logger.getLogger(_JZ_Offer_13_JiQiRenDeYunDongFanWeiLcof.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _JZ_Offer_13_JiQiRenDeYunDongFanWeiLcof().new Solution();

        // assert solution == ;
        logger.warning(String.valueOf(solution.movingCount(1, 2, 1)));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int movingCount(int m, int n, int k) {
            Queue<Map.Entry<Integer, Integer>> q = new LinkedList<>();
            Set<Map.Entry<Integer, Integer>> visited = new HashSet<>();
            Map.Entry<Integer, Integer> start = Map.entry(0, 0);

            q.offer(start);
            visited.add(start);
            int[][] deltas = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            while (!q.isEmpty()) {
                Map.Entry<Integer, Integer> cur = q.poll();
                for (int[] delta : deltas) {
                    int nextX = cur.getKey() + delta[0];
                    int nextY = cur.getValue() + delta[1];
                    if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n ||
                        this.bitSum(nextX) + this.bitSum(nextY) > k) {
                        continue;
                    }
                    Map.Entry<Integer, Integer> next = Map.entry(nextX, nextY);
                    if (!visited.contains(next)) {
                        q.offer(next);
                        visited.add(next);
                    }
                }
            }
            return visited.size();
        }

        private int bitSum(int n) {
            int bitSum = 0;
            while (n > 0) {
                bitSum += n % 10;
                n = n / 10;
            }
            return bitSum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
