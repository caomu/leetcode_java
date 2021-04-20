//给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
//
// 两个相邻元素间的距离为 1 。
//
//
//
// 示例 1：
//
//
//输入：
//[[0,0,0],
// [0,1,0],
// [0,0,0]]
//
//输出：
//[[0,0,0],
// [0,1,0],
// [0,0,0]]
//
//
// 示例 2：
//
//
//输入：
//[[0,0,0],
// [0,1,0],
// [1,1,1]]
//
//输出：
//[[0,0,0],
// [0,1,0],
// [1,2,1]]
//
//
//
//
// 提示：
//
//
// 给定矩阵的元素个数不超过 10000。
// 给定矩阵中至少有一个元素是 0。
// 矩阵中的元素只在四个方向上相邻: 上、下、左、右。
//
// Related Topics 深度优先搜索 广度优先搜索
// 👍 411 👎 0


import com.caomu.util.Utils;

import java.sql.Timestamp;
import java.time.Duration;
import java.util.*;
import java.util.logging.Logger;

/**
 * create time: 2021-04-19 21:42:43
 */
public class _542_Zero1Matrix {

    private static final Logger logger = Logger.getLogger(_542_Zero1Matrix.class.toString());
    private static final long startTimestamp = Timestamp.valueOf("2021-04-19 21:42:43").getTime();

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _542_Zero1Matrix().new Solution();

        assert Arrays.deepEquals(solution.updateMatrix(Utils.stringTo2DArray("[[0,0,0],[0,1,0],[0,0,0]]")),
                Utils.stringTo2DArray("[[0,0,0],[0,1,0],[0,0,0]]"));
        assert Arrays.deepEquals(solution.updateMatrix(Utils.stringTo2DArray("[[0,0,0],[0,1,0],[1,1,1]]")),
                Utils.stringTo2DArray("[[0,0,0],[0,1,0],[1,2,1]]"));
        assert Arrays.deepEquals(solution.updateMatrix(Utils.stringTo2DArray("[[0,1,0],[0,1,0],[0,1,0],[0,1,0],[0,1,0]]")),
                Utils.stringTo2DArray("[[0,1,0],[0,1,0],[0,1,0],[0,1,0],[0,1,0]]"));
        assert Arrays.deepEquals(solution.updateMatrix(Utils.stringTo2DArray("[[1,1,0,0,1,0,0,1,1,0],[1,0,0,1,0,1,1,1,1,1],[1,1,1,0,0,1,1,1,1,0],[0,1,1,1,0,1,1,1,1,1],[0,0,1,1,1,1,1,1,1,0],[1,1,1,1,1,1,0,1,1,1],[0,1,1,1,1,1,1,0,0,1],[1,1,1,1,1,0,0,1,1,1],[0,1,0,1,1,0,1,1,1,1],[1,1,1,0,1,0,1,1,1,1]]")),
                Utils.stringTo2DArray("[[2,1,0,0,1,0,0,1,1,0],[1,0,0,1,0,1,1,2,2,1],[1,1,1,0,0,1,2,2,1,0],[0,1,2,1,0,1,2,3,2,1],[0,0,1,2,1,2,1,2,1,0],[1,1,2,3,2,1,0,1,1,1],[0,1,2,3,2,1,1,0,0,1],[1,2,1,2,1,0,0,1,1,2],[0,1,0,1,1,0,1,2,2,3],[1,2,1,0,1,0,1,2,3,4]]"));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
        logger.info("solution cost: [" +
                    Duration.ofSeconds((System.currentTimeMillis() - startTimestamp) / 1000).toString() + "]");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] updateMatrix(int[][] matrix) {
            int[][] deltas = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            int[][] newMatrix = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (newMatrix[i][j] != 0 || matrix[i][j] == 0) {
                        continue;
                    }
                    Queue<Map.Entry<Integer, Integer>> q = new LinkedList<>();
                    Set<Map.Entry<Integer, Integer>> visited = new HashSet<>();
                    Map.Entry<Integer, Integer> start = Map.entry(i, j);
                    q.offer(start);
                    visited.add(start);
                    int step = 0;
                    loop:
                    while (!q.isEmpty()) {
                        int width = q.size();
                        for (int k = 0; k < width; k++) {
                            Map.Entry<Integer, Integer> cur = q.poll();
                            int x = cur.getKey();
                            int y = cur.getValue();
                            if (matrix[x][y] == 0) {
                                break loop;
                            }
                            for (int[] delta : deltas) {
                                int nextX = x + delta[0];
                                int nextY = y + delta[1];
                                if (nextX < 0 || nextX >= matrix.length || nextY < 0 || nextY >= matrix[0].length) {
                                    continue;
                                }
                                Map.Entry<Integer, Integer> next = Map.entry(nextX, nextY);
                                if (!visited.contains(next)) {
                                    visited.add(next);
                                    q.offer(next);
                                }
                            }
                        }
                        step++;
                    }
                    newMatrix[i][j] = step;
                }
            }
            return newMatrix;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
