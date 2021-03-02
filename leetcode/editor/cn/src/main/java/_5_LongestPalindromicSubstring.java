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
// 👍 3255 👎 0


import java.util.logging.Logger;

public class _5_LongestPalindromicSubstring {

    private static final Logger logger = Logger.getLogger(_5_LongestPalindromicSubstring.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _5_LongestPalindromicSubstring().new Solution();

        // assert solution == ;
        String s = "cyyoacmjwjubfkzrrbvquqkwhsxvmytmjvbborrtoiyotobzjmohpadfrvmxuagbdczsjuekjrmcwyaovpiogspbslcppxojgbfxhtsxmecgqjfuvahzpgprscjwwutwoiksegfreortttdotgxbfkisyakejihfjnrdngkwjxeituomuhmeiesctywhryqtjimwjadhhymydlsmcpycfdzrjhstxddvoqprrjufvihjcsoseltpyuaywgiocfodtylluuikkqkbrdxgjhrqiselmwnpdzdmpsvbfimnoulayqgdiavdgeiilayrafxlgxxtoqskmtixhbyjikfmsmxwribfzeffccczwdwukubopsoxliagenzwkbiveiajfirzvngverrbcwqmryvckvhpiioccmaqoxgmbwenyeyhzhliusupmrgmrcvwmdnniipvztmtklihobbekkgeopgwipihadswbqhzyxqsdgekazdtnamwzbitwfwezhhqznipalmomanbyezapgpxtjhudlcsfqondoiojkqadacnhcgwkhaxmttfebqelkjfigglxjfqegxpcawhpihrxydprdgavxjygfhgpcylpvsfcizkfbqzdnmxdgsjcekvrhesykldgptbeasktkasyuevtxrcrxmiylrlclocldmiwhuizhuaiophykxskufgjbmcmzpogpmyerzovzhqusxzrjcwgsdpcienkizutedcwrmowwolekockvyukyvmeidhjvbkoortjbemevrsquwnjoaikhbkycvvcscyamffbjyvkqkyeavtlkxyrrnsmqohyyqxzgtjdavgwpsgpjhqzttukynonbnnkuqfxgaatpilrrxhcqhfyyextrvqzktcrtrsbimuokxqtsbfkrgoiznhiysfhzspkpvrhtewthpbafmzgchqpgfsuiddjkhnwchpleibavgmuivfiorpteflholmnxdwewj";
        System.out.println(s.indexOf("xrcrx"));//667
        System.out.println(s.indexOf("wew"));//996
        logger.warning(String.valueOf(solution.longestPalindrome(s)));
//        logger.warning(String.valueOf(solution.longestPalindrome("232wewfffxrcrx123")));

//        logger.warning(String.valueOf(solution.longestPalindrome("babad")));
        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            char[] chars = s.toCharArray();
            int p = 0;
            int q = 0;
            for (int i = 0; i < chars.length; i++) {
                int j = i;
                int k = i + 1;
                while (j >= 0 && k < chars.length && chars[j] == chars[k]) {
                    j--;
                    k++;
                }
                if (j >= -1 && k <= chars.length && k - j - 2 > q - p) {
                    p = j + 1;
                    q = k - 1;
                }
                j = i;
                k = i;
                while (j >= 0 && k < chars.length && chars[j] == chars[k]) {
                    j--;
                    k++;
                }
                if (j >= -1 && k <= chars.length && k - j - 2 > q - p) {
                    p = j + 1;
                    q = k - 1;
                }
            }
            return s.substring(p, q + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
