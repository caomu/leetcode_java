//现在你总共有 n 门课需要选，记为 0 到 n-1。 
//
// 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1] 
//
// 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。 
//
// 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。 
//
// 示例 1: 
//
// 输入: 2, [[1,0]] 
//输出: [0,1]
//解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。 
//
// 示例 2: 
//
// 输入: 4, [[1,0],[2,0],[3,1],[3,2]]
//输出: [0,1,2,3] or [0,2,1,3]
//解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
//     因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
// 
//
// 说明: 
//
// 
// 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。 
// 你可以假定输入的先决条件中没有重复的边。 
// 
//
// 提示: 
//
// 
// 这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。 
// 通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。 
// 
// 拓扑排序也可以通过 BFS 完成。 
// 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 
// 👍 349 👎 0


import com.caomu.util.Utils;

import java.util.*;
import java.util.stream.IntStream;

public class _210_CourseScheduleIi {
    public static void main(String[] args) {
        Solution solution = new _210_CourseScheduleIi().new Solution();
        System.out.println(Arrays.toString(solution.findOrder(2, Utils.stringTo2DArray("[]"))));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            Map<Integer, List<Integer>> prerequisitesMap = new HashMap<>();
            List<Integer> order = new ArrayList<>();
            Arrays.stream(prerequisites).forEach(prerequisite -> {
                List<Integer> prerequisiteList = prerequisitesMap.getOrDefault(prerequisite[0], new ArrayList<>());
                prerequisiteList.add(prerequisite[1]);
                prerequisitesMap.put(prerequisite[0], prerequisiteList);
            });
            IntStream.range(0, numCourses).forEach(num -> prerequisitesMap.putIfAbsent(num, Arrays.asList(num)));
            int[] visited = new int[numCourses]; // 避免走回头路
            for (int start : prerequisitesMap.keySet()) {
                if (this.findCircle(prerequisitesMap, visited, start, order)) {
                    return new int[]{};
                }
            }
            return order.stream().mapToInt(Integer::intValue).toArray();
        }

        private boolean findCircle(Map<Integer, List<Integer>> prerequisitesMap, int[] visited, int course, List<Integer> order) {
            if (visited[course] == -1) {
                return false;
            } else if (visited[course] == 1) {
                return true;
            }
            visited[course] = 1;
            List<Integer> prerequisiteList = prerequisitesMap.get(course);
            if (null != prerequisiteList) {
                for (Integer pre : prerequisiteList) {
                    if (pre != course && this.findCircle(prerequisitesMap, visited, pre, order)) {
                        return true;
                    }
                }
            }
            order.add(course);
            visited[course] = -1;
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}