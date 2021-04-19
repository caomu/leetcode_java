//你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
// 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
//
// 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
//
// 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
//
// 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
//
//
//
// 示例 1:
//
//
//输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
//输出：6
//解释：
//可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
//注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
//因为当拨动到 "0102" 时这个锁就会被锁定。
//
//
// 示例 2:
//
//
//输入: deadends = ["8888"], target = "0009"
//输出：1
//解释：
//把最后一位反向旋转一次即可 "0000" -> "0009"。
//
//
// 示例 3:
//
//
//输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], targ
//et = "8888"
//输出：-1
//解释：
//无法旋转到目标数字且不被锁定。
//
//
// 示例 4:
//
//
//输入: deadends = ["0000"], target = "8888"
//输出：-1
//
//
//
//
// 提示：
//
//
// 死亡列表 deadends 的长度范围为 [1, 500]。
// 目标数字 target 不会在 deadends 之中。
// 每个 deadends 和 target 中的字符串的数字会在 10,000 个可能的情况 '0000' 到 '9999' 中产生。
//
// Related Topics 广度优先搜索
// 👍 244 👎 0


import java.sql.Timestamp;
import java.time.Duration;
import java.util.*;
import java.util.logging.Logger;

/**
 * create time: 2021-04-19 18:49:07
 */
public class _752_OpenTheLock {

    private static final Logger logger = Logger.getLogger(_752_OpenTheLock.class.toString());
    private static final long startTimestamp = Timestamp.valueOf("2021-04-19 18:49:07").getTime();

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _752_OpenTheLock().new Solution();

        assert solution.openLock(new String[]{}, "0202") == 4;
        assert solution.openLock(new String[]{}, "0001") == 1;
        assert solution.openLock(new String[]{}, "0009") == 1;
        assert solution.openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202") == 6;
        assert solution.openLock(new String[]{"8888"}, "0009") == 1;
        assert solution.openLock(new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"}, "8888") ==
               -1;
        assert solution.openLock(new String[]{"0000"}, "8888") == -1;

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
        logger.info("solution cost: [" +
                    Duration.ofSeconds((System.currentTimeMillis() - startTimestamp) / 1000).toString() + "]");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int openLock(String[] deadends, String target) {
            Set<String> deadendsSet = new HashSet(Arrays.asList(deadends));
            if (deadendsSet.contains("0000")) {
                return -1;
            }
            Queue<String> q = new LinkedList<>();
            Set<String> visited = new HashSet<>();
            q.offer("0000");
            visited.add("0000");
            int step = 0;
            int[] deltas = new int[]{1, -1};
            while (!q.isEmpty()) {
                int width = q.size();
                loop:
                for (int i = 0; i < width; i++) {
                    String cur = q.poll();
                    if (cur.equals(target)) {
                        return step;
                    }
                    for (int j = 0; j < 4; j++) {
                        for (int delta : deltas) {
                            char[] chars = Arrays.copyOf(cur.toCharArray(), 4);
                            int digit = chars[j] - '0';
                            digit += delta;
                            if (digit == 10) {
                                digit = 0;
                            } else if (digit == -1) {
                                digit = 9;
                            }
                            chars[j] = (char) (digit + '0');
                            String next = new String(chars);
                            if (!deadendsSet.contains(next) && !visited.contains(next)) {
                                q.offer(next);
                                visited.add(next);
                            }
                        }
                    }
                }
                step++;
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
