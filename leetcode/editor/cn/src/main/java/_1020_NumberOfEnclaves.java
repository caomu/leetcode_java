//给出一个二维数组 A，每个单元格为 0（代表海）或 1（代表陆地）。
//
// 移动是指在陆地上从一个地方走到另一个地方（朝四个方向之一）或离开网格的边界。
//
// 返回网格中无法在任意次数的移动中离开网格边界的陆地单元格的数量。
//
//
//
// 示例 1：
//
// 输入：[[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
//输出：3
//解释：
//有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
//
// 示例 2：
//
// 输入：[[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
//输出：0
//解释：
//所有 1 都在边界上或可以到达边界。
//
//
//
// 提示：
//
//
// 1 <= A.length <= 500
// 1 <= A[i].length <= 500
// 0 <= A[i][j] <= 1
// 所有行的大小都相同
//
// Related Topics 深度优先搜索
// 👍 43 👎 0


import java.util.logging.Logger;
import java.util.stream.IntStream;

/**
 * create time: 2021-03-07 15:32:21
 */
public class _1020_NumberOfEnclaves {

    private static final Logger logger = Logger.getLogger(_1020_NumberOfEnclaves.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _1020_NumberOfEnclaves().new Solution();

        // assert solution == ;
        logger.warning(String.valueOf(solution));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numEnclaves(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            UnionFind uf = new UnionFind(m * n);
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) {
                        continue;
                    }
                    if (i > 0 && grid[i - 1][j] == 1) {
                        uf.union((i - 1) * n + j, i * n + j);
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        uf.union(i * n + (j - 1), i * n + j);
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                if (grid[0][i] == 1) {
                    uf.setOnBoard(i);
                }
                if (grid[m - 1][i] == 1) {
                    uf.setOnBoard((m - 1) * n + i);
                }
            }
            for (int i = 0; i < m; i++) {
                if (grid[i][0] == 1) {
                    uf.setOnBoard(i * n);
                }
                if (grid[i][n - 1] == 1) {
                    uf.setOnBoard(i * n + n - 1);
                }
            }
            int numEnclaves = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) {
                        continue;
                    }
                    int index = i * n + j;
                    if (!uf.getOnBoard()[index]) {
                        numEnclaves++;
                    }
                }
            }
            return numEnclaves;
        }

        private class UnionFind {
            private final int[] roots;
            private final boolean[] isOngrid;

            protected UnionFind(int n) {
                this.roots = IntStream.range(0, n).toArray();
                this.isOngrid = new boolean[n];
            }

            protected boolean[] getOnBoard() {
                return this.isOngrid;
            }

            protected void setOnBoard(int n) {
                int root = this.findRoot(n);
                if (this.isOngrid[root]) {
                    return;
                }
                for (int i = 0; i < this.roots.length; i++) {
                    if (this.findRoot(i) == root) {
                        this.isOngrid[i] = true;
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
