//给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[
//l] = 0。
//
// 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最
//终结果不会超过 231 - 1 。
//
// 例如:
//
//
//输入:
//A = [ 1, 2]
//B = [-2,-1]
//C = [-1, 2]
//D = [ 0, 2]
//
//输出:
//2
//
//解释:
//两个元组如下:
//1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
//2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
//
// Related Topics 哈希表 二分查找
// 👍 342 👎 0


import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * create time: 2021-03-07 17:57:51
 */
public class _454_FourSumIi {

    private static final Logger logger = Logger.getLogger(_454_FourSumIi.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _454_FourSumIi().new Solution();

        // assert solution == ;
        logger.warning(String.valueOf(solution.fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2})));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
            if (A.length == 0) {
                return 0;
            }
            Map<Integer, Integer> abSumFrequencies = new HashMap<>();
            for (int a : A) {
                for (int b : B) {
                    int sum = a + b;
                    abSumFrequencies.put(sum, abSumFrequencies.getOrDefault(sum, 0) + 1);
                }
            }
            Map<Integer, Integer> cdSumFrequencies = new HashMap<>();
            for (int c : C) {
                for (int d : D) {
                    int sum = -c - d;
                    cdSumFrequencies.put(sum, cdSumFrequencies.getOrDefault(sum, 0) + 1);
                }
            }
            int count = 0;
            for (Map.Entry<Integer, Integer> entry : abSumFrequencies.entrySet()) {
                if (cdSumFrequencies.containsKey(entry.getKey())) {
                    count += entry.getValue() * cdSumFrequencies.get(entry.getKey());
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
