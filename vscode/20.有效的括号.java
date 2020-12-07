/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.size() == 0 || stack.peek() != '(') {
                        return false;
                    }
                    stack.pop();
                    break;
                case ']':
                    if (stack.size() == 0 || stack.peek() != '[') {
                        return false;
                    }
                    stack.pop();
                    break;
                case '}':
                    if (stack.size() == 0 || stack.peek() != '{') {
                        return false;
                    }
                    stack.pop();
                    break;
                default:
                    break;
            }
        }
        if (stack.size() > 0) {
            return false;
        }
        return true;
    }
}
// @lc code=end
