//给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。 
//
// 如果小数部分为循环小数，则将循环的部分括在括号内。 
//
// 如果存在多个答案，只需返回 任意一个 。 
//
// 对于所有给定的输入，保证 答案字符串的长度小于 104 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numerator = 1, denominator = 2
//输出："0.5"
// 
//
// 示例 2： 
//
// 
//输入：numerator = 2, denominator = 1
//输出："2"
// 
//
// 示例 3： 
//
// 
//输入：numerator = 2, denominator = 3
//输出："0.(6)"
// 
//
// 示例 4： 
//
// 
//输入：numerator = 4, denominator = 333
//输出："0.(012)"
// 
//
// 示例 5： 
//
// 
//输入：numerator = 1, denominator = 5
//输出："0.2"
// 
//
// 
//
// 提示： 
//
// 
// -231 <= numerator, denominator <= 231 - 1 
// denominator != 0 
// 
// Related Topics 哈希表 数学 
// 👍 205 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class _166_FractionToRecurringDecimal {
    public static void main(String[] args) {
        Solution solution = new _166_FractionToRecurringDecimal().new Solution();
        System.out.println(solution.fractionToDecimal(-1, -2147483648));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String fractionToDecimal(int numerator, int denominator) {
            StringBuilder sb = new StringBuilder();
            Long n = (long) numerator;
            Long d = (long) denominator;
            if (numerator < 0 && denominator > 0) {
                sb.append('-');
                n = -n;
            } else if (numerator > 0 && denominator < 0) {
                sb.append('-');
                d = -d;
            } else if (numerator < 0 && denominator < 0) {
                n = -n;
                d = -d;
            }

            sb.append(n / d);
            long mod = n % d;
            if (mod == 0) {
                return sb.toString();
            }
            sb.append('.');
            Map<Map.Entry<Integer, Long>, Integer> map = new HashMap<>();
            List<Integer> list = new ArrayList<>();
            int idx = 0;
            do {
                long newMod = ((mod * 10) % d);
                Map.Entry<Integer, Long> entry = Map.entry((int) (mod * 10 / d), newMod);

                //----------------------
                if (map.containsKey(entry)) {
                    int idx1 = map.get(entry);
                    IntStream.range(0, idx1).forEach(i -> sb.append(list.get(i)));
                    sb.append('(');
                    IntStream.range(idx1, list.size()).forEach(i -> sb.append(list.get(i)));
                    sb.append(')');
                    return sb.toString();
                }
                //----------------------
                map.put(entry, idx++);
                list.add(entry.getKey());
                mod = newMod;
            } while (mod != 0);
            IntStream.range(0, list.size()).forEach(i -> sb.append(list.get(i)));
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}