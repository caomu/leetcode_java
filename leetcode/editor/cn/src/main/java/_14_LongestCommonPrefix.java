//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 0 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 1459 👎 0


public class _14_LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new _14_LongestCommonPrefix().new Solution();
        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            loop:
            while (true) {
                Character c = null;
                for (String s : strs) {
                    if (s.length() <= i) {
                        break loop;
                    }
                    if (c == null) {
                        c = s.charAt(i);
                    } else if (c != s.charAt(i)) {
                        break loop;
                    }
                }
                sb.append(c);
                i++;
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}