//你的面前有一堵矩形的、由 n 行砖块组成的砖墙。这些砖块高度相同（也就是一个单位高）但是宽度不同。每一行砖块的宽度之和应该相等。
//
// 你现在要画一条 自顶向下 的、穿过 最少 砖块的垂线。如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。你不能沿着墙的两个垂直边缘之一画线，这样显然是没
//有穿过一块砖的。
//
// 给你一个二维数组 wall ，该数组包含这堵墙的相关信息。其中，wall[i] 是一个代表从左至右每块砖的宽度的数组。你需要找出怎样画才能使这条线 穿过的
//砖块数量最少 ，并且返回 穿过的砖块数量 。
//
//
//
// 示例 1：
//
//
//输入：wall = [[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]
//输出：2
//
//
// 示例 2：
//
//
//输入：wall = [[1],[1],[1]]
//输出：3
//
//
//
// 提示：
//
//
// n == wall.length
// 1 <= n <= 104
// 1 <= wall[i].length <= 104
// 1 <= sum(wall[i].length) <= 2 * 104
// 对于每一行 i ，sum(wall[i]) 应当是相同的
// 1 <= wall[i][j] <= 231 - 1
//
// Related Topics 哈希表
// 👍 197 👎 0


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.sql.Timestamp;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * create time: 2021-05-02 21:50:07
 */
public class _554_BrickWall {

    private static final Logger logger = Logger.getLogger(_554_BrickWall.class.toString());
    private static final long START_TIMESTAMP = Timestamp.valueOf("2021-05-02 21:50:07").getTime();

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _554_BrickWall().new Solution();
        List<List<Integer>> wall = JSON.parseObject("[[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]",
                new TypeReference<>() {
                });
        assert solution.leastBricks(wall) == 2;

        wall = JSON.parseObject("[[1],[1],[1]]",
                new TypeReference<>() {
                });
        assert solution.leastBricks(wall) == 3;

        wall = JSON.parseObject("[[100000000],[100000000],[100000000]]",
                new TypeReference<>() {
                });
        assert solution.leastBricks(wall) == 3;

        logger.log(Level.INFO, "time cost: [{0}] ms", (System.currentTimeMillis() - startTimeMillis));
        logger.log(Level.INFO, "solution cost: [{0}]", Duration.ofSeconds(
                (System.currentTimeMillis() - START_TIMESTAMP) / 1000));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int leastBricks(List<List<Integer>> wall) {
            List<Set<Integer>> wallSet = new ArrayList<>();
            Set<Integer> cracks = new HashSet<>();
            var brickIndex = 0;
            for (List<Integer> layer : wall) {
                brickIndex = layer.get(0);
                Set<Integer> brickSet = new HashSet<>();
                brickSet.add(brickIndex);
                for (var i = 1; i < layer.size() - 1; i++) {
                    brickIndex += layer.get(i);
                    brickSet.add(brickIndex);
                }
                cracks.addAll(brickSet);
                wallSet.add(brickSet);
            }
            var max = 0;
            for (var i : cracks) {
                if (i == brickIndex) {
                    continue;
                }
                var nonCrossed = 0;
                for (var j = 0; j < wall.size(); j++) {
                    if (wallSet.get(j).contains(i)) {
                        nonCrossed++;
                    }
                }
                max = Math.max(max, nonCrossed);
            }
            return wall.size() - max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
