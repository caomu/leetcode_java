//给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。回旋镖 是由点 (i, j, k) 表示的元组 ，其中
// i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
//
// 返回平面上所有回旋镖的数量。
//
//
// 示例 1：
//
//
//输入：points = [[0,0],[1,0],[2,0]]
//输出：2
//解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
//
//
// 示例 2：
//
//
//输入：points = [[1,1],[2,2],[3,3]]
//输出：2
//
//
// 示例 3：
//
//
//输入：points = [[1,1]]
//输出：0
//
//
//
//
// 提示：
//
//
// n == points.length
// 1 <= n <= 500
// points[i].length == 2
// -104 <= xi, yi <= 104
// 所有点都 互不相同
//
// Related Topics 哈希表 数学
// 👍 130 👎 0


import com.caomu.util.Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * create time: 2021-04-17 10:01:34
 */
public class _447_NumberOfBoomerangs {

    private static final Logger logger = Logger.getLogger(_447_NumberOfBoomerangs.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _447_NumberOfBoomerangs().new Solution();

        assert solution.numberOfBoomerangs(Utils.stringTo2DArray("[[0,0],[1,0],[2,0]]")) == 2;
        assert solution.numberOfBoomerangs(Utils.stringTo2DArray("[[0,0],[1,0],[-1,0],[0,1],[0,-1]]")) == 20;
        assert solution.numberOfBoomerangs(Utils.stringTo2DArray("[[1,1],[2,2],[3,3],[4,4],[5,5],[6,6],[7,7],[8,8]]")) ==
               24;

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberOfBoomerangs(int[][] points) {
            int n = points.length;
            int[][] distances = new int[n][n];
            int result = 0;
            int[] dp = new int[n];
            for (int i = 0; i < n; i++) {
                Map<Integer, Integer> distanceCount = new HashMap<>();
                for (int j = 0; j < n; j++) {
                    if (i > j) {
                        distances[i][j] = distances[j][i];
                    } else if (i < j) {
                        int x = points[i][0] - points[j][0];
                        int y = points[i][1] - points[j][1];
                        distances[i][j] = x * x + y * y;
                    }
                    distanceCount.put(distances[i][j], distanceCount.getOrDefault(distances[i][j], -1) + 1);
                }
                for (int count : distanceCount.values()) {
                    result += this.calcP(count, dp);
                }
            }
            return result * 2;
        }

        private int calcP(int i, int[] dp) {
            if (i <= 1) {
                return i;
            } else if (dp[i] == 0) {
                dp[i] = this.calcP(i - 1, dp) + i;
            }
            return dp[i];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
