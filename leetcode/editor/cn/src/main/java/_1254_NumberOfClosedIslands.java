//有一个二维矩阵 grid ，每个位置要么是陆地（记号为 0 ）要么是水域（记号为 1 ）。
//
// 我们从一块陆地出发，每次可以往上下左右 4 个方向相邻区域走，能走到的所有陆地区域，我们将其称为一座「岛屿」。
//
// 如果一座岛屿 完全 由水域包围，即陆地边缘上下左右所有相邻区域都是水域，那么我们将其称为 「封闭岛屿」。
//
// 请返回封闭岛屿的数目。
//
//
//
// 示例 1：
//
//
//
// 输入：grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1
//,0,1],[1,1,1,1,1,1,1,0]]
//输出：2
//解释：
//灰色区域的岛屿是封闭岛屿，因为这座岛屿完全被水域包围（即被 1 区域包围）。
//
// 示例 2：
//
//
//
// 输入：grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
//输出：1
//
//
// 示例 3：
//
// 输入：grid = [[1,1,1,1,1,1,1],
//             [1,0,0,0,0,0,1],
//             [1,0,1,1,1,0,1],
//             [1,0,1,0,1,0,1],
//             [1,0,1,1,1,0,1],
//             [1,0,0,0,0,0,1],
//             [1,1,1,1,1,1,1]]
//输出：2
//
//
//
//
// 提示：
//
//
// 1 <= grid.length, grid[0].length <= 100
// 0 <= grid[i][j] <=1
//
// Related Topics 深度优先搜索
// 👍 70 👎 0


import com.caomu.util.Utils;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.IntStream;

/**
 * create time: 2021-03-08 21:05:17
 */
public class _1254_NumberOfClosedIslands {

    private static final Logger logger = Logger.getLogger(_1254_NumberOfClosedIslands.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _1254_NumberOfClosedIslands().new Solution();

        // assert solution == ;
        logger.warning(String.valueOf(solution.closedIsland(Utils.stringTo2DArray(
                "[[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]"))));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int closedIsland(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            UnionFind uf = new UnionFind(m * n);
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        continue;
                    }
                    if (i > 0 && grid[i - 1][j] == 0) {
                        uf.union(i * n + j, (i - 1) * n + j);
                    }
                    if (j > 0 && grid[i][j - 1] == 0) {
                        uf.union(i * n + j, i * n + (j - 1));
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                if (grid[0][i] == 0) {
                    uf.setOnBoard(i);
                }
                if (grid[m - 1][i] == 0) {
                    uf.setOnBoard((m - 1) * n + i);
                }
            }
            for (int i = 0; i < m; i++) {
                if (grid[i][0] == 0) {
                    uf.setOnBoard(i * n);
                }
                if (grid[i][n - 1] == 0) {
                    uf.setOnBoard(i * n + n - 1);
                }
            }
            Set<Integer> islandRootSet = new HashSet<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        continue;
                    }
                    int root = uf.findRoot(i * n + j);
                    if (!uf.isOnBoard(root)) {
                        islandRootSet.add(root);
                    }
                }
            }
            return islandRootSet.size();
        }

        private class UnionFind {
            private final int[] roots;
            private final boolean[] isOnBoard;

            protected UnionFind(int n) {
                this.roots = IntStream.range(0, n).toArray();
                this.isOnBoard = new boolean[n];
            }

            protected boolean isOnBoard(int n) {
                return this.isOnBoard[n];
            }

            protected void setOnBoard(int n) {
                int root = this.findRoot(n);
                if (this.isOnBoard[root]) {
                    return;
                }
                for (int i = 0; i < this.roots.length; i++) {
                    if (this.findRoot(i) == root) {
                        this.isOnBoard[i] = true;
                    }
                }
            }

            protected void union(int p, int q) {
                this.roots[this.findRoot(p)] = this.findRoot(q);
            }

            protected int findRoot(int i) {
                int root = i;
                while (root != this.roots[root]) {
                    root = this.roots[root];
                }
                int t;
                while (i != this.roots[root]) {
                    t = this.roots[i];
                    this.roots[i] = root;
                    i = t;
                }
                return root;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
