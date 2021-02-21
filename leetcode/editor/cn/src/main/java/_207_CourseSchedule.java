//你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。 
//
// 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表
//示如果要学习课程 ai 则 必须 先学习课程 bi 。 
//
// 
// 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。 
// 
//
// 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0]]
//输出：true
//解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。 
//
// 示例 2： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
//输出：false
//解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。 
//
// 
//
// 提示： 
//
// 
// 1 <= numCourses <= 105 
// 0 <= prerequisites.length <= 5000 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// prerequisites[i] 中的所有课程对 互不相同 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 
// 👍 710 👎 0


import com.caomu.util.Utils;

import java.util.*;

public class _207_CourseSchedule {
    public static void main(String[] args) {
        Solution solution = new _207_CourseSchedule().new Solution();
        System.out.println(solution.canFinish(2,
                Utils.stringTo2DArray("[[1,0],[0,1]]")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            Map<Integer, List<Integer>> prerequisitesMap = new HashMap<>();
            Arrays.stream(prerequisites).forEach(prerequisite -> {
                List<Integer> prerequisiteList = prerequisitesMap.getOrDefault(prerequisite[0], new ArrayList<>());
                prerequisiteList.add(prerequisite[1]);
                prerequisitesMap.put(prerequisite[0], prerequisiteList);
            });
            int[] visited = new int[numCourses]; // 避免走回头路
            for (int start : prerequisitesMap.keySet()) {
                if (this.findCircle(prerequisitesMap, visited, start)) {
                    return false;
                }
            }
            return true;
        }

        private boolean findCircle(Map<Integer, List<Integer>> prerequisitesMap, int[] visited, int course) {
            if (visited[course] == -1) {
                return false;
            } else if (visited[course] == 1) {
                return true;
            }
            visited[course] = 1;
            List<Integer> prerequisiteList = prerequisitesMap.get(course);
            if (null != prerequisiteList) {
                for (Integer pre : prerequisiteList) {
                    if (this.findCircle(prerequisitesMap, visited, pre)) {
                        return true;
                    }
                }
            }
            visited[course] = -1;
            return false;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}