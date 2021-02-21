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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class _646_MaximumLengthOfPairChain {
    public static void main(String[] args) {
        Solution solution = new _646_MaximumLengthOfPairChain().new Solution();
//        assert solution.findLongestChain(Utils.stringTo2DArray("[[-10,-8],[8,9],[-5,0],[6,10],[-6,-4],[1,7],[9,10],[-4,7]]")) ==
//               4;
        assert solution.findLongestChain(Utils.stringTo2DArray("[[9,10],[-4,9],[-5,6],[-5,9],[8,9]]")) == 2;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLongestChain(int[][] pairs) {
            TreeMap<Integer, List<Integer>> pairMap = new TreeMap<>();
            Arrays.stream(pairs).forEach(pair -> {
                List<Integer> endList = pairMap.getOrDefault(pair[0], new ArrayList<>());
                endList.add(pair[1]);
                pairMap.put(pair[0], endList);
            });
            int[] dp = new int[pairs.length + 1];
            Arrays.fill(dp, -1);
            List<Integer> startList = new ArrayList<>(pairMap.keySet());
            return this.findLongestChain(pairMap, startList, startList.get(0) - 1, 1, dp);
        }

        private int findLongestChain(TreeMap<Integer, List<Integer>> pairMap, List<Integer> startList, int startNum, int startIdx, int[] dp) {
            if (startIdx > startList.size()) {
                return 0;
            }
            if (dp[startIdx] > -1) {
                return dp[startIdx];
            }
            if (startIdx == pairMap.size()) {
                if (startList.get(startList.size() - 1) > startNum) {
                    dp[startIdx] = 1;
                } else {
                    dp[startIdx] = 0;
                }
            } else {
                Integer higherKey = pairMap.higherKey(startNum);
                if (higherKey == null) {
                    dp[startIdx] = 0;
                } else {
                    for (int i = startList.indexOf(higherKey); i < startList.size(); i++) {
                        for (int higherKeyEnd : pairMap.get(higherKey)) {
                            for (int end : pairMap.get(startList.get(i))) {

                            }
                        }
//                        if (pairMap.get(higherKey) > pairMap.get(startList.get(i))) {
//                            break;
//                        }
//                        dp[startIdx] = Math.max(dp[startIdx],
//                                this.findLongestChain(pairMap, startList, pairMap.get(startList.get(i)), i + 2, dp) +
//                                1);
                    }
                }
            }
            return dp[startIdx];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}