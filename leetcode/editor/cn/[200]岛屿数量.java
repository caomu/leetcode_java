//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 946 👎 0


import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        int[][] delta = new int[][]{
                {-1, 0},
                {0, -1},
//                {1, 0},
//                {0, 1}
        };
        UnionFind uf = new UnionFind(m * n);
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int idx = i * n + j;
                if (grid[i][j] == '1') {
//                    System.out.println("i:" + i + "\tj:" + j + "\tidx:" + idx);
                    for (int[] d : delta) {
                        int p = i + d[0];
                        int q = j + d[1];
                        if (p >= 0 && p < m && q >= 0 && q < n && grid[p][q] == '1') {
//                            System.out.println("p:" + p + "\tq:" + q + "\tidx:" + (p * n + q));
                            res.remove(uf.findRoot(idx));
                            uf.union(idx, p * n + q);
                        }
                    }
                    res.add(uf.findRoot(idx));
                }
//                else {
//                    uf.getRoots()[idx] = -1;
//                }
            }
        }
//        System.out.println(res);
        return res.size();
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
    }
}
//leetcode submit region end(Prohibit modification and deletion)
