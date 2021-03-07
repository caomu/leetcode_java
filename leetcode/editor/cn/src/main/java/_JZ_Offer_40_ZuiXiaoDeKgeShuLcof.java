//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
//
//
//
// 示例 1：
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
//
//
// 示例 2：
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0]
//
//
//
// 限制：
//
//
// 0 <= k <= arr.length <= 10000
// 0 <= arr[i] <= 10000
//
// Related Topics 堆 分治算法
// 👍 205 👎 0


import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.logging.Logger;

public class _JZ_Offer_40_ZuiXiaoDeKgeShuLcof {

    private static final Logger logger = Logger.getLogger(_JZ_Offer_40_ZuiXiaoDeKgeShuLcof.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _JZ_Offer_40_ZuiXiaoDeKgeShuLcof().new Solution();

        // assert solution == ;
        logger.warning(String.valueOf(solution));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
            Arrays.stream(arr).forEach(priorityQueue::offer);
            int[] leastNumbers = new int[k];
            for (int i = 0; i < k; i++) {
                leastNumbers[i] = priorityQueue.poll();
            }
            return leastNumbers;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
