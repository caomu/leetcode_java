//设计一个接收整数流的数据结构，该数据结构支持检查是否存在两数之和等于特定值。
//
// 实现 TwoSum 类：
//
//
// TwoSum() 使用空数组初始化 TwoSum 对象
// void add(int number) 向数据结构添加一个数 number
// boolean find(int value) 寻找数据结构中是否存在一对整数，使得两数之和与给定的值相等。如果存在，返回 true ；否则，返回 fal
//se 。
//
//
//
//
// 示例：
//
//
//输入：
//["TwoSum", "add", "add", "add", "find", "find"]
//[[], [1], [3], [5], [4], [7]]
//输出：
//[null, null, null, null, true, false]
//
//解释：
//TwoSum twoSum = new TwoSum();
//twoSum.add(1);   // [] --> [1]
//twoSum.add(3);   // [1] --> [1,3]
//twoSum.add(5);   // [1,3] --> [1,3,5]
//twoSum.find(4);  // 1 + 3 = 4，返回 true
//twoSum.find(7);  // 没有两个整数加起来等于 7 ，返回 false
//
//
//
// 提示：
//
//
// -105 <= number <= 105
// -231 <= value <= 231 - 1
// 最多调用 5 * 104 次 add 和 find
//
// Related Topics 设计 哈希表
// 👍 40 👎 0


import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * create time: 2021-03-07 17:37:55
 */
public class _170_TwoSumIiiDataStructureDesign {

    private static final Logger logger = Logger.getLogger(_170_TwoSumIiiDataStructureDesign.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        TwoSum twoSum = new _170_TwoSumIiiDataStructureDesign().new TwoSum();

        twoSum.add(3);
        twoSum.add(2);
        twoSum.add(1);
        logger.warning(String.valueOf(twoSum.find(2)));
        logger.warning(String.valueOf(twoSum.find(3)));
        logger.warning(String.valueOf(twoSum.find(4)));
        logger.warning(String.valueOf(twoSum.find(5)));
        logger.warning(String.valueOf(twoSum.find(6)));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class TwoSum {
        private final Map<Integer, Integer> numberFrequency;

        /**
         * Initialize your data structure here.
         */
        public TwoSum() {
            this.numberFrequency = new HashMap<>();
        }

        /**
         * Add the number to an internal data structure..
         */
        public void add(int number) {
            this.numberFrequency.put(number, this.numberFrequency.getOrDefault(number, 0) + 1);
        }

        /**
         * Find if there exists any pair of numbers which sum is equal to the value.
         */
        public boolean find(int value) {
            for (Map.Entry<Integer, Integer> entry : this.numberFrequency.entrySet()) {
                if (this.numberFrequency.containsKey(value - entry.getKey()) &&
                    (entry.getKey() * 2 != value || (entry.getKey() * 2 == value && entry.getValue() > 1))) {
                    return true;
                }
            }
            return false;
        }
    }

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
