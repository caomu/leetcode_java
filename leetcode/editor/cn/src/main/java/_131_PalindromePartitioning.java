//给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。 
//
// 返回 s 所有可能的分割方案。 
//
// 示例: 
//
// 输入: "aab"
//输出:
//[
//  ["aa","b"],
//  ["a","a","b"]
//] 
// Related Topics 深度优先搜索 动态规划 回溯算法 
// 👍 487 👎 0


import java.util.*;
import java.util.logging.Logger;

public class _131_PalindromePartitioning {

    private static final Logger logger = Logger.getLogger(_131_PalindromePartitioning.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _131_PalindromePartitioning().new Solution();

        // assert solution == ;
//        logger.warning(String.valueOf(solution.partition("aab")));
//        logger.warning(String.valueOf(solution.partition("efe")));
//        logger.warning(String.valueOf(solution.partition("fff")));
//        assert 9 == solution.partition("cbbbcc").size();
        logger.warning(String.valueOf(solution.partition("aaabaa")));
        logger.warning(String.valueOf(solution.partition("aaabaa").size()));
        assert 11 == solution.partition("aaabaa").size();
        logger.warning(String.valueOf(solution.partition("ccaacabacb")));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> res = new ArrayList<>();
            this.partition(s, 0, new LinkedList<>(), new HashSet<>(), new HashSet<>(), res);
            return res;
        }

        private void partition(String str, int begin, Deque<String> path, Set<String> partitions,
                               Set<String> nonPartitions, List<List<String>> res) {
            if (begin == str.length()) {
//                System.out.println("递归结束** => " + path);
                res.add(new ArrayList<>(path));
                return;
            }
            for (int i = begin; i < str.length(); i++) {
                if (this.isPartition(partitions, nonPartitions, str, begin, i)) {
                    path.addLast(str.substring(begin, i + 1));
//                    System.out.println("递归之前 => " + path);
                    this.partition(str, i + 1, path, partitions, nonPartitions, res);
                    path.removeLast();
//                    System.out.println("递归之前 => " + path);
                }
            }
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
