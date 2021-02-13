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
        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int calculate(String s) {
            Deque<String> stack = new ArrayDeque<>();
            String number = new String();
            int result = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c >= '0' && c <= '9') {
                    number += c;
                } else {
                    stack.add(number);
                    number = new String();
                    stack.add(String.valueOf(c));
                }
            }
            stack.add(number);
            Deque<String> stack1 = new ArrayDeque<>();
            int right = 0;
            while (!stack.isEmpty()) {
                String s3 = stack.pop();
                if (s.equals('+')) {
                    String s1 = stack.pop();
                } else if (s.equals('-')) {
                    String s1 = stack.pop();
                } else if (s.equals('*')) {
                    String s1 = stack.pop();
                    right *= Integer.parseInt(s1);
                } else if (s.equals('/')) {
                    String s1 = stack.pop();
                    right = Integer.parseInt(s1) / right;
                } else {
                    right = Integer.parseInt(s);
                }
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}