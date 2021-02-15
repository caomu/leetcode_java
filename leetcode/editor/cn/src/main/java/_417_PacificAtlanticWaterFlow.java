//给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。 
//
// 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。 
//
// 请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。 
//
// 
//
// 提示： 
//
// 
// 输出坐标的顺序不重要 
// m 和 n 都小于150 
// 
//
// 
//
// 示例： 
//
// 
//
// 
//给定下面的 5x5 矩阵:
//
//  太平洋 ~   ~   ~   ~   ~ 
//       ~  1   2   2   3  (5) *
//       ~  3   2   3  (4) (4) *
//       ~  2   4  (5)  3   1  *
//       ~ (6) (7)  1   4   5  *
//       ~ (5)  1   1   2   4  *
//          *   *   *   *   * 大西洋
//
//返回:
//
//[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (上图中带括号的单元).
// 
//
// 
// Related Topics 深度优先搜索 广度优先搜索 
// 👍 196 👎 0


import com.caomu.util.Utils;

import java.util.*;

public class _417_PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        Solution solution = new _417_PacificAtlanticWaterFlow().new Solution();
        System.out.println(solution.pacificAtlantic(
                Utils.stringTo2DArray("[[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> pacificAtlantic(int[][] matrix) {
            int[][] deltas = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    Queue<Map.Entry<Integer, Integer>> q = new LinkedList<>(); // 核心数据结构
                    Set<Map.Entry<Integer, Integer>> visited = new HashSet<>(); // 避免走回头路
                    Map.Entry<Integer, Integer> startPosition = Map.entry(i, j);
                    q.offer(startPosition); // 将起点加入队列
                    visited.add(startPosition);
                    boolean pacific = false;
                    boolean atlantic = false;
                    loop:
                    while (!q.isEmpty()) {
                        /* 将当前队列中的所有节点向四周扩散 */
                        int width = q.size();
                        for (int k = 0; k < width; k++) {
                            Map.Entry<Integer, Integer> cur = q.poll();
                            Integer curI = cur.getKey();
                            Integer curJ = cur.getValue();
                            if (curI == 0 || cur.getValue() == 0) {
                                pacific = true;
                            }
                            if (curI == matrix.length - 1 || curJ == matrix[0].length - 1) {
                                atlantic = true;
                            }
                            /* 将 cur 的相邻节点加入队列 */
                            for (int[] delta : deltas) {
                                int deltaI = curI + delta[0];
                                int deltaJ = curJ + delta[1];
                                if (deltaI >= 0 && deltaI < matrix.length && deltaJ >= 0 && deltaJ < matrix[0].length
                                    && matrix[deltaI][deltaJ] <= matrix[curI][curJ]) {
                                    Map.Entry<Integer, Integer> nextPosition = Map.entry(deltaI, deltaJ);
                                    if (!visited.contains(nextPosition)) {
                                        q.offer(nextPosition);
                                        visited.add(nextPosition);
                                    }
                                }
                            }
                            if (pacific && atlantic) {
                                break loop;
                            }
                        }
                    }
                    if (pacific && atlantic) {
                        result.add(Arrays.asList(i, j));
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}