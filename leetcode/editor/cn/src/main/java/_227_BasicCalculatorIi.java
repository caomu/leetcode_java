//实现一个基本的计算器来计算一个简单的字符串表达式的值。
//
// 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格 。 整数除法仅保留整数部分。 
//
// 示例 1: 
//
// 输入: "3+2*2"
//输出: 7
// 
//
// 示例 2: 
//
// 输入: " 3/2 "
//输出: 1 
//
// 示例 3: 
//
// 输入: " 3+5 / 2 "
//输出: 5
// 
//
// 说明： 
//
// 
// 你可以假设所给定的表达式都是有效的。 
// 请不要使用内置的库函数 eval。 
// 
// Related Topics 栈 字符串 
// 👍 249 👎 0


import java.util.ArrayDeque;
import java.util.Deque;

public class _227_BasicCalculatorIi {
    public static void main(String[] args) {
        Solution solution = new _227_BasicCalculatorIi().new Solution();
        System.out.println(solution.calculate(" 3 + 2* 33  /11 "));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int calculate(String s) {
            Deque<Integer> stack = new ArrayDeque<>();
            StringBuilder number = new StringBuilder();
            char operator = '+';
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == ' ') {
                    continue;
                }
                if (c >= '0' && c <= '9') {
                    number.append(c);
                } else {
                    switch (operator) {
                        case '+' -> stack.offer(Integer.parseInt(number.toString()));
                        case '-' -> stack.offer(-Integer.parseInt(number.toString()));
                        case '*' -> stack.offer(stack.pollLast() * Integer.parseInt(number.toString()));
                        case '/' -> stack.offer(stack.pollLast() / Integer.parseInt(number.toString()));
                    }
                    operator = c;
                    number = new StringBuilder();
                }
            }
            switch (operator) {
                case '+' -> stack.offer(Integer.parseInt(number.toString()));
                case '-' -> stack.offer(-Integer.parseInt(number.toString()));
                case '*' -> stack.offer(stack.pollLast() * Integer.parseInt(number.toString()));
                case '/' -> stack.offer(stack.pollLast() / Integer.parseInt(number.toString()));
            }

            return stack.stream().mapToInt(Integer::intValue).sum();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}