//给定一个包含了一些 0 和 1 的非空二维数组 grid 。 
//
// 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 
//0（代表水）包围着。 
//
// 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。) 
//
// 
//
// 示例 1: 
//
// [[0,0,1,0,0,0,0,1,0,0,0,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,1,1,0,1,0,0,0,0,0,0,0,0],
// [0,1,0,0,1,1,0,0,1,0,1,0,0],
// [0,1,0,0,1,1,0,0,1,1,1,0,0],
// [0,0,0,0,0,0,0,0,0,0,1,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,0,0,0,0,0,0,1,1,0,0,0,0]]
// 
//
// 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。 
//
// 示例 2: 
//
// [[0,0,0,0,0,0,0,0]] 
//
// 对于上面这个给定的矩阵, 返回 0。 
//
// 
//
// 注意: 给定的矩阵grid 的长度和宽度都不超过 50。 
// Related Topics 深度优先搜索 数组 
// 👍 432 👎 0


import com.caomu.util.Utils;

import java.util.*;
import java.util.stream.IntStream;

public class _695_MaxAreaOfIsland {
    public static void main(String[] args) {
        Solution solution = new _695_MaxAreaOfIsland().new Solution();
//        assert solution.maxAreaOfIsland(Utils.stringTo2DArray("[[1,1]]")) == 2;
        System.out.println(solution.maxAreaOfIsland(Utils.stringTo2DArray("[[1,1,0,0,0],[1,1,0,0,0],[0,0,0,1,1],[0,0,0,1,1]]")));
//        assert solution.maxAreaOfIsland(Utils.stringTo2DArray("[[1,1,0,0,0],[1,1,0,0,0],[0,0,0,1,1],[0,0,0,1,1]]")) ==
//               4;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxAreaOfIsland(int[][] grid) {
            Map<Integer, Integer> islandArea = new HashMap<>();
            UnionFind uf = new UnionFind(grid.length * grid[0].length);
            int maxArea = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        int idx = i * grid[0].length + j;
                        int idx1Root = -1;
                        int idx1Area = 0;
                        int idx2Root = -1;
                        int idx2Area = 0;
                        if (i > 0 && grid[i - 1][j] == 1) {
                            int idx1 = (i - 1) * grid[0].length + j;
                            idx1Root = uf.findRoot(idx1);
                            idx1Area = islandArea.getOrDefault(idx1Root, 0);
                            uf.union(idx, idx1);
                        }
                        if (j > 0 && grid[i][j - 1] == 1) {
                            int idx2 = i * grid[0].length + j - 1;
                            idx2Root = uf.findRoot(idx2);
                            idx2Area = islandArea.getOrDefault(idx2Root, 0);
                            uf.union(idx, idx2);
                        }
                        int idxRoot = uf.findRoot(idx);
                        if (idx2Root >= 0 && idx1Root == idx2Root) {
                            // idx1Root >= 0
                            idx2Area = 0;
                        }
                        int area = idx1Area + idx2Area + 1;
                        maxArea = Math.max(area, maxArea);
                        islandArea.put(idxRoot, area);
                    }
                }
            }
            return maxArea;
        }

        private class UnionFind {
            private int[] roots;

            protected UnionFind(int n) {
                this.roots = IntStream.range(0, n).toArray();
            }

            protected int[] getRoots() {
                return this.roots;
            }

            protected void union(int p, int q) {
                int rootP = this.findRoot(p);
                int rootQ = this.findRoot(q);
                if (rootP < rootQ) {
                    this.roots[rootQ] = rootP;
                } else {
                    this.roots[rootP] = rootQ;
                }
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