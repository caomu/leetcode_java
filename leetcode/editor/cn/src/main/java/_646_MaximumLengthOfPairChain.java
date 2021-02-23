//给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。 
//
// 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。 
//
// 给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。 
//
// 
//
// 示例： 
//
// 
//输入：[[1,2], [2,3], [3,4]]
//输出：2
//解释：最长的数对链是 [1,2] -> [3,4]
// 
//
// 
//
// 提示： 
//
// 
// 给出数对的个数在 [1, 1000] 范围内。 
// 
// Related Topics 动态规划 
// 👍 148 👎 0


import com.caomu.util.Utils;

import java.util.*;
import java.util.logging.Logger;

public class _646_MaximumLengthOfPairChain {

    private static final Logger logger = Logger.getLogger(_646_MaximumLengthOfPairChain.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _646_MaximumLengthOfPairChain().new Solution();
        assert solution.findLongestChain(Utils.stringTo2DArray("[[-10,-8],[8,9],[-5,0],[6,10],[-6,-4],[1,7],[9,10],[-4,7]]")) ==
               4;
        assert solution.findLongestChain(Utils.stringTo2DArray("[[9,10],[-4,9],[-5,6],[-5,9],[8,9]]")) == 2;
        assert solution.findLongestChain(Utils.stringTo2DArray("[[1,2], [2,3], [3,4]]")) == 2;
        assert solution.findLongestChain(Utils.stringTo2DArray("[[3,4],[2,3],[1,2]]")) == 2;
//        logger.warning(String.valueOf(solution.findLongestChain(Utils.stringTo2DArray("[[9,10],[-4,9],[-5,6],[-5,9],[8,9]]"))));
        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLongestChain(int[][] pairs) {
            Map<Integer, Set<Integer>> pairMap = new TreeMap<>();
            Arrays.stream(pairs).forEach(p -> {
                Set<Integer> endSet = pairMap.getOrDefault(p[1], new HashSet<>());
                endSet.add(p[0]);
                pairMap.put(p[1], endSet);
            });
            int[][] newPairs = new int[pairs.length][2];
            int i = 0;
            for (int end : pairMap.keySet()) {
                for (int start : pairMap.get(end)) {
                    newPairs[i][0] = start;
                    newPairs[i][1] = end;
                    i++;
                }
            }
            return this.findLongestChain(newPairs, pairs.length)[0];
        }

        /**
         * @param pairs
         * @param length
         * @return index 0 : count; index 1 : maxEnd
         */
        private int[] findLongestChain(int[][] pairs, int length) {
            if (length == 1) {
                return new int[]{1, pairs[0][1]};
            }
            int[] lastDP = this.findLongestChain(pairs, length - 1);
            if (lastDP[1] < pairs[length - 1][0]) {
                return new int[]{lastDP[0] + 1, pairs[length - 1][1]};
            } else {
                return lastDP;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
