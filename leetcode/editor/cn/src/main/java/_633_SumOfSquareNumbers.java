//给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。 
//
// 
//
// 示例 1： 
//
// 输入：c = 5
//输出：true
//解释：1 * 1 + 2 * 2 = 5
// 
//
// 示例 2： 
//
// 输入：c = 3
//输出：false
// 
//
// 示例 3： 
//
// 输入：c = 4
//输出：true
// 
//
// 示例 4： 
//
// 输入：c = 2
//输出：true
// 
//
// 示例 5： 
//
// 输入：c = 1
//输出：true 
//
// 
//
// 提示： 
//
// 
// 0 <= c <= 231 - 1 
// 
// Related Topics 数学 
// 👍 164 👎 0


import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _633_SumOfSquareNumbers {
    public static void main(String[] args) {
        Solution solution = new _633_SumOfSquareNumbers().new Solution();
        System.out.println(solution.judgeSquareSum(1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean judgeSquareSum(int c) {
            Set<Integer> set = IntStream.rangeClosed(0, 46340).mapToObj(i -> (int) Math.pow(i, 2)).collect(Collectors.toSet());
            for (int i = (int) Math.sqrt(0.5 * c); i < (int) Math.sqrt(c) + 1; i++) {
                if (set.contains(c - (int) Math.pow(i, 2))) {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}