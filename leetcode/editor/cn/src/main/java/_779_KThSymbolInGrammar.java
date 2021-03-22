//在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
//
// 给定行数 N 和序数 K，返回第 N 行中第 K个字符。（K从1开始）
//
//
//例子:
//
// 输入: N = 1, K = 1
//输出: 0
//
//输入: N = 2, K = 1
//输出: 0
//
//输入: N = 2, K = 2
//输出: 1
//
//输入: N = 4, K = 5
//输出: 1
//
//解释:
//第一行: 0
//第二行: 01
//第三行: 0110
//第四行: 01101001
//
//
//
//注意：
//
//
// N 的范围 [1, 30].
// K 的范围 [1, 2^(N-1)].
//
// Related Topics 递归
// 👍 117 👎 0


import java.util.logging.Logger;

/**
 * create time: 2021-03-19 23:37:48
 */
public class _779_KThSymbolInGrammar {

    private static final Logger logger = Logger.getLogger(_779_KThSymbolInGrammar.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _779_KThSymbolInGrammar().new Solution();

        assert solution.kthGrammar(1, 1) == 0;
        assert solution.kthGrammar(2, 1) == 0;
        assert solution.kthGrammar(2, 2) == 1;
        assert solution.kthGrammar(3, 1) == 0;
        assert solution.kthGrammar(3, 2) == 1;
        assert solution.kthGrammar(3, 3) == 1;
        assert solution.kthGrammar(3, 4) == 0;
        assert solution.kthGrammar(4, 1) == 0;
        assert solution.kthGrammar(4, 2) == 1;
        assert solution.kthGrammar(4, 3) == 1;
        assert solution.kthGrammar(4, 4) == 0;
        assert solution.kthGrammar(4, 5) == 1;
        assert solution.kthGrammar(4, 6) == 0;
        assert solution.kthGrammar(4, 7) == 0;
        assert solution.kthGrammar(4, 8) == 1;
//        logger.warning(String.valueOf(solution.kthGrammar(3, 2)));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int kthGrammar(int N, int K) {
            if (N == 1) {
                return 0;
            }
            int prev = this.kthGrammar(N - 1, (K + 1) / 2);
            boolean isEven = (K & 1) == 0;
            if ((prev == 0 && !isEven) || (prev == 1 && isEven)) {
                return 0;
            } else {
                return 1;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
