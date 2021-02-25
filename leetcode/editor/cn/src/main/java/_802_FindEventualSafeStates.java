//在有向图中, 我们从某个节点和每个转向处开始, 沿着图的有向边走。 如果我们到达的节点是终点 (即它没有连出的有向边), 我们停止。 
//
// 现在, 如果我们最后能走到终点，那么我们的起始节点是最终安全的。 更具体地说, 存在一个自然数 K, 无论选择从哪里开始行走, 我们走了不到 K 步后必能
//停止在一个终点。 
//
// 哪些节点最终是安全的？ 结果返回一个有序的数组。 
//
// 该有向图有 N 个节点，标签为 0, 1, ..., N-1, 其中 N 是 graph 的节点数. 图以以下的形式给出: graph[i] 是节点 j 
//的一个列表，满足 (i, j) 是图的一条有向边。 
//
// 
//示例：
//输入：graph = [[1,2],[2,3],[5],[0],[5],[],[]]
//输出：[2,4,5,6]
//这里是上图的示意图。
//
// 
//
// 
//
// 提示： 
//
// 
// graph 节点数不超过 10000. 
// 图的边数不会超过 32000. 
// 每个 graph[i] 被排序为不同的整数列表， 在区间 [0, graph.length - 1] 中选取。 
// 
// Related Topics 深度优先搜索 图 
// 👍 110 👎 0


import com.caomu.util.Utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

public class _802_FindEventualSafeStates {

    private static final Logger logger = Logger.getLogger(_802_FindEventualSafeStates.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _802_FindEventualSafeStates().new Solution();

        // assert solution == ;
        logger.warning(String.valueOf(solution.eventualSafeNodes(Utils.stringTo2DArray("[[1,2],[2,3],[5],[0],[5],[],[]]"))));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> eventualSafeNodes(int[][] graph) {
            List<Integer> safeNodes = new ArrayList<>();
            Boolean[] checked = new Boolean[graph.length];
            for (int i = 0; i < graph.length; i++) {
                if (this.isSafeNode(graph, checked, new HashSet<>(), i)) {
                    safeNodes.add(i);
                }
            }
            return safeNodes;
        }

        private boolean isSafeNode(int[][] graph, Boolean[] checked, Set<Integer> path, int node) {
            if (checked[node] != null) {
                return checked[node];
            }
            boolean result = true;
            path.add(node);
            for (int nextNode : graph[node]) {
                if (path.contains(nextNode)) {
                    result = false;
                    break;
                }
                result = this.isSafeNode(graph, checked, path, nextNode);
                if (!result) {
                    break;
                }
            }
            path.remove(node);
            checked[node] = result;
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
