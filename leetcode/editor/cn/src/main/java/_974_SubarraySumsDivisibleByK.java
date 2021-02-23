//给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。 
//
// 
//
// 示例： 
//
// 输入：A = [4,5,0,-2,-3,1], K = 5
//输出：7
//解释：
//有 7 个子数组满足其元素之和可被 K = 5 整除：
//[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 30000 
// -10000 <= A[i] <= 10000 
// 2 <= K <= 10000 
// 
// Related Topics 数组 哈希表 
// 👍 240 👎 0


import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class _974_SubarraySumsDivisibleByK {

    private static final Logger logger = Logger.getLogger(_974_SubarraySumsDivisibleByK.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _974_SubarraySumsDivisibleByK().new Solution();
        assert 7 == solution.subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5);
        assert 2 == solution.subarraysDivByK(new int[]{-1, 2, 9}, 2);
        assert 1 == solution.subarraysDivByK(new int[]{0, -5}, 10);
        assert 1 == solution.subarraysDivByK(new int[]{-2, 4, -5, 7, 7}, 6);
        assert 11 == solution.subarraysDivByK(new int[]{7, -5, 5, -8, -6, 6, -4, 7, -8, -7}, 7);
//        logger.info(String.valueOf(solution.subarraysDivByK(new int[]{7, -5, 5, -8, -6, 6, -4, 7, -8, -7}, 7)));
        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraysDivByK(int[] A, int K) {
            int[] sum = new int[A.length];
            sum[0] = A[0];
            Map<Integer, Integer> remainderIndexMap = new HashMap<>();
            remainderIndexMap.put(sum[0] % K, 1);
            int cnt = sum[0] % K == 0 ? 1 : 0;
            for (int i = 1; i < A.length; i++) {
                sum[i] = sum[i - 1] + A[i];
                int modulus = (sum[i] % K + K) % K;
                if (modulus == 0) {
                    cnt++;
                }
                if (remainderIndexMap.containsKey(modulus + K)) {
                    cnt += remainderIndexMap.get(modulus + K);
                }
                if (remainderIndexMap.containsKey(modulus - K)) {
                    cnt += remainderIndexMap.get(modulus - K);
                }
                if (remainderIndexMap.containsKey(modulus)) {
                    cnt += remainderIndexMap.get(modulus);
                }
                remainderIndexMap.put(modulus, remainderIndexMap.getOrDefault(modulus, 0) + 1);
            }
            return cnt;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
