//给定一个字符串，判断该字符串中是否可以通过重新排列组合，形成一个回文字符串。 
//
// 示例 1： 
//
// 输入: "code"
//输出: false 
//
// 示例 2： 
//
// 输入: "aab"
//输出: true 
//
// 示例 3： 
//
// 输入: "carerac"
//输出: true 
// Related Topics 哈希表 
// 👍 34 👎 0


import java.util.HashMap;
import java.util.Map;

public class _266_PalindromePermutation {
    public static void main(String[] args) {
        Solution solution = new _266_PalindromePermutation().new Solution();
        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPermutePalindrome(String s) {
            Map<Integer, Integer> charFrequency = new HashMap<>();
            s.chars().forEach(c -> charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1));
            return charFrequency.values().stream().filter(f -> (f & 1) == 1).count() < 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}