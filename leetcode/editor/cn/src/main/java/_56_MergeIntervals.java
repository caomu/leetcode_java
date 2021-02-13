//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 104 
// 
// Related Topics 排序 数组 
// 👍 798 👎 0


import java.util.Arrays;
import java.util.Comparator;

public class _56_MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new _56_MergeIntervals().new Solution();
        System.out.println(solution);
    }


    //leetcode submit region begin(Prohibit modification and deletion)


    class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals.length == 0) {
                return new int[0][0];
            }
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
            int[][] merge = new int[intervals.length][2];

            int idx = 0;
            merge[0][0] = intervals[0][0];
            merge[0][1] = intervals[0][1];
            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i][0] <= merge[idx][1]) {
                    merge[idx][1] = Math.max(intervals[i][1], merge[idx][1]);
                } else {
                    idx++;
                    merge[idx][0] = intervals[i][0];
                    merge[idx][1] = intervals[i][1];
                }
            }
            return Arrays.copyOfRange(merge, 0, idx + 1);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}