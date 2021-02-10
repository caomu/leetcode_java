//在由 1 x 1 方格组成的 N x N 网格 grid 中，每个 1 x 1 方块由 /、\ 或空格构成。这些字符会将方块划分为一些共边的区域。 
//
// （请注意，反斜杠字符是转义的，因此 \ 用 "\\" 表示。）。 
//
// 返回区域的数目。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：
//[
//  " /",
//  "/ "
//]
//输出：2
//解释：2x2 网格如下：
// 
//
// 示例 2： 
//
// 输入：
//[
//  " /",
//  "  "
//]
//输出：1
//解释：2x2 网格如下：
// 
//
// 示例 3： 
//
// 输入：
//[
//  "\\/",
//  "/\\"
//]
//输出：4
//解释：（回想一下，因为 \ 字符是转义的，所以 "\\/" 表示 \/，而 "/\\" 表示 /\。）
//2x2 网格如下：
// 
//
// 示例 4： 
//
// 输入：
//[
//  "/\\",
//  "\\/"
//]
//输出：5
//解释：（回想一下，因为 \ 字符是转义的，所以 "/\\" 表示 /\，而 "\\/" 表示 \/。）
//2x2 网格如下：
// 
//
// 示例 5： 
//
// 输入：
//[
//  "//",
//  "/ "
//]
//输出：3
//解释：2x2 网格如下：
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length == grid[0].length <= 30 
// grid[i][j] 是 '/'、'\'、或 ' '。 
// 
// Related Topics 深度优先搜索 并查集 图 
// 👍 154 👎 0


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        Solution.UnionFind uf = new UnionFind(n * n * 4);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int p = (i * n + j) * 4;
                if (grid[i].charAt(j) == ' ') {
                    uf.union(p, p + 1, p + 2, p + 3);
                } else if (grid[i].charAt(j) == '/') {
                    uf.union(p, p + 3);
                    uf.union(p + 1, p + 2);
                } else if (grid[i].charAt(j) == '\\') {
                    uf.union(p, p + 1);
                    uf.union(p + 2, p + 3);
                }
//                System.out.println("i:" + i + ",j:" + j + ",p:" + p + "\t" + Arrays.toString(uf.getRoots()));
                if (i > 0) {
                    int q = ((i - 1) * n + j) * 4;
                    uf.union(p, q + 2);
//                    System.out.println(
//                            "i:" + i + ",j:" + j + ",p:" + p + ",q:" + q + "\t" + Arrays.toString(uf.getRoots()));
                }
                if (j > 0) {
                    int q = (i * n + (j - 1)) * 4;
                    uf.union(p + 3, q + 1);
//                    System.out.println(
//                            "i:" + i + ",j:" + j + ",p:" + p + ",q:" + q + "\t" + Arrays.toString(uf.getRoots()));
                }
            }
        }
//        System.out.println(Arrays.toString(uf.getRoots()));
        return uf.getCount();
    }


    private static class UnionFind {
        private int[] roots;

        protected UnionFind(int n) {
            this.roots = IntStream.range(0, n).toArray();
        }

        protected boolean isConnected(int p, int q) {
            return this.findRoot(p) == this.findRoot(q);
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

        public int getCount() {
            Set<Integer> rootSet = new HashSet<>();
            Arrays.stream(this.roots).forEach(root -> rootSet.add(this.findRoot(root)));
            return rootSet.size();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
