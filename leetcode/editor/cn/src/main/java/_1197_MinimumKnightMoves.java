//一个坐标可以从 -infinity 延伸到 +infinity 的 无限大的 棋盘上，你的 骑士 驻扎在坐标为 [0, 0] 的方格里。
//
// 骑士的走法和中国象棋中的马相似，走 “日” 字：即先向左（或右）走 1 格，再向上（或下）走 2 格；或先向左（或右）走 2 格，再向上（或下）走 1 格
//。 
//
// 每次移动，他都可以按图示八个方向之一前进。 
//
// 
//
// 现在，骑士需要前去征服坐标为 [x, y] 的部落，请你为他规划路线。 
//
// 最后返回所需的最小移动次数即可。本题确保答案是一定存在的。 
//
// 
//
// 示例 1： 
//
// 输入：x = 2, y = 1
//输出：1
//解释：[0, 0] → [2, 1]
// 
//
// 示例 2： 
//
// 输入：x = 5, y = 5
//输出：4
//解释：[0, 0] → [2, 1] → [4, 2] → [3, 4] → [5, 5]
// 
//
// 
//
// 提示： 
//
// 
// |x| + |y| <= 300 
// 
// Related Topics 广度优先搜索 
// 👍 41 👎 0


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class _1197_MinimumKnightMoves {
    public static void main(String[] args) {
        Solution solution = new _1197_MinimumKnightMoves().new Solution();
        System.out.println(solution.minKnightMoves(-87, 83));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public int minKnightMoves(int x, int y) {
            int[][] dirs = new int[][]{
                    {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}
            };
            Queue<String> q = new LinkedList<>(); // 核心数据结构
            Set<String> visited = new HashSet<>(); // 避免走回头路
            String start = "0_0";
            q.offer(start); // 将起点加入队列
            visited.add(start);
            int step = 0; // 记录扩散的步数
            while (!q.isEmpty()) {
                /* 将当前队列中的所有节点向四周扩散 */
                int width = q.size();
                for (int i = 0; i < width; i++) {
                    String[] cur = q.poll().split("_");
                    int curX = Integer.parseInt(cur[0]);
                    int curY = Integer.parseInt(cur[1]);
                    /* 划重点：这里判断是否到达终点 */
                    if (curX == x && curY == y) {
                        return step;
                    }
                    /* 将 cur 的相邻节点加入队列 */
                    if (Math.abs(x - curX) + Math.abs(y - curY) <= 2) {
                        for (int[] dir : dirs) {
                            String p = (curX + dir[0]) + "_" + (curY + dir[1]);
                            if (!visited.contains(p)) {
                                q.offer(p);
                                visited.add(p);
                            }
                        }
                    } else {
                        if (curX <= x && curY <= y) {
                            String p1 = (curX + 2) + "_" + (curY + 1);
                            if (!visited.contains(p1)) {
                                q.offer(p1);
                                visited.add(p1);
                            }
                            String p2 = (curX + 1) + "_" + (curY + 2);
                            if (!visited.contains(p2)) {
                                q.offer(p2);
                                visited.add(p2);
                            }
                        } else if (curX <= x && curY > y) {
                            String p3 = (curX + 2) + "_" + (curY - 1);
                            if (!visited.contains(p3)) {
                                q.offer(p3);
                                visited.add(p3);
                            }
                            String p4 = (curX + 1) + "_" + (curY - 2);
                            if (!visited.contains(p4)) {
                                q.offer(p4);
                                visited.add(p4);
                            }
                        } else if (curX > x && curY <= y) {
                            String p5 = (curX - 2) + "_" + (curY + 1);
                            if (!visited.contains(p5)) {
                                q.offer(p5);
                                visited.add(p5);
                            }
                            String p6 = (curX - 1) + "_" + (curY + 2);
                            if (!visited.contains(p6)) {
                                q.offer(p6);
                                visited.add(p6);
                            }
                        } else if (curX > x && curY > y) {
                            String p7 = (curX - 2) + "_" + (curY - 1);
                            if (!visited.contains(p7)) {
                                q.offer(p7);
                                visited.add(p7);
                            }
                            String p8 = (curX - 1) + "_" + (curY - 2);
                            if (!visited.contains(p8)) {
                                q.offer(p8);
                                visited.add(p8);
                            }
                        }
                    }
//                    System.out.println("step:" + step + "->" + q);
                }
                /* 划重点：更新步数在这里 */
                step++;
            }
            return step;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}