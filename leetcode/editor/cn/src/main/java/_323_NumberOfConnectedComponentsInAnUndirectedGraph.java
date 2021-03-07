//给定编号从 0 到 n-1 的 n 个节点和一个无向边列表（每条边都是一对节点），请编写一个函数来计算无向图中连通分量的数目。
//
// 示例 1:
//
// 输入: n = 5 和 edges = [[0, 1], [1, 2], [3, 4]]
//
//     0          3
//     |          |
//     1 --- 2    4
//
//输出: 2
//
//
// 示例 2:
//
// 输入: n = 5 和 edges = [[0, 1], [1, 2], [2, 3], [3, 4]]
//
//     0           4
//     |           |
//     1 --- 2 --- 3
//
//输出:  1
//
//
// 注意:
//你可以假设在 edges 中不会出现重复的边。而且由于所以的边都是无向边，[0, 1] 与 [1, 0] 相同，所以它们不会同时在 edges 中出现。
// Related Topics 深度优先搜索 广度优先搜索 并查集 图
// 👍 70 👎 0


import com.caomu.util.Utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.IntStream;

public class _323_NumberOfConnectedComponentsInAnUndirectedGraph {

    private static final Logger logger = Logger.getLogger(_323_NumberOfConnectedComponentsInAnUndirectedGraph.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _323_NumberOfConnectedComponentsInAnUndirectedGraph().new Solution();

        assert 2 == solution.countComponents(5, Utils.stringTo2DArray("[[0,1],[1,2],[3,4]]"));
        assert 1 == solution.countComponents(5, Utils.stringTo2DArray("[[0,1],[1,2],[2,3],[3,4]]"));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countComponents(int n, int[][] edges) {
            UnionFind uf = new UnionFind(n);
            for (int[] edge : edges) {
                uf.union(edge[0], edge[1]);
            }
            return uf.getCount();
        }

        private class UnionFind {
            private final int[] roots;

            protected UnionFind(int n) {
                this.roots = IntStream.range(0, n).toArray();
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

            protected int getCount() {
                Set<Integer> rootSet = new HashSet<>();
                Arrays.stream(this.roots).forEach(root -> rootSet.add(this.findRoot(root)));
                return rootSet.size();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
