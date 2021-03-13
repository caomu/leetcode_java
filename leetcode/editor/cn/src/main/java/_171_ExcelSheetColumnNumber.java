//给定一个Excel表格中的列名称，返回其相应的列序号。
//
// 例如，
//
//     A -> 1
//    B -> 2
//    C -> 3
//    ...
//    Z -> 26
//    AA -> 27
//    AB -> 28
//    ...
//
//
// 示例 1:
//
// 输入: "A"
//输出: 1
//
//
// 示例 2:
//
// 输入: "AB"
//输出: 28
//
//
// 示例 3:
//
// 输入: "ZY"
//输出: 701
//
// 致谢：
//特别感谢 @ts 添加此问题并创建所有测试用例。
// Related Topics 数学
// 👍 208 👎 0


import java.util.logging.Logger;

/**
 * create time: 2021-03-13 20:58:41
 */
public class _171_ExcelSheetColumnNumber {

    private static final Logger logger = Logger.getLogger(_171_ExcelSheetColumnNumber.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _171_ExcelSheetColumnNumber().new Solution();

        assert solution.titleToNumber("A") == 1;
        assert solution.titleToNumber("AB") == 28;
        assert solution.titleToNumber("ZY") == 701;
        assert solution.titleToNumber("FXSHRXW") == 2147483647;
//        logger.warning(String.valueOf(solution));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int titleToNumber(String columnTitle) {
            int n = 0;
            for (int i = columnTitle.length() - 1; i >= 0; i--) {
                n += (columnTitle.charAt(i) - 'A' + 1) * Math.pow(26, columnTitle.length() - i - 1);
            }
            return n;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
