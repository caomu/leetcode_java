//给定一个字符串，对该字符串可以进行 “移位” 的操作，也就是将字符串中每个字母都变为其在字母表中后续的字母，比如："abc" -> "bcd"。这样，我们可
//以持续进行 “移位” 操作，从而生成如下移位序列：
//
// "abc" -> "bcd" -> ... -> "xyz"
//
// 给定一个包含仅小写字母字符串的列表，将该列表中所有满足 “移位” 操作规律的组合进行分组并返回。
//
//
//
// 示例：
//
// 输入：["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"]
//输出：
//[
//  ["abc","bcd","xyz"],
//  ["az","ba"],
//  ["acef"],
//  ["a","z"]
//]
//解释：可以认为字母表首尾相接，所以 'z' 的后续为 'a'，所以 ["az","ba"] 也满足 “移位” 操作规律。
// Related Topics 哈希表 字符串
// 👍 42 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * create time: 2021-03-07 23:02:00
 */
public class _249_GroupShiftedStrings {

    private static final Logger logger = Logger.getLogger(_249_GroupShiftedStrings.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _249_GroupShiftedStrings().new Solution();

        logger.warning(String.valueOf(solution.groupStrings(new String[]{
                "abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"})));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupStrings(String[] strings) {
            Map<List<Integer>, List<String>> map = new HashMap<>();
            for (String string : strings) {
                List<Integer> key = new ArrayList<>(string.length() - 1);
                for (int i = 1; i < string.length(); i++) {
                    int p = string.charAt(i - 1);
                    int q = string.charAt(i);
                    key.add(q - p + (p > q ? 26 : 0));
                }
                List<String> value = map.getOrDefault(key, new ArrayList<>());
                value.add(string);
                map.put(key, value);
            }
            return new ArrayList<>(map.values());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
