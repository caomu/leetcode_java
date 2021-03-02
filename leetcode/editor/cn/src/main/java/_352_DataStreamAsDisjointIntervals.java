//给定一个非负整数的数据流输入 a1，a2，…，an，…，将到目前为止看到的数字总结为不相交的区间列表。
//
// 例如，假设数据流中的整数为 1，3，7，2，6，…，每次的总结为：
//
// [1, 1]
//[1, 1], [3, 3]
//[1, 1], [3, 3], [7, 7]
//[1, 3], [7, 7]
//[1, 3], [6, 7]
//
//
//
//
// 进阶：
//如果有很多合并，并且与数据流的大小相比，不相交区间的数量很小，该怎么办?
//
// 提示：
//特别感谢 @yunhong 提供了本问题和其测试用例。
// Related Topics 二分查找 Ordered Map
// 👍 57 👎 0


import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;

public class _352_DataStreamAsDisjointIntervals {

    private static final Logger logger = Logger.getLogger(_352_DataStreamAsDisjointIntervals.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        SummaryRanges summaryRanges = new _352_DataStreamAsDisjointIntervals().new SummaryRanges();
        summaryRanges.addNum(6);
        logger.warning(Arrays.deepToString(summaryRanges.getIntervals()));
        summaryRanges.addNum(6);
        logger.warning(Arrays.deepToString(summaryRanges.getIntervals()));
        summaryRanges.addNum(0);
        logger.warning(Arrays.deepToString(summaryRanges.getIntervals()));
        summaryRanges.addNum(4);
        logger.warning(Arrays.deepToString(summaryRanges.getIntervals()));
        summaryRanges.addNum(8);
        logger.warning(Arrays.deepToString(summaryRanges.getIntervals()));
        summaryRanges.addNum(7);
        logger.warning(Arrays.deepToString(summaryRanges.getIntervals()));
        summaryRanges.addNum(6);
        logger.warning(Arrays.deepToString(summaryRanges.getIntervals()));
        summaryRanges.addNum(4);
        logger.warning(Arrays.deepToString(summaryRanges.getIntervals()));
        summaryRanges.addNum(7);
        logger.warning(Arrays.deepToString(summaryRanges.getIntervals()));
        summaryRanges.addNum(5);
        logger.warning(Arrays.deepToString(summaryRanges.getIntervals()));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class SummaryRanges {
        private final TreeMap<Integer, Integer> map;

        /**
         * Initialize your data structure here.
         */
        public SummaryRanges() {
            this.map = new TreeMap<>();
        }

        public void addNum(int val) {
            if (this.map.containsKey(val)) {
                return;
            }
            Integer floor = this.map.floorKey(val);
            if (floor != null && floor < val && val <= this.map.get(floor)) {
                return;
            }
            Integer ceiling = this.map.ceilingKey(val);
            if (floor != null && this.map.get(floor) + 1 == val) {
                if (ceiling != null && val + 1 == ceiling) {
                    this.map.put(floor, this.map.get(ceiling));
                    this.map.remove(ceiling);
                } else {
                    this.map.put(floor, val);
                }
            } else if (ceiling != null && val + 1 == ceiling) {
                this.map.put(val, this.map.get(ceiling));
                this.map.remove(ceiling);
            } else {
                this.map.put(val, val);
            }
        }

        public int[][] getIntervals() {
            int[][] intervals = new int[this.map.size()][2];
            int i = 0;
            for (Map.Entry<Integer, Integer> entry : this.map.entrySet()) {
                intervals[i][0] = entry.getKey();
                intervals[i][1] = entry.getValue();
                i++;
            }
            return intervals;
        }
    }

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
