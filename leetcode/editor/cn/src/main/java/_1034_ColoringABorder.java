//给出一个二维整数网格 grid，网格中的每个值表示该位置处的网格块的颜色。
//
// 只有当两个网格块的颜色相同，而且在四个方向中任意一个方向上相邻时，它们属于同一连通分量。
//
// 连通分量的边界是指连通分量中的所有与不在分量中的正方形相邻（四个方向上）的所有正方形，或者在网格的边界上（第一行/列或最后一行/列）的所有正方形。
//
// 给出位于 (r0, c0) 的网格块和颜色 color，使用指定颜色 color 为所给网格块的连通分量的边界进行着色，并返回最终的网格 grid 。
//
//
//
// 示例 1：
//
// 输入：grid = [[1,1],[1,2]], r0 = 0, c0 = 0, color = 3
//输出：[[3, 3], [3, 2]]
//
//
// 示例 2：
//
// 输入：grid = [[1,2,2],[2,3,2]], r0 = 0, c0 = 1, color = 3
//输出：[[1, 3, 3], [2, 3, 3]]
//
//
// 示例 3：
//
// 输入：grid = [[1,1,1],[1,1,1],[1,1,1]], r0 = 1, c0 = 1, color = 2
//输出：[[2, 2, 2], [2, 1, 2], [2, 2, 2]]
//
//
//
// 提示：
//
//
// 1 <= grid.length <= 50
// 1 <= grid[0].length <= 50
// 1 <= grid[i][j] <= 1000
// 0 <= r0 < grid.length
// 0 <= c0 < grid[0].length
// 1 <= color <= 1000
//
//
//
// Related Topics 深度优先搜索
// 👍 23 👎 0


import com.caomu.util.Utils;

import java.util.*;
import java.util.logging.Logger;

/**
 * create time: 2021-03-08 22:08:51
 */
public class _1034_ColoringABorder {

    private static final Logger logger = Logger.getLogger(_1034_ColoringABorder.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _1034_ColoringABorder().new Solution();

        // assert solution == ;
//        logger.warning(Arrays.deepToString(solution.colorBorder(Utils.stringTo2DArray("[[1,1],[1,2]]"), 0, 0, 3)));
//        logger.warning(Arrays.deepToString(solution.colorBorder(Utils.stringTo2DArray("[[1,2,2],[2,3,2]]"), 0, 1, 3)));
//        logger.warning(Arrays.deepToString(solution.colorBorder(Utils.stringTo2DArray("[[1,1,1],[1,1,1],[1,1,1]]"), 1, 1, 2)));
        logger.warning(Arrays.deepToString(solution.colorBorder(Utils.stringTo2DArray("[[1,2,1,2,1,2],[2,2,2,2,1,2],[1,2,2,2,1,2]]"), 1, 3, 1)));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
            int curColor = grid[r0][c0];
            Queue<Map.Entry<Integer, Integer>> q = new LinkedList<>();
            Set<Map.Entry<Integer, Integer>> visited = new HashSet<>();
            Set<Map.Entry<Integer, Integer>> board = new HashSet<>();
            Map.Entry<Integer, Integer> start = Map.entry(r0, c0);
            q.offer(start);
            visited.add(start);
            int[][] deltas = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

            while (!q.isEmpty()) {
                Map.Entry<Integer, Integer> cur = q.poll();
                for (int[] delta : deltas) {
                    int nextX = cur.getKey() + delta[0];
                    int nextY = cur.getValue() + delta[1];
                    Map.Entry<Integer, Integer> next = Map.entry(nextX, nextY);
                    if (nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length) {
                        board.add(cur);
                        continue;
                    }
                    if (grid[nextX][nextY] != curColor) {
                        board.add(cur);
                    }
                    if (grid[nextX][nextY] == curColor && !visited.contains(next)) {
                        visited.add(next);
                        q.offer(next);
                    }
                }
            }
            board.forEach(cur -> grid[cur.getKey()][cur.getValue()] = color);
            return grid;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
