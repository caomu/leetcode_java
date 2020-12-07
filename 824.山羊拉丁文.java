/*
 * @lc app=leetcode.cn id=824 lang=java
 *
 * [824] 山羊拉丁文
 */

// @lc code=start
class Solution {
    public String toGoatLatin(String S) {
        String[] arr = S.split(" ");
        String res = "";
        for (int i = 0; i < arr.length; i++) {
            char f = arr[i].charAt(0);
            if (f == 'a' || f == 'A' || f == 'e' || f == 'E' || f == 'i' || f == 'I' || f == 'o' || f == 'O' || f == 'u'
                    || f == 'U') {
                res += arr[i];
            } else {
                res += (arr[i].substring(1) + f);
            }
            res += "ma";
            for (int j = 0; j < i + 1; j++) {
                res += "a";
            }
            if (i < arr.length - 1) {
                res += " ";
            }
        }
        return res;
    }
}
// @lc code=end
