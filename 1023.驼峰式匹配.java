
/*
 * @lc app=leetcode.cn id=1023 lang=java
 *
 * [1023] 驼峰式匹配
 */

// @lc code=start
import java.util.Arrays;

class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        String regex = "(?=[A-Z])";
        System.out.println(Arrays.toString(pattern.split("(?=[A-Z])")));
        String[] patternArray = pattern.split(regex);
        List<Boolean> res = new ArrayList<>();

        loop: for (String query : queries) {
            String[] qArray = query.split(regex);
            System.out.println(Arrays.toString(qArray));
            if (qArray.length != patternArray.length) {
                res.add(false);
                continue loop;
            }
            for (int i = 0; i < qArray.length; i++) {
                if (!qArray[i].startsWith(patternArray[i].substring(0, 1))) {
                    res.add(false);
                    continue loop;
                }
                String q = qArray[i].substring(1);
                for (int j = 1; j < patternArray[i].length(); j++) {
                    int index = q.indexOf(patternArray[i].substring(j, j + 1));
                    if (index < 0) {
                        res.add(false);
                        continue loop;
                    }
                    q = q.substring(index + 1);
                }
            }
            res.add(true);
        }

        return res;
    }
}
// @lc code=end
