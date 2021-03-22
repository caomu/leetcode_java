//已有方法 rand7 可生成 1 到 7 范围内的均匀随机整数，试写一个方法 rand10 生成 1 到 10 范围内的均匀随机整数。
//
// 不要使用系统的 Math.random() 方法。
//
//
//
//
//
//
// 示例 1:
//
//
//输入: 1
//输出: [7]
//
//
// 示例 2:
//
//
//输入: 2
//输出: [8,4]
//
//
// 示例 3:
//
//
//输入: 3
//输出: [8,1,10]
//
//
//
//
// 提示:
//
//
// rand7 已定义。
// 传入参数: n 表示 rand10 的调用次数。
//
//
//
//
// 进阶:
//
//
// rand7()调用次数的 期望值 是多少 ?
// 你能否尽量少调用 rand7() ?
//
// Related Topics Random Rejection Sampling
// 👍 169 👎 0


import java.util.Arrays;
import java.util.Random;
import java.util.logging.Logger;

/**
 * create time: 2021-03-21 21:25:59
 */
public class _470_ImplementRand10UsingRand7 {

    private static final Logger logger = Logger.getLogger(_470_ImplementRand10UsingRand7.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _470_ImplementRand10UsingRand7().new Solution();
        int[] result7 = new int[7];
        int[] result10 = new int[10];
        for (int i = 0; i < 100; i++) {
            result7[solution.rand7() - 1]++;
            result10[solution.rand10() - 1]++;
        }
        logger.warning(Arrays.toString(result7));
        logger.warning(Arrays.toString(result10));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    public class SolBase {
        Random r = new Random();

        public int rand7() {
            return this.r.nextInt(7) + 1;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * The rand7() API is already defined in the parent class SolBase.
     * public int rand7();
     *
     * @return a random integer in the range 1 to 7
     */
    class Solution extends SolBase {
        public int rand10() {
            int result;
            while (true) {
                result = this.rand7() + this.rand7() * 7 - 7;
                if (result <= 40) {
                    return 1 + (result - 1) % 10;
                } else {
                    result += this.rand7() * 7 - 47;
                    if (result <= 60) {
                        return 1 + (result - 1) % 10;
                    } else {
                        result += this.rand7() * 7 - 67;
                        if (result <= 20) {
                            return 1 + (result - 1) % 10;
                        }
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
