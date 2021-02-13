//你被给定一个 m × n 的二维网格 rooms ，网格中有以下三种可能的初始化值：
//
// 
// -1 表示墙或是障碍物 
// 0 表示一扇门 
// INF 无限表示一个空的房间。然后，我们用 231 - 1 = 2147483647 代表 INF。你可以认为通往门的距离总是小于 2147483647 
//的。 
// 
//
// 你要给每个空房间位上填上该房间到 最近门的距离 ，如果无法到达门，则填 INF 即可。 
//
// 
//
// 示例 1： 
//
// 
//输入：rooms = [[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1]
//,[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]
//输出：[[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]
// 
//
// 示例 2： 
//
// 
//输入：rooms = [[-1]]
//输出：[[-1]]
// 
//
// 示例 3： 
//
// 
//输入：rooms = [[2147483647]]
//输出：[[2147483647]]
// 
//
// 示例 4： 
//
// 
//输入：rooms = [[0]]
//输出：[[0]]
// 
//
// 
//
// 提示： 
//
// 
// m == rooms.length 
// n == rooms[i].length 
// 1 <= m, n <= 250 
// rooms[i][j] 是 -1、0 或 231 - 1 
// 
// Related Topics 广度优先搜索 
// 👍 126 👎 0


import com.caomu.util.Utils;

import java.util.*;

public class _286_WallsAndGates {
    public static void main(String[] args) {
        Solution solution = new _286_WallsAndGates().new Solution();
        solution.wallsAndGates(Utils.stringTo2DArray(
                "[[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void wallsAndGates(int[][] rooms) {
            for (int i = 0; i < rooms.length; i++) {
                for (int j = 0; j < rooms[0].length; j++) {
                    if (rooms[i][j] == 0) {
                        Queue<int[]> q = new LinkedList<>(); // 核心数据结构
                        Set<String> visited = new HashSet<>();
                        int[] startPoint = new int[]{i, j};
                        q.offer(startPoint); // 将起点加入队列
                        int step = 1; // 记录扩散的步数

                        while (!q.isEmpty()) {
                            /* 将当前队列中的所有节点向四周扩散 */
                            int width = q.size();
                            for (int k = 0; k < width; k++) {
                                int[] cur = q.poll();
                                /* 划重点：这里判断是否到达终点 */
//                                if (cur.left == null && cur.right == null) {
//                                    return step;
//                                }
                                /* 将 cur 的相邻节点加入队列 */
                                int[] p = new int[]{cur[0] + 1, cur[1]};
                                String pStr = Arrays.toString(p);
                                if (p[0] < rooms.length && rooms[p[0]][p[1]] > 0 && !visited.contains(pStr)) {
                                    q.offer(p);
                                    visited.add(pStr);
                                    rooms[p[0]][p[1]] = Math.min(rooms[p[0]][p[1]], step);
                                }
                                p = new int[]{cur[0] - 1, cur[1]};
                                pStr = Arrays.toString(p);
                                if (p[0] >= 0 && rooms[p[0]][p[1]] > 0 && !visited.contains(pStr)) {
                                    q.offer(p);
                                    visited.add(pStr);
                                    rooms[p[0]][p[1]] = Math.min(rooms[p[0]][p[1]], step);
                                }
                                p = new int[]{cur[0], cur[1] + 1};
                                pStr = Arrays.toString(p);
                                if (p[1] < rooms[0].length && rooms[p[0]][p[1]] > 0 && !visited.contains(pStr)) {
                                    q.offer(p);
                                    visited.add(pStr);
                                    rooms[p[0]][p[1]] = Math.min(rooms[p[0]][p[1]], step);
                                }
                                p = new int[]{cur[0], cur[1] - 1};
                                pStr = Arrays.toString(p);
                                if (p[1] >= 0 && rooms[p[0]][p[1]] > 0 && !visited.contains(pStr)) {
                                    q.offer(p);
                                    visited.add(pStr);
                                    rooms[p[0]][p[1]] = Math.min(rooms[p[0]][p[1]], step);
                                }
                            }
                            /* 划重点：更新步数在这里 */
                            step++;
                        }
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}