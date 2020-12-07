
/*
 * @lc app=leetcode.cn id=1491 lang=java
 *
 * [1491] 去掉最低工资和最高工资后的工资平均值
 */

// @lc code=start
import java.math.BigDecimal;
import java.math.RoundingMode;

class Solution {
    public double average(int[] salary) {
        int max = Integer.MIN_VALUE;
        int max_i = -1;
        int min = Integer.MAX_VALUE;
        int min_i = -1;
        BigDecimal sum = BigDecimal.ZERO;
        for (int i = 0; i < salary.length; i++) {
            int s = salary[i];
            if (s > max) {
                max = s;
                max_i = i;
            }
            if (s < min) {
                min = s;
                min_i = i;
            }
        }
        for (int i = 0; i < salary.length; i++) {
            if (i != max_i && i != min_i) {
                sum = sum.add(BigDecimal.valueOf((long) salary[i]));
            }
        }
        return sum.divide(BigDecimal.valueOf(salary.length - 2), 5, RoundingMode.DOWN).doubleValue();

    }
}
// @lc code=end
