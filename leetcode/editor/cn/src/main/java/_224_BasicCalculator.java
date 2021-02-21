//实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "1 + 1"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：s = " 2-1 + 2 "
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：s = "(1+(4+5+2)-3)+(6+8)"
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 105 
// s 由数字、'+'、'-'、'('、')'、和 ' ' 组成 
// s 表示一个有效的表达式 
// 
// Related Topics 栈 数学 
// 👍 349 👎 0


import java.util.ArrayDeque;
import java.util.Deque;

public class _224_BasicCalculator {
    public static void main(String[] args) {
        Solution solution = new _224_BasicCalculator().new Solution();
        System.out.println(solution.calculate("- (3 + (4 + 5))"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int calculate(String s) {
            Deque<String> stack = new ArrayDeque<>();
            StringBuilder number = new StringBuilder();
            boolean positive = true;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == ' ') {
                    continue;
                }
                if (c >= '0' && c <= '9') {
                    number.append(c);
                } else {
                    if (number.length() > 0) {
                        if (positive) {
                            stack.offer(number.toString());
                        } else {
                            stack.offer(number.insert(0, '-').toString());
                        }
                        number = new StringBuilder();
                    }
                    if (c == '+') {
                        positive = true;
                    } else if (c == '-') {
                        positive = false;
                    } else if (c == '(') {
                        if (positive) {
                            stack.offer(String.valueOf(c));
                        } else {
                            stack.offer("-" + c);
                        }
                        positive = true;
                    } else if (c == ')') {
                        String last = stack.pollLast();
                        int sum = 0;
                        while (!last.equals("(") && !last.equals("-(")) {
                            sum += Integer.valueOf(last);
                            last = stack.pollLast();
                        }
                        if (last.equals("-(")) {
                            stack.offer(String.valueOf(-sum));
                        } else {
                            stack.offer(String.valueOf(sum));
                        }
                    }
                }
            }
            if (number.length() > 0) {
                if (positive) {
                    stack.offer(number.toString());
                } else {
                    stack.offer(number.insert(0, '-').toString());
                }
            }
            return stack.stream().mapToInt(Integer::valueOf).sum();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}