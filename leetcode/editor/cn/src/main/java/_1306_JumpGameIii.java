//这里有一个非负整数数组 arr，你最开始位于该数组的起始下标 start 处。当你位于下标 i 处时，你可以跳到 i + arr[i] 或者 i - arr
//[i]。
//
// 请你判断自己是否能够跳到对应元素值为 0 的 任一 下标处。
//
// 注意，不管是什么情况下，你都无法跳到数组之外。
//
//
//
// 示例 1：
//
// 输入：arr = [4,2,3,0,3,1,2], start = 5
//输出：true
//解释：
//到达值为 0 的下标 3 有以下可能方案：
//下标 5 -> 下标 4 -> 下标 1 -> 下标 3
//下标 5 -> 下标 6 -> 下标 4 -> 下标 1 -> 下标 3
//
//
// 示例 2：
//
// 输入：arr = [4,2,3,0,3,1,2], start = 0
//输出：true
//解释：
//到达值为 0 的下标 3 有以下可能方案：
//下标 0 -> 下标 4 -> 下标 1 -> 下标 3
//
//
// 示例 3：
//
// 输入：arr = [3,0,2,1,2], start = 2
//输出：false
//解释：无法到达值为 0 的下标 1 处。
//
//
//
//
// 提示：
//
//
// 1 <= arr.length <= 5 * 10^4
// 0 <= arr[i] < arr.length
// 0 <= start < arr.length
//
// Related Topics 深度优先搜索 广度优先搜索 递归
// 👍 62 👎 0


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.logging.Logger;

/**
 * create time: 2021-03-13 19:31:40
 */
public class _1306_JumpGameIii {

    private static final Logger logger = Logger.getLogger(_1306_JumpGameIii.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _1306_JumpGameIii().new Solution();

        assert solution.canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 5) == true;
        assert solution.canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 0) == true;
        assert solution.canReach(new int[]{3, 0, 2, 1, 2}, 2) == false;
//        logger.warning(String.valueOf(solution));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canReach(int[] arr, int start) {
            if (arr[start] == 0) {
                return true;
            }
            Queue<Integer> q = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();

            q.offer(start);
            visited.add(start);

            while (!q.isEmpty()) {
                int width = q.size();
                for (int i = 0; i < width; i++) {
                    int cur = q.poll();
                    int next = cur + arr[cur];
                    if (next >= 0 && next < arr.length && !visited.contains(next)) {
                        if (arr[next] == 0) {
                            return true;
                        }
                        visited.add(next);
                        q.offer(next);
                    }
                    next = cur - arr[cur];
                    if (next >= 0 && next < arr.length && !visited.contains(next)) {
                        if (arr[next] == 0) {
                            return true;
                        }
                        visited.add(next);
                        q.offer(next);
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
