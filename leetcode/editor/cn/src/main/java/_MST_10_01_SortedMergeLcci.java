//给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
//
// 初始化 A 和 B 的元素数量分别为 m 和 n。
//
// 示例:
//
// 输入:
//A = [1,2,3,0,0,0], m = 3
//B = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6]
//
// 说明:
//
//
// A.length == n + m
//
// Related Topics 数组 双指针
// 👍 100 👎 0


import java.util.logging.Logger;

/**
 * create time: 2021-03-21 17:04:06
 */
public class _MST_10_01_SortedMergeLcci {

    private static final Logger logger = Logger.getLogger(_MST_10_01_SortedMergeLcci.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _MST_10_01_SortedMergeLcci().new Solution();

        // assert solution == ;
        solution.merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] A, int m, int[] B, int n) {
            int i = m + n - 1;
            while (n > 0) {
                A[i--] = (m == 0 || A[m - 1] < B[n - 1]) ? B[n-- - 1] : A[m-- - 1];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
