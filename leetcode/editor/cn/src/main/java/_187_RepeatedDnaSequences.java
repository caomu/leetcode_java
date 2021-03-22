//所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复
//序列有时会对研究非常有帮助。
//
// 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
//
//
//
// 示例 1：
//
//
//输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
//输出：["AAAAACCCCC","CCCCCAAAAA"]
//
//
// 示例 2：
//
//
//输入：s = "AAAAAAAAAAAAA"
//输出：["AAAAAAAAAA"]
//
//
//
//
// 提示：
//
//
// 0 <= s.length <= 105
// s[i] 为 'A'、'C'、'G' 或 'T'
//
// Related Topics 位运算 哈希表
// 👍 150 👎 0


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

/**
 * create time: 2021-03-21 23:06:47
 */
public class _187_RepeatedDnaSequences {

    private static final Logger logger = Logger.getLogger(_187_RepeatedDnaSequences.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _187_RepeatedDnaSequences().new Solution();

        // assert solution == ;
//        logger.warning(String.valueOf(solution.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT")));
//        logger.warning(String.valueOf(solution.findRepeatedDnaSequences("AAAAAAAAAAAAA")));
        logger.warning(String.valueOf(solution.findRepeatedDnaSequences("AAAAAAAAAAA")));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            if (s.length() < 11) {
                return new ArrayList<>();
            }
            Set<String> repeatedDnaSequences = new HashSet<>();
            Set<String> seenSet = new HashSet<>();
            for (int i = 0; i < s.length() - 9; i++) {
                String seen = s.substring(i, i + 10);
                if (seenSet.contains(seen)) {
                    repeatedDnaSequences.add(seen);
                } else {
                    seenSet.add(seen);
                }
            }
            return new ArrayList<>(repeatedDnaSequences);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
