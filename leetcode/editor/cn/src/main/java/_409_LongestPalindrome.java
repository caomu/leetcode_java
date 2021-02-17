//给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。 
//
// 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。 
//
// 注意: 
//假设字符串的长度不会超过 1010。 
//
// 示例 1: 
//
// 
//输入:
//"abccccdd"
//
//输出:
//7
//
//解释:
//我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
// 
// Related Topics 哈希表 
// 👍 270 👎 0


import java.util.HashMap;
import java.util.Map;

public class _409_LongestPalindrome {
    public static void main(String[] args) {
        Solution solution = new _409_LongestPalindrome().new Solution();
        System.out.println(solution.longestPalindrome("abccccdd"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestPalindrome(String s) {
            Map<Integer, Integer> charFrequency = new HashMap<>();
            s.chars().forEach(c -> charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1));
            int sum = 0;
            boolean hasOdd = false;
            for (Integer v : charFrequency.values()) {
                if ((v & 1) == 0) {
                    sum += v;
                } else {
                    hasOdd = true;
                    sum += v > 2 ? (v - 1) : 0;
                }
            }
            return hasOdd ? sum + 1 : sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}