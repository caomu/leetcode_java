//给你这棵「无向树」，请你测算并返回它的「直径」：这棵树上最长简单路径的 边数。
//
// 我们用一个由所有「边」组成的数组 edges 来表示一棵无向树，其中 edges[i] = [u, v] 表示节点 u 和 v 之间的双向边。
//
// 树上的节点都已经用 {0, 1, ..., edges.length} 中的数做了标记，每个节点上的标记都是独一无二的。
//
//
//
// 示例 1：
//
//
//
// 输入：edges = [[0,1],[0,2]]
//输出：2
//解释：
//这棵树上最长的路径是 1 - 0 - 2，边数为 2。
//
//
// 示例 2：
//
//
//
// 输入：edges = [[0,1],[1,2],[2,3],[1,4],[4,5]]
//输出：4
//解释：
//这棵树上最长的路径是 3 - 2 - 1 - 4 - 5，边数为 4。
//
//
//
//
// 提示：
//
//
// 0 <= edges.length < 10^4
// edges[i][0] != edges[i][1]
// 0 <= edges[i][j] <= edges.length
// edges 会形成一棵无向树
//
// Related Topics 树 深度优先搜索 广度优先搜索
// 👍 58 👎 0


import com.caomu.util.Utils;

import java.util.*;
import java.util.logging.Logger;

/**
 * create time: 2021-03-13 18:01:10
 */
public class _1245_TreeDiameter {

    private static final Logger logger = Logger.getLogger(_1245_TreeDiameter.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _1245_TreeDiameter().new Solution();

        assert solution.treeDiameter(Utils.stringTo2DArray("[[0,1],[0,2]]")) == 2;
        assert solution.treeDiameter(Utils.stringTo2DArray("[[0,1],[1,2],[2,3],[1,4],[4,5]]")) == 4;
        logger.warning(String.valueOf(solution.treeDiameter(Utils.stringTo2DArray("[[0,1],[0,2]]"))));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int treeDiameter(int[][] edges) {
            Map<Integer, List<Integer>> edgeMap = new HashMap<>();
            for (int[] edge : edges) {
                List<Integer> list0 = edgeMap.getOrDefault(edge[0], new ArrayList<>());
                list0.add(edge[1]);
                edgeMap.put(edge[0], list0);
                List<Integer> list1 = edgeMap.getOrDefault(edge[1], new ArrayList<>());
                list1.add(edge[0]);
                edgeMap.put(edge[1], list1);
            }

            Queue<Integer> q = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();
            int start = edges[0][0];
            q.offer(start);
            visited.add(start);
            int end = start;
            while (!q.isEmpty()) {
                int width = q.size();
                for (int i = 0; i < width; i++) {
                    int cur = q.poll();
                    end = cur;
                    for (int next : edgeMap.get(cur)) {
                        if (!visited.contains(next)) {
                            visited.add(next);
                            q.offer(next);
                        }
                    }
                }
            }
            q.clear();
            visited.clear();
            q.offer(end);
            visited.add(end);
            int diameter = -1;
            while (!q.isEmpty()) {
                int width = q.size();
                for (int i = 0; i < width; i++) {
                    for (int next : edgeMap.get(q.poll())) {
                        if (!visited.contains(next)) {
                            visited.add(next);
                            q.offer(next);
                        }
                    }
                }
                diameter++;
            }
            return diameter;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
