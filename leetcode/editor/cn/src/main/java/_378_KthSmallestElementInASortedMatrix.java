//给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
//请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
//
//
//
// 示例 1：
//
//
//输入：matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
//输出：13
//解释：矩阵中的元素为 [1,5,9,10,11,12,13,13,15]，第 8 小元素是 13
//
//
// 示例 2：
//
//
//输入：matrix = [[-5]], k = 1
//输出：-5
//
//
//
//
// 提示：
//
//
// n == matrix.length
// n == matrix[i].length
// 1 <= n <= 300
// -109 <= matrix[i][j] <= -109
// 题目数据 保证 matrix 中的所有行和列都按 非递减顺序 排列
// 1 <= k <= n2
//
// Related Topics 堆 二分查找
// 👍 548 👎 0


import com.caomu.util.Utils;

import java.util.*;
import java.util.logging.Logger;

/**
 * create time: 2021-03-14 16:48:45
 */
public class _378_KthSmallestElementInASortedMatrix {

    private static final Logger logger = Logger.getLogger(_378_KthSmallestElementInASortedMatrix.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _378_KthSmallestElementInASortedMatrix().new Solution();

        // assert solution == ;
        logger.warning(String.valueOf(solution.kthSmallest(
                Utils.stringTo2DArray("[[1,5,9],[10,11,13],[12,13,15]]"), 8)));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            if (k == 1) {
                return matrix[0][0];
            }
            int m = matrix.length;
            int n = matrix[0].length;
            Queue<Integer> q = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();

            q.offer(0);
            visited.add(0);
            PriorityQueue<Integer> kthSmallest = new PriorityQueue<>(k, Comparator.reverseOrder());
            int[][] deltas = new int[][]{{1, 0}, {0, 1}};
            while (!q.isEmpty()) {
                int width = q.size();
                boolean isAllBig = true;
                for (int i = 0; i < width; i++) {
                    int cur = q.poll();
                    int x = cur / n;
                    int y = cur % m;
                    kthSmallest.offer(matrix[x][y]);
                    if (kthSmallest.size() > k) {
                        kthSmallest.poll();
                    }
                    for (int[] delta : deltas) {
                        int nextX = x + delta[0];
                        int nextY = y + delta[1];
                        int next = nextX * m + nextY;
                        if (nextX < n && nextY < m && !visited.contains(next)) {
                            if (kthSmallest.size() < k || matrix[nextX][nextY] <= kthSmallest.peek()) {
                                isAllBig = false;
                            }
                            q.offer(next);
                            visited.add(next);
                        }
                    }
                }
                if (isAllBig) {
                    break;
                }
            }
            return kthSmallest.peek();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
