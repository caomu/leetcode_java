//有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。
//
// 在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中
//N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。
//
// 最初，除 0 号房间外的其余所有房间都被锁住。
//
// 你可以自由地在房间之间来回走动。
//
// 如果能进入每个房间返回 true，否则返回 false。
//
//
//
//
// 示例 1：
//
// 输入: [[1],[2],[3],[]]
//输出: true
//解释:
//我们从 0 号房间开始，拿到钥匙 1。
//之后我们去 1 号房间，拿到钥匙 2。
//然后我们去 2 号房间，拿到钥匙 3。
//最后我们去了 3 号房间。
//由于我们能够进入每个房间，我们返回 true。
//
//
// 示例 2：
//
// 输入：[[1,3],[3,0,1],[2],[0]]
//输出：false
//解释：我们不能进入 2 号房间。
//
//
// 提示：
//
//
// 1 <= rooms.length <= 1000
// 0 <= rooms[i].length <= 1000
// 所有房间中的钥匙数量总计不超过 3000。
//
// Related Topics 深度优先搜索 图
// 👍 188 👎 0


import java.sql.Timestamp;
import java.time.Duration;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * create time: 2021-04-20 13:05:25
 */
public class _841_KeysAndRooms {

    private static final Logger logger = Logger.getLogger(_841_KeysAndRooms.class.toString());
    private static final long START_TIMESTAMP = Timestamp.valueOf("2021-04-20 13:05:25").getTime();

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _841_KeysAndRooms().new Solution();

        assert solution == null;
        // logger.log(Level.warning, solution);

        logger.log(Level.INFO, "time cost: [{0}] ms", (System.currentTimeMillis() - startTimeMillis));
        logger.log(Level.INFO, "solution cost: [{0}]", Duration.ofSeconds(
                (System.currentTimeMillis() - START_TIMESTAMP) / 1000));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            if (rooms.get(0).isEmpty()) {
                return rooms.size() == 1;
            }
            Queue<Integer> q = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();

            q.offer(0);
            visited.add(0);

            while (!q.isEmpty()) {
                int width = q.size();
                for (int i = 0; i < width; i++) {
                    int cur = q.poll();
                    for (int key : rooms.get(cur)) {
                        if (!visited.contains(key)) {
                            visited.add(key);
                            if (visited.size() == rooms.size()) {
                                return true;
                            }
                            q.offer(key);
                        }
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
