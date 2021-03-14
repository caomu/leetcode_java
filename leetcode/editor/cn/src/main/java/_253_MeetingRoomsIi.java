//给你一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，为避免
//会议冲突，同时要考虑充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排。
//
//
//
// 示例 1：
//
//
//输入：intervals = [[0,30],[5,10],[15,20]]
//输出：2
//
//
// 示例 2：
//
//
//输入：intervals = [[7,10],[2,4]]
//输出：1
//
//
//
//
// 提示：
//
//
// 1 <= intervals.length <= 104
// 0 <= starti < endi <= 106
//
// Related Topics 堆 贪心算法 排序
// 👍 239 👎 0


import com.caomu.util.Utils;

import java.util.*;
import java.util.logging.Logger;

/**
 * create time: 2021-03-14 21:28:14
 */
public class _253_MeetingRoomsIi {

    private static final Logger logger = Logger.getLogger(_253_MeetingRoomsIi.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _253_MeetingRoomsIi().new Solution();

        assert solution.minMeetingRooms(Utils.stringTo2DArray("[[0,30],[5,10],[15,20]]")) == 2;
        assert solution.minMeetingRooms(Utils.stringTo2DArray("[[7,10],[2,4]]")) == 1;
        assert solution.minMeetingRooms(Utils.stringTo2DArray("[[13,15],[1,13]]")) == 1;
        assert solution.minMeetingRooms(Utils.stringTo2DArray("[[15,16],[10,15],[16,25]]")) == 1;
        assert solution.minMeetingRooms(Utils.stringTo2DArray("[[1,8],[6,20],[9,16],[13,17]]")) == 3;
        assert solution.minMeetingRooms(Utils.stringTo2DArray("[[13,15],[1,13],[6,9]]")) == 2;
        assert solution.minMeetingRooms(Utils.stringTo2DArray("[[7,8],[6,10],[1,3],[11,19]]")) == 2;
        assert solution.minMeetingRooms(Utils.stringTo2DArray("[[26,29],[19,26],[19,28],[4,19],[4,25]]")) == 3;
        assert solution.minMeetingRooms(Utils.stringTo2DArray("[[2,36],[3,4],[13,34],[16,20],[39,46]]")) == 3;
//        logger.warning(String.valueOf(solution));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minMeetingRooms(int[][] intervals) {
            Map<Integer, List<Integer>> outGraph = new HashMap<>();
            Map<Integer, List<Integer>> inGraph = new HashMap<>();
            for (int i = 0; i < intervals.length; i++) {
                List<Integer> nextList = new ArrayList<>();
                List<Integer> previousList = new ArrayList<>();
                for (int j = 0; j < intervals.length; j++) {
                    if (i != j) {
                        if (intervals[i][1] <= intervals[j][0]) {
                            nextList.add(j);
                        }
                        if (intervals[i][0] >= intervals[j][1]) {
                            previousList.add(j);
                        }
                    }
                }
                outGraph.put(i, nextList);
                inGraph.put(i, previousList);
            }
            int maxZeroIndegree = (int) inGraph.values().stream().filter(List::isEmpty).count();
            int maxZeroOutdegree = (int) outGraph.values().stream().filter(List::isEmpty).count();
            Queue<Integer> q = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();
            for (int i = 0; i < intervals.length; i++) {
                if (inGraph.get(i).isEmpty()) {
                    q.offer(i);
                    visited.add(i);
                }
            }
            int indegree = 1;
            int maxWidth = q.size();
            maxWidth = Math.max(maxWidth, maxZeroIndegree);
            maxWidth = Math.max(maxWidth, maxZeroOutdegree);
            while (!q.isEmpty()) {
                int width = q.size();
                maxWidth = Math.max(maxWidth, width);
                Set<Integer> nextLevel = new HashSet<>();
                for (int i = 0; i < width; i++) {
                    int cur = q.poll();
                    for (int j : outGraph.get(cur)) {
                        if (!visited.contains(j) && inGraph.get(j).size() == indegree) {
                            nextLevel.add(j);
                        }
                    }
                }
                boolean isEndLevel = true;
                int endCount = 0;
                for (int next : nextLevel) {
                    if (!outGraph.get(next).isEmpty()) {
                        isEndLevel = false;
                    } else {
                        endCount++;
                    }
                }
                if (!isEndLevel) {
                    maxWidth += endCount;
                }
                q.addAll(nextLevel);
                visited.addAll(nextLevel);
                indegree++;
            }
//            System.out.println(maxWidth);
            return maxWidth;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
