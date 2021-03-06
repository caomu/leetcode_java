//给你一个正整数 n ，请你找出符合条件的最小整数，其由重新排列 n 中存在的每位数字组成，并且其值大于 n 。如果不存在这样的正整数，则返回 -1 。
//
// 注意 ，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1 。
//
//
//
// 示例 1：
//
//
//输入：n = 12
//输出：21
//
//
// 示例 2：
//
//
//输入：n = 21
//输出：-1
//
//
//
//
// 提示：
//
//
// 1 <= n <= 231 - 1
//
// Related Topics 字符串
// 👍 126 👎 0


import java.util.Collections;
import java.util.LinkedList;
import java.util.logging.Logger;

public class _556_NextGreaterElementIii {

    private static final Logger logger = Logger.getLogger(_556_NextGreaterElementIii.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _556_NextGreaterElementIii().new Solution();

        assert 21 == solution.nextGreaterElement(12);
        assert -1 == solution.nextGreaterElement(21);
        assert 9312245 == solution.nextGreaterElement(9254321);
        assert -1 == solution.nextGreaterElement(11);
        assert -1 == solution.nextGreaterElement(2147483486);
        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nextGreaterElement(int n) {
            LinkedList<Byte> list = new LinkedList<>();
            int temp = n;
            LinkedList<Byte> backList = new LinkedList<>();
            byte point = -1;
            while (temp != 0) {
                byte t = (byte) (temp % 10);
                if (point == -1) {
                    if (backList.isEmpty() || backList.getLast() <= t) {
                        backList.add(t);
                    } else {
                        point = t;
                    }
                } else {
                    list.addFirst(t);
                }
                temp /= 10;
            }
            if (point == -1) {
                return -1;
            }
            for (byte i = 0; i < backList.size(); i++) {
                byte t = backList.get(i);
                if (t > point) {
                    backList.set(i, point);
                    point = t;
                    break;
                }
            }
            long nextGreaterElement = 0;
            for (byte b : list) {
                nextGreaterElement *= 10;
                nextGreaterElement += b;
            }
            nextGreaterElement *= 10;
            nextGreaterElement += point;
            Collections.sort(backList);
            for (byte b : backList) {
                nextGreaterElement *= 10;
                nextGreaterElement += b;
            }
            return nextGreaterElement > Integer.MAX_VALUE ? -1 : (int) nextGreaterElement;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
