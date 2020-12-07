/*
 * @lc app=leetcode.cn id=929 lang=java
 *
 * [929] 独特的电子邮件地址
 */

// @lc code=start
import java.util.Set;
import java.util.HashSet;

class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> res = new HashSet<>();
        for (String email : emails) {
            // System.out.println(email.indexOf("@", 0));
            String[] emailSplit = email.split("@");
            String name = emailSplit[0];
            // System.out.println(name);
            if (name.indexOf("+", 0) > 0) {
                name = name.substring(0, name.indexOf("+", 0));
            }
            name = name.replaceAll("\\.", "");
            // System.out.println(name);
            res.add(name + "@" + emailSplit[1]);
        }
        return res.size();
    }
}
// @lc code=end
