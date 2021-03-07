//给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
//
// 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
//
// 示例:
//
// X X X X
//X O O X
//X X O X
//X O X X
//
//
// 运行你的函数后，矩阵变为：
//
// X X X X
//X X X X
//X X X X
//X O X X
//
//
// 解释:
//
// 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被
//填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
// Related Topics 深度优先搜索 广度优先搜索 并查集
// 👍 481 👎 0


import java.util.logging.Logger;
import java.util.stream.IntStream;

public class _130_SurroundedRegions {

    private static final Logger logger = Logger.getLogger(_130_SurroundedRegions.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _130_SurroundedRegions().new Solution();

        // assert solution == ;
        logger.warning(String.valueOf(solution));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void solve(char[][] board) {
            int m = board.length;
            int n = board[0].length;
            UnionFind uf = new UnionFind(m * n);
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 'X') {
                        continue;
                    }
                    if (i > 0 && board[i - 1][j] == 'O') {
                        uf.union((i - 1) * n + j, i * n + j);
                    }
                    if (j > 0 && board[i][j - 1] == 'O') {
                        uf.union(i * n + (j - 1), i * n + j);
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                if (board[0][i] == 'O') {
                    uf.setOnBoard(i);
                }
                if (board[m - 1][i] == 'O') {
                    uf.setOnBoard((m - 1) * n + i);
                }
            }
            for (int i = 0; i < m; i++) {
                if (board[i][0] == 'O') {
                    uf.setOnBoard(i * n);
                }
                if (board[i][n - 1] == 'O') {
                    uf.setOnBoard(i * n + n - 1);
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 'X') {
                        continue;
                    }
                    if (!uf.getOnBoard()[i * n + j]) {
                        board[i][j] = 'X';
                    }
                }
            }
        }

        private class UnionFind {
            private final int[] roots;
            private final boolean[] isOnBoard;

            protected UnionFind(int n) {
                this.roots = IntStream.range(0, n).toArray();
                this.isOnBoard = new boolean[n];
            }

            protected boolean[] getOnBoard() {
                return this.isOnBoard;
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
