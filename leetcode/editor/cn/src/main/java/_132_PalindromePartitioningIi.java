//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
//
// 返回符合要求的 最少分割次数 。
//
//
//
//
//
// 示例 1：
//
//
//输入：s = "aab"
//输出：1
//解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
//
//
// 示例 2：
//
//
//输入：s = "a"
//输出：0
//
//
// 示例 3：
//
//
//输入：s = "ab"
//输出：1
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 2000
// s 仅由小写英文字母组成
//
//
//
// Related Topics 动态规划
// 👍 312 👎 0


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

/**
 * create time: 2021-03-08 14:57:58
 */
public class _132_PalindromePartitioningIi {

    private static final Logger logger = Logger.getLogger(_132_PalindromePartitioningIi.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _132_PalindromePartitioningIi().new Solution();

        // assert solution == ;
        assert solution.minCut("aab") == 1;
        assert solution.minCut("a") == 0;
        assert solution.minCut("ab") == 1;
        assert solution.minCut("cdd") == 1;
//        logger.warning(String.valueOf(solution.minCut("abbaa")));
        logger.warning(String.valueOf(solution.minCut("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCut(String s) {
            int[] dp = new int[s.length()];
            Arrays.fill(dp, -1);
            return this.minCut(s, s.length() - 1, new HashSet<>(), new HashSet<>(), dp);
        }

        private int minCut(String s, int i, Set<String> partitions,
                           Set<String> nonPartitions, int[] dp) {
            if (dp[i] > -1) {
                return dp[i];
            }
            if (i == 0 || this.isPartition(partitions, nonPartitions, s, 0, i)) {
                dp[i] = 0;
            } else {
                int minCut = i;
                for (int j = i - 1; j >= 0; j--) {
                    if (this.isPartition(partitions, nonPartitions, s, j + 1, i)) {
                        minCut = Math.min(minCut, this.minCut(s, j, partitions, nonPartitions, dp) + 1);
                        if (minCut == 1) {
                            break;
                        }
                    }
                }
                dp[i] = minCut;
            }
            return dp[i];
        }

        private boolean isPartition(Set<String> partitions, Set<String> nonPartitions, String str, int i, int j) {
            String subStr = str.substring(i, j + 1);
            if (partitions.contains(subStr)) {
                return true;
            }
            if (nonPartitions.contains(subStr)) {
                return false;
            }
            while (i < j) {
                if (str.charAt(i) != str.charAt(j)) {
                    nonPartitions.add(subStr);
                    return false;
                }
                i++;
                j--;
            }
            partitions.add(subStr);
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
