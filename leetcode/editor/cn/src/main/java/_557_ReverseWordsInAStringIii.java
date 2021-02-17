//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 
//
// 示例： 
//
// 输入："Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
// 
//
// 
//
// 提示： 
//
// 
// 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。 
// 
// Related Topics 字符串 
// 👍 271 👎 0


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _557_ReverseWordsInAStringIii {
    public static void main(String[] args) {
        Solution solution = new _557_ReverseWordsInAStringIii().new Solution();
        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            List<String> reversed = Arrays.stream(s.split(" ")).map(str -> {
                StringBuilder sb = new StringBuilder();
                for (int i = str.length() - 1; i >= 0; i--) {
                    sb.append(str.charAt(i));
                }
                return sb.toString();
            }).collect(Collectors.toList());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < reversed.size(); i++) {
                sb.append(reversed.get(i));
                if (i < reversed.size() - 1) {
                    sb.append(' ');
                }
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}