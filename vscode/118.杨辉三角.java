import java.util.List;
import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=118 lang=java
 *
 * [118] 杨辉三角
 */

// @lc code=start
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> rowRes = new ArrayList<>(i);
            rowRes.add(1);
            if (i > 2) {
                List<Integer> preRow = res.get(i - 2);
                for (int j = 1; j < i - 1; j++) {
                    rowRes.add(preRow.get(j - 1) + preRow.get(j));
                }
            }
            if (i > 1) {
                rowRes.add(1);
            }
            res.add(rowRes);
        }
        return res;
    }
}
// @lc code=end
