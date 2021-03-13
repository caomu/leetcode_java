//在给定的二维二进制数组 A 中，存在两座岛。（岛是由四面相连的 1 形成的一个最大组。）
//
// 现在，我们可以将 0 变为 1，以使两座岛连接起来，变成一座岛。
//
// 返回必须翻转的 0 的最小数目。（可以保证答案至少是 1 。）
//
//
//
// 示例 1：
//
//
//输入：A = [[0,1],[1,0]]
//输出：1
//
//
// 示例 2：
//
//
//输入：A = [[0,1,0],[0,0,0],[0,0,1]]
//输出：2
//
//
// 示例 3：
//
//
//输入：A = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
//输出：1
//
//
//
// 提示：
//
//
// 2 <= A.length == A[0].length <= 100
// A[i][j] == 0 或 A[i][j] == 1
//
// Related Topics 深度优先搜索 广度优先搜索
// 👍 143 👎 0


import com.caomu.util.Utils;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.IntStream;

/**
 * create time: 2021-03-12 23:41:49
 */
public class _934_ShortestBridge {

    private static final Logger logger = Logger.getLogger(_934_ShortestBridge.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _934_ShortestBridge().new Solution();
//        logger.warning(String.valueOf(solution.shortestBridge(Utils.stringTo2DArray("[[0,1,0],[0,0,0],[0,0,1]]"))));
        assert solution.shortestBridge(Utils.stringTo2DArray("[[0,1],[1,0]]")) == 1;
        assert solution.shortestBridge(Utils.stringTo2DArray("[[0,1,0],[0,0,0],[0,0,1]]")) == 2;
        assert solution.shortestBridge(Utils.stringTo2DArray("[[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]")) ==
               1;

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shortestBridge(int[][] A) {
            UnionFind uf = new UnionFind(A.length * A[0].length);
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[0].length; j++) {
                    if (i > 0 && A[i][j] == 1 && A[i - 1][j] == 1) {
                        uf.union(i * A[0].length + j, (i - 1) * A[0].length + j);
                    }
                    if (j > 0 && A[i][j] == 1 && A[i][j - 1] == 1) {
                        uf.union(i * A[0].length + j, i * A[0].length + j - 1);
                    }
                }
            }
            int root = -1;
            int shortest = Integer.MAX_VALUE;
            int[][] deltas = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for (int i = 0; i < A.length; i++) {
                loop:
                for (int j = 0; j < A[0].length; j++) {
                    if (A[i][j] == 0) {
                        continue;
                    }
                    int start = i * A[0].length + j;
                    if (root == -1) {
                        root = uf.findRoot(start);
                    } else if (root != uf.findRoot(start)) {
                        continue;
                    }

                    Queue<Integer> q = new LinkedList<>(); // 核心数据结构
                    Set<Integer> visited = new HashSet<>(); // 避免走回头路

                    q.offer(start); // 将起点加入队列
                    visited.add(start);
                    int step = 0; // 记录扩散的步数

                    while (!q.isEmpty()) {
                        /* 将当前队列中的所有节点向四周扩散 */
                        int width = q.size();
                        for (int k = 0; k < width; k++) {
                            int cur = q.poll();
                            for (int[] delta : deltas) {
                                int nextX = (cur / A[0].length) + delta[0];
                                int nextY = cur % A[0].length + delta[1];
                                int next = nextX * A[0].length + nextY;
                                if (nextX >= 0 && nextX < A[0].length && nextY >= 0 && nextY < A.length) {
                                    if (A[nextX][nextY] == 0 && !visited.contains(next)) {
                                        visited.add(next);
                                        q.add(next);
                                    } else if (A[nextX][nextY] == 1 && uf.findRoot(next) != root) {
                                        shortest = Math.min(shortest, step);
                                        if (shortest == 1) {
                                            return 1;
                                        }
                                        continue loop;
                                    }
                                }
                            }
                        }
                        step++;
                    }

                }
            }
            return shortest;
        }

        private class UnionFind {
            private final int[] roots;

            protected UnionFind(int n) {
                this.roots = IntStream.range(0, n).toArray();
            }

            protected int[] getRoots() {
                return this.roots;
            }

            protected void union(int p, int q) {
                this.roots[this.findRoot(p)] = this.findRoot(q);
            }

            protected void union(int... p) {
                for (int i = 1; i < p.length; i++) {
                    this.union(p[i], p[0]);
                }
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

            protected boolean isConnected(int p, int q) {
                return this.findRoot(p) == this.findRoot(q);
            }

            protected int getCount() {
                Set<Integer> rootSet = new HashSet<>();
                Arrays.stream(this.roots).forEach(root -> rootSet.add(this.findRoot(root)));
                return rootSet.size();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
