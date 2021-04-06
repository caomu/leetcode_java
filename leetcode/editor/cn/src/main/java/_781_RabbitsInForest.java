//森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。我们将这些回答放在 answers 数组里。
//
// 返回森林中兔子的最少数量。
//
//
//示例:
//输入: answers = [1, 1, 2]
//输出: 5
//解释:
//两只回答了 "1" 的兔子可能有相同的颜色，设为红色。
//之后回答了 "2" 的兔子不会是红色，否则他们的回答会相互矛盾。
//设回答了 "2" 的兔子为蓝色。
//此外，森林中还应有另外 2 只蓝色兔子的回答没有包含在数组中。
//因此森林中兔子的最少数量是 5: 3 只回答的和 2 只没有回答的。
//
//输入: answers = [10, 10, 10]
//输出: 11
//
//输入: answers = []
//输出: 0
//
//
// 说明:
//
//
// answers 的长度最大为1000。
// answers[i] 是在 [0, 999] 范围内的整数。
//
// Related Topics 哈希表 数学
// 👍 135 👎 0


import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * create time: 2021-04-04 22:56:01
 */
public class _781_RabbitsInForest {

    private static final Logger logger = Logger.getLogger(_781_RabbitsInForest.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _781_RabbitsInForest().new Solution();

//        assert solution.numRabbits(new int[]{1, 1, 2}) == 5;
//        assert solution.numRabbits(new int[]{10, 10, 10}) == 11;
//        assert solution.numRabbits(new int[]{}) == 0;
        assert solution.numRabbits(new int[]{1, 1, 1, 2}) == 7;
//        logger.warning(String.valueOf(solution.numRabbits(new int[]{1, 1, 2})));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numRabbits(int[] answers) {
            Map<Integer, Integer> hashMap = new HashMap<>();
            for (int answer : answers) {
                hashMap.put(answer + 1, hashMap.getOrDefault(answer + 1, 0) + 1);
            }
            int num = 0;
            for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
                num += entry.getKey() * (entry.getValue() > entry.getKey() ? Math.ceil(
                        (float) entry.getValue() / (float) entry.getKey()) : 1);
            }
            return num;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
