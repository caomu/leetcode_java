//给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
//
// 返回仅包含 1 的最长（连续）子数组的长度。
//
//
//
// 示例 1：
//
// 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
//输出：6
//解释：
//[1,1,1,0,0,1,1,1,1,1,1]
//粗体数字从 0 翻转到 1，最长的子数组长度为 6。
//
// 示例 2：
//
// 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
//输出：10
//解释：
//[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
//粗体数字从 0 翻转到 1，最长的子数组长度为 10。
//
//
//
// 提示：
//
//
// 1 <= A.length <= 20000
// 0 <= K <= A.length
// A[i] 为 0 或 1
//
// Related Topics 双指针 Sliding Window
// 👍 253 👎 0


import java.util.logging.Logger;

/**
 * create time: 2021-03-07 23:17:11
 */
public class _1004_MaxConsecutiveOnesIii {

    private static final Logger logger = Logger.getLogger(_1004_MaxConsecutiveOnesIii.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _1004_MaxConsecutiveOnesIii().new Solution();

//        assert solution.longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3) == 10;

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestOnes(int[] A, int K) {
            int i = 0;
            int j = 0;
            int max = K;
            int count1 = 0;
            while (j < A.length && i < A.length - K) {
                count1 += A[j];
                if (j - i + 1 > count1 + K) {
                    count1 -= A[i];
                    i++;
                } else {
                    max = Math.max(max, Math.min(count1 + K, A.length));
                }
                j++;
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
