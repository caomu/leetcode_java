//给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
//
// 示例 1:
//
// 输入: [[1,1],[2,2],[3,3]]
//输出: 3
//解释:
//^
//|
//|        o
//|     o
//|  o  
//+------------->
//0  1  2  3  4
//
//
// 示例 2:
//
// 输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
//输出: 4
//解释:
//^
//|
//|  o
//|     o        o
//|        o
//|  o        o
//+------------------->
//0  1  2  3  4  5  6
// Related Topics 哈希表 数学
// 👍 234 👎 0


import com.caomu.util.Utils;

import java.util.*;
import java.util.logging.Logger;

/**
 * create time: 2021-04-17 11:28:55
 */
public class _149_MaxPointsOnALine {

    private static final Logger logger = Logger.getLogger(_149_MaxPointsOnALine.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _149_MaxPointsOnALine().new Solution();

        assert solution.maxPoints(Utils.stringTo2DArray("[[1,1],[2,2],[3,3]]")) == 3;
        assert solution.maxPoints(Utils.stringTo2DArray("[[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]")) == 4;
        assert solution.maxPoints(Utils.stringTo2DArray("[[0,0]]")) == 1;
        assert solution.maxPoints(Utils.stringTo2DArray("[[7,3],[19,19],[-16,3],[13,17],[-18,1],[-18,-17],[13,-3]," +
                                                        "[3,7],[-11,12],[7,19],[19,-12],[20,-18],[-16,-15],[-10,-15]," +
                                                        "[-16,-18],[-14,-1],[18,10],[-13,8],[7,-5],[-4,-9],[-11,2]," +
                                                        "[-9,-9],[-5,-16],[10,14],[-3,4],[1,-20],[2,16],[0,14]," +
                                                        "[-14,5],[15,-11],[3,11],[11,-10],[-1,-7],[16,7],[1,-11]," +
                                                        "[-8,-3],[1,-6],[19,7],[3,6],[-1,-2],[7,-3],[-6,-8],[7,1]," +
                                                        "[-15,12],[-17,9],[19,-9],[1,0],[9,-10],[6,20],[-12,-4]," +
                                                        "[-16,-17],[14,3],[0,-1],[-18,9],[-15,15],[-3,-15],[-5,20]," +
                                                        "[15,-14],[9,-17],[10,-14],[-7,-11],[14,9],[1,-1],[15,12]," +
                                                        "[-5,-1],[-17,-5],[15,-2],[-12,11],[19,-18],[8,7],[-5,-3]," +
                                                        "[-17,-1],[-18,13],[15,-3],[4,18],[-14,-15],[15,8],[-18,-12]," +
                                                        "[-15,19],[-9,16],[-9,14],[-12,-14],[-2,-20],[-3,-13],[10,-7]," +
                                                        "[-2,-10],[9,10],[-1,7],[-17,-6],[-15,20],[5,-17],[6,-6]," +
                                                        "[-11,-8]]")) == 6;

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxPoints(int[][] points) {
            if (points.length == 1) {
                return 1;
            }
            int n = points.length;
            Map<Map.Entry<Double, Double>, Set<Map.Entry<Integer, Integer>>> count = new HashMap<>();
            Map<Integer, Set<Map.Entry<Integer, Integer>>> verticalCount = new HashMap<>();
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    double d = points[j][0] - points[i][0];
                    if (d == 0) {
                        Set<Map.Entry<Integer, Integer>> pointsOfLine = verticalCount.getOrDefault(points[i][0], new HashSet<>());
                        pointsOfLine.add(Map.entry(points[i][0], points[i][1]));
                        pointsOfLine.add(Map.entry(points[j][0], points[j][1]));
                        verticalCount.put(points[i][0], pointsOfLine);
                    } else {
                        double a = (double) (points[j][1] - points[i][1]) / d;
                        double b = (double) (points[i][1] * points[j][0] - points[j][1] * points[i][0]) / d;
                        Map.Entry<Double, Double> line = Map.entry(a, b);
                        Set<Map.Entry<Integer, Integer>> pointsOfLine = count.getOrDefault(line, new HashSet<>());
                        pointsOfLine.add(Map.entry(points[i][0], points[i][1]));
                        pointsOfLine.add(Map.entry(points[j][0], points[j][1]));
                        count.put(line, pointsOfLine);
                    }
                }
            }
            return Math.max(count.isEmpty() ? 0 : count.values().stream().max(Comparator.comparingInt(Set::size)).get().size(),
                    verticalCount.isEmpty() ? 0 : verticalCount.values().stream().max(Comparator.comparingInt(Set::size)).get().size());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
