//给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。 
//
// 
//
// 示例：
//输入：S = "a1b2"
//输出：["a1b2", "a1B2", "A1b2", "A1B2"]
//
//输入：S = "3z4"
//输出：["3z4", "3Z4"]
//
//输入：S = "12345"
//输出：["12345"]
// 
//
// 
//
// 提示： 
//
// 
// S 的长度不超过12。 
// S 仅由数字和字母组成。 
// 
// Related Topics 位运算 回溯算法 
// 👍 245 👎 0


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class _784_LetterCasePermutation {
    public static void main(String[] args) {
        Solution solution = new _784_LetterCasePermutation().new Solution();
        System.out.println(solution.letterCasePermutation("FKqeaCFIESzo"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> letterCasePermutation(String S) {
            List<StringBuilder> letterCasePermutation = new ArrayList<>();
            letterCasePermutation.add(new StringBuilder());
            for (char c : S.toLowerCase().toCharArray()) {
                if (Character.isLetter(c)) {
                    int size = letterCasePermutation.size();
                    for (int i = 0; i < size; i++) {
                        letterCasePermutation.add(new StringBuilder(letterCasePermutation.get(i)).append(c));
                        letterCasePermutation.get(i).append(Character.toUpperCase(c));
                    }
                } else {
                    letterCasePermutation.forEach(sb -> sb.append(c));
                }
            }
            return letterCasePermutation.stream().map(StringBuilder::toString).collect(Collectors.toList());
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}