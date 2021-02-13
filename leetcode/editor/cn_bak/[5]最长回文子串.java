//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3130 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        String longestPalindrome = "";
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                String palindrome = this.palindrome(i, i + 1, s, longestPalindrome);
                if (palindrome.length() > longestPalindrome.length()) {
                    longestPalindrome = palindrome;
                }
            }
            String palindrome = this.palindrome(i, i, s, longestPalindrome);
            if (palindrome.length() > longestPalindrome.length()) {
                longestPalindrome = palindrome;
            }
        }
        return longestPalindrome;
    }

    private String palindrome(int p, int q, String s, String longestPalindrome) {
        while (p > -1 && q < s.length()) {
            if (p == 0 || q == s.length() - 1) {
                if (q - p - 3 > longestPalindrome.length()) {
                    longestPalindrome = s.substring(p, q - 1);
                }
            }
            if (s.charAt(p) != s.charAt(q)) {
                if (p == 0 || q == s.length() - 1) {
                    longestPalindrome = s.substring(p + 1, q);
//                    System.out.println("p:" + p + ",q:" + q + "\t" + longestPalindrome);
                }
                break;
            }
            p--;
            q++;
        }
        return longestPalindrome;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
