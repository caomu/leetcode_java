//猜数字游戏的规则如下：
//
//
// 每轮游戏，我都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。
// 如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。
//
//
// 你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1 或 0）：
//
//
// -1：我选出的数字比你猜的数字小 pick < num
// 1：我选出的数字比你猜的数字大 pick > num
// 0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num
//
//
// 返回我选出的数字。
//
//
//
// 示例 1：
//
//
//输入：n = 10, pick = 6
//输出：6
//
//
// 示例 2：
//
//
//输入：n = 1, pick = 1
//输出：1
//
//
// 示例 3：
//
//
//输入：n = 2, pick = 1
//输出：1
//
//
// 示例 4：
//
//
//输入：n = 2, pick = 2
//输出：2
//
//
//
//
// 提示：
//
//
// 1 <= n <= 231 - 1
// 1 <= pick <= n
//
// Related Topics 二分查找
// 👍 115 👎 0


import java.util.logging.Logger;

/**
 * create time: 2021-04-17 17:14:55
 */
public class _374_GuessNumberHigherOrLower {

    private static final Logger logger = Logger.getLogger(_374_GuessNumberHigherOrLower.class.toString());
    static int pick;

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _374_GuessNumberHigherOrLower().new Solution();
        pick = 1702766719;
        assert solution.guessNumber(2126753390) == pick;
        pick = 1;
        assert solution.guessNumber(1) == pick;
        pick = 3;
        assert solution.guessNumber(3) == pick;

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    private class GuessGame {
        int guess(int num) {
            return -Integer.compare(num, pick);
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Forward declaration of guess API.
     *
     * @param num your guess
     * @return -1 if num is lower than the guess number
     * 1 if num is higher than the guess number
     * otherwise return 0
     * int guess(int num);
     */

    public class Solution extends GuessGame {
        public int guessNumber(int n) {
            int left = 1;
            int right = n;
            int mid;
            while (left <= right) {
                mid = left + ((right - left) >> 1);
                int guess = this.guess(mid);
                if (guess == -1) {
                    right = mid - 1;
                } else if (guess == 1) {
                    left = mid + 1;
                } else {
                    return mid;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
