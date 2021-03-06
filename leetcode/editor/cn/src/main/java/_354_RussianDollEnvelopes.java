//给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
//
// 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
//
// 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
//
// 注意：不允许旋转信封。
//
//
// 示例 1：
//
//
//输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
//输出：3
//解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
//
// 示例 2：
//
//
//输入：envelopes = [[1,1],[1,1],[1,1]]
//输出：1
//
//
//
//
// 提示：
//
//
// 1 <= envelopes.length <= 5000
// envelopes[i].length == 2
// 1 <= wi, hi <= 104
//
// Related Topics 二分查找 动态规划
// 👍 423 👎 0


import com.caomu.util.Utils;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.logging.Logger;

public class _354_RussianDollEnvelopes {

    private static final Logger logger = Logger.getLogger(_354_RussianDollEnvelopes.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _354_RussianDollEnvelopes().new Solution();

        assert solution.maxEnvelopes(Utils.stringTo2DArray("[[5,4],[6,4],[6,7],[2,3]]")) == 3;
        assert solution.maxEnvelopes(Utils.stringTo2DArray("[[1,1],[1,1],[1,1]]")) == 1;

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            Arrays.sort(envelopes, (o1, o2) ->
                    o1[0] == o2[0] ? Integer.compare(o2[1], o1[1]) : Integer.compare(o1[0], o2[0]));
            TreeMap<Integer, Integer> dp = new TreeMap<>();//key;末尾元素的最小值, value:前 i 个元素可以组成的最长长度
            int max = 0;
            for (int[] envelope : envelopes) {
                int height = envelope[1];
                Integer ceilingKey = dp.ceilingKey(height);
                if (ceilingKey == null) {
                    Integer lowerKey = dp.lowerKey(height);
                    if (lowerKey == null) {
                        dp.put(height, 1);
                        max = Math.max(max, 1);
                    } else {
                        int len = dp.get(lowerKey) + 1;
                        dp.put(height, len);
                        max = Math.max(max, len);
                    }
                } else {
                    int len = dp.get(ceilingKey);
                    dp.remove(ceilingKey);
                    dp.put(height, len);
                    max = Math.max(max, len);
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
