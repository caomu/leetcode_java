//假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
//
// 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。
//
// 示例 1:
//
// 输入:
//["Shogun", "Tapioca Express", "Burger King", "KFC"]
//["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
//输出: ["Shogun"]
//解释: 他们唯一共同喜爱的餐厅是“Shogun”。
//
//
// 示例 2:
//
// 输入:
//["Shogun", "Tapioca Express", "Burger King", "KFC"]
//["KFC", "Shogun", "Burger King"]
//输出: ["Shogun"]
//解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
//
//
// 提示:
//
//
// 两个列表的长度范围都在 [1, 1000]内。
// 两个列表中的字符串的长度将在[1，30]的范围内。
// 下标从0开始，到列表的长度减1。
// 两个列表都没有重复的元素。
//
// Related Topics 哈希表
// 👍 102 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class _599_MinimumIndexSumOfTwoLists {

    private static final Logger logger = Logger.getLogger(_599_MinimumIndexSumOfTwoLists.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _599_MinimumIndexSumOfTwoLists().new Solution();

        // assert solution == ;
        logger.warning(String.valueOf(solution));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] findRestaurant(String[] list1, String[] list2) {
            Map<String, Integer> list1Map = new HashMap<>();
            for (int i = 0; i < list1.length; i++) {
                list1Map.put(list1[i], i);
            }
            int minIndex = Integer.MAX_VALUE;
            Map<Integer, List<String>> indexSumMap = new HashMap<>();
            for (int i = 0; i < list2.length; i++) {
                if (list1Map.containsKey(list2[i])) {
                    int indexSum = i + list1Map.get(list2[i]);
                    minIndex = Math.min(minIndex, indexSum);
                    List<String> indexSumList = indexSumMap.getOrDefault(indexSum, new ArrayList<>());
                    indexSumList.add(list2[i]);
                    indexSumMap.put(indexSum, indexSumList);
                }
            }
            return indexSumMap.get(minIndex).toArray(new String[0]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
