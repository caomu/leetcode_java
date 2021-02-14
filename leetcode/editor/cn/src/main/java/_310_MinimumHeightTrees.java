//树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。 
//
// 给你一棵包含 n 个节点的树，标记为 0 到 n - 1 。给定数字 n 和一个有 n - 1 条无向边的 edges 列表（每一个边都是一对标签），其中
// edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条无向边。 
//
// 可选择树中任何一个节点作为根。当选择节点 x 作为根节点时，设结果树的高度为 h 。在所有可能的树中，具有最小高度的树（即，min(h)）被称为 最小高度
//树 。 
//
// 请你找到所有的 最小高度树 并按 任意顺序 返回它们的根节点标签列表。 
//树的 高度 是指根节点和叶子节点之间最长向下路径上边的数量。
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, edges = [[1,0],[1,2],[1,3]]
//输出：[1]
//解释：如图所示，当根是标签为 1 的节点时，树的高度是 1 ，这是唯一的最小高度树。 
//
// 示例 2： 
//
// 
//输入：n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
//输出：[3,4]
// 
//
// 示例 3： 
//
// 
//输入：n = 1, edges = []
//输出：[0]
// 
//
// 示例 4： 
//
// 
//输入：n = 2, edges = [[0,1]]
//输出：[0,1]
// 
//
// 
//
// 
// 
//
// 提示： 
//
// 
// 1 <= n <= 2 * 104 
// edges.length == n - 1 
// 0 <= ai, bi < n 
// ai != bi 
// 所有 (ai, bi) 互不相同 
// 给定的输入 保证 是一棵树，并且 不会有重复的边 
// 
// Related Topics 广度优先搜索 图 
// 👍 293 👎 0


import com.caomu.util.Utils;

import java.util.*;
import java.util.stream.Collectors;

public class _310_MinimumHeightTrees {
    public static void main(String[] args) {
        Solution solution = new _310_MinimumHeightTrees().new Solution();
        System.out.println(solution.findMinHeightTrees(4, Utils.stringTo2DArray("[[1,0],[1,2],[1,3]]")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            Set<Integer> minHightRoots = new HashSet();
            if (n == 1) {
                minHightRoots.add(0);
                return new ArrayList<>(minHightRoots);
            }
            Map<Integer, List<Integer>> routes = new HashMap<>();
            for (int[] edge : edges) {
                List<Integer> endList = routes.getOrDefault(edge[0], new LinkedList<>());
                endList.add(edge[1]);
                routes.put(edge[0], endList);
                endList = routes.getOrDefault(edge[1], new LinkedList<>());
                endList.add(edge[0]);
                routes.put(edge[1], endList);
            }
            Map<Integer, List<Integer>> finalRoutes = routes;
            List<Map.Entry<Integer, List<Integer>>> q = finalRoutes.entrySet().stream().filter(entry ->
                    entry.getValue().size() == 1).collect(Collectors.toList()); // 核心数据结构
            List<Map.Entry<Integer, List<Integer>>> result = q;
            while (!q.isEmpty()) {
                Map<Integer, List<Integer>> newRoutes = new HashMap<>();
                result = q;
                for (Map.Entry<Integer, List<Integer>> entry : routes.entrySet()) {
                    if (entry.getValue().size() > 1) {
                        q.forEach(visted -> {
                            if (entry.getKey().equals(visted.getValue().get(0))) {
                                entry.getValue().remove(visted.getKey());
                            }
                        });
                        newRoutes.put(entry.getKey(), entry.getValue());
                    }
                }
                routes = newRoutes;
                q = newRoutes.entrySet().stream().filter(entry ->
                        entry.getValue().size() == 1).collect(Collectors.toList());
            }
            return result.stream().map(entry -> entry.getValue().get(0)).distinct().collect(Collectors.toList());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}