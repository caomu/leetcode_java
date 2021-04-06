//给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 *
// 。
//
// 示例 1:
//
// 输入: "2-1-1"
//输出: [0, 2]
//解释:
//((2-1)-1) = 0
//(2-(1-1)) = 2
//
// 示例 2:
//
// 输入: "2*3-4*5"
//输出: [-34, -14, -10, -10, 10]
//解释:
//(2*(3-(4*5))) = -34
//((2*3)-(4*5)) = -14
//((2*(3-4))*5) = -10
//(2*((3-4)*5)) = -10
//(((2*3)-4)*5) = 10
// Related Topics 分治算法
// 👍 346 👎 0


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

/**
 * create time: 2021-03-23 21:51:53
 */
public class _241_DifferentWaysToAddParentheses {

    private static final Logger logger = Logger.getLogger(_241_DifferentWaysToAddParentheses.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _241_DifferentWaysToAddParentheses().new Solution();

        // assert solution == ;
        logger.warning(String.valueOf(solution.diffWaysToCompute("2-1-1")));
        logger.warning(String.valueOf(solution.diffWaysToCompute("2*3-4*5")));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> diffWaysToCompute(String expression) {
            List<String> expressionArray = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < expression.length(); i++) {
                char c = expression.charAt(i);
                if (c == '+' || c == '-' || c == '*') {
                    expressionArray.add(sb.toString());
                    sb.setLength(0);
                    expressionArray.add(String.valueOf(c));
                } else {
                    sb.append(c);
                }
            }
            expressionArray.add(sb.toString());
            return this.diffWaysToCompute(expressionArray, 0, expressionArray.size() - 1);
        }

        private List<Integer> diffWaysToCompute(List<String> expressionArray, int start, int end) {
            if (start == end) {
                return Collections.singletonList(Integer.parseInt(expressionArray.get(start)));
            }
            List<Integer> result = new ArrayList<>();
            for (int i = start + 1; i < end; i = i + 2) {
                List<Integer> leftResult = this.diffWaysToCompute(expressionArray, start, i - 1);
                List<Integer> rightResult = this.diffWaysToCompute(expressionArray, i + 1, end);
                for (Integer left : leftResult) {
                    for (Integer right : rightResult) {
                        switch (expressionArray.get(i)) {
                            case "+" -> result.add(left + right);
                            case "-" -> result.add(left - right);
                            case "*" -> result.add(left * right);
                        }
                    }
                }
            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
