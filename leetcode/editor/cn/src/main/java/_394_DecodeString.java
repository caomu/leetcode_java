//给定一个经过编码的字符串，返回它解码后的字符串。
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
//
// 
//
// 示例 1： 
//
// 输入：s = "3[a]2[bc]"
//输出："aaabcbc"
// 
//
// 示例 2： 
//
// 输入：s = "3[a2[c]]"
//输出："accaccacc"
// 
//
// 示例 3： 
//
// 输入：s = "2[abc]3[cd]ef"
//输出："abcabccdcdcdef"
// 
//
// 示例 4： 
//
// 输入：s = "abc3[cd]xyz"
//输出："abccdcdcdxyz"
// 
// Related Topics 栈 深度优先搜索 
// 👍 654 👎 0


import java.util.Deque;
import java.util.LinkedList;

public class _394_DecodeString {
    public static void main(String[] args) {
        Solution solution = new _394_DecodeString().new Solution();
        System.out.println(solution.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String decodeString(String s) {
            int bracketsCnt = 0;
            StringBuilder number = new StringBuilder();
            Deque<Integer> numberStack = new LinkedList<>();
            StringBuilder alphabet = new StringBuilder();
            Deque<StringBuilder> alphabetStack = new LinkedList<>();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c >= '0' && c <= '9') {
                    number.append(c);
                } else if (c >= 'a' && c <= 'z') {
                    if (number.length() == 0 && bracketsCnt == 0 && numberStack.isEmpty()) {
                        sb.append(c);
                    } else {
                        alphabet.append(c);
                    }
                } else if (c == '[') {
                    bracketsCnt++;
                    numberStack.push(Integer.parseInt(number.toString()));
                    if (alphabet.length() > 0) {
                        alphabetStack.push(alphabet);
                        alphabet = new StringBuilder();
                    }
                    number = new StringBuilder();
                } else if (c == ']') {
                    alphabet.append(String.valueOf(alphabet).repeat(Math.max(0, numberStack.pop() - 1)));
                    bracketsCnt--;
                    if (!alphabetStack.isEmpty() && alphabetStack.size() == bracketsCnt) {
                        alphabet = alphabetStack.pop().append(alphabet);
                    }
                    if (bracketsCnt == 0 && numberStack.isEmpty()) {
                        sb.append(alphabet);
                        alphabet = new StringBuilder();
                    }
                }
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}