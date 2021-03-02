//中位数是有序序列最中间的那个数。如果序列的长度是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。 
//
// 例如： 
//
// 
// [2,3,4]，中位数是 3 
// [2,3]，中位数是 (2 + 3) / 2 = 2.5 
// 
//
// 给你一个数组 nums，有一个长度为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口向右移动 1 位。你的任务是找出每次窗口移动后得到的新窗
//口中元素的中位数，并输出由它们组成的数组。 
//
// 
//
// 示例： 
//
// 给出 nums = [1,3,-1,-3,5,3,6,7]，以及 k = 3。 
//
// 
//窗口位置                      中位数
//---------------               -----
//[1  3  -1] -3  5  3  6  7       1
// 1 [3  -1  -3] 5  3  6  7      -1
// 1  3 [-1  -3  5] 3  6  7      -1
// 1  3  -1 [-3  5  3] 6  7       3
// 1  3  -1  -3 [5  3  6] 7       5
// 1  3  -1  -3  5 [3  6  7]      6
// 
//
// 因此，返回该滑动窗口的中位数数组 [1,-1,-1,3,5,6]。 
//
// 
//
// 提示： 
//
// 
// 你可以假设 k 始终有效，即：k 始终小于等于输入的非空数组的元素个数。 
// 与真实值误差在 10 ^ -5 以内的答案将被视作正确答案。 
// 
// Related Topics Sliding Window 
// 👍 262 👎 0


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.logging.Logger;

public class _480_SlidingWindowMedian {

    private static final Logger logger = Logger.getLogger(_480_SlidingWindowMedian.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _480_SlidingWindowMedian().new Solution();

        // assert solution == ;
//        logger.warning(Arrays.toString(solution.medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
//        logger.warning(Arrays.toString(solution.medianSlidingWindow(new int[]{1, 2}, 1)));
//        logger.warning(Arrays.toString(solution.medianSlidingWindow(new int[]{2147483647, 2147483647}, 2)));
        logger.warning(Arrays.toString(solution.medianSlidingWindow(new int[]{2147483647, 1, 2, 3, 4, 5, 6, 7, 2147483647}, 2)));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double[] medianSlidingWindow(int[] nums, int k) {
            Integer median = null;
            PriorityQueue<Integer> bigQueue = new PriorityQueue<>();
            PriorityQueue<Integer> smallQueue = new PriorityQueue<>(Comparator.reverseOrder());
            double[] medianArray = new double[nums.length - k + 1];
            for (int i = 0; i < k; i++) {
                smallQueue.add(nums[i]);
            }
            for (int i = 0; i < k / 2; i++) {
                bigQueue.add(smallQueue.poll());
            }
            if ((k & 1) == 1) {
                median = smallQueue.poll();
            }
            medianArray[0] =
                    median == null ? ((double) smallQueue.peek() / 2 + (double) bigQueue.peek() / 2) : median;
            for (int i = k; i < nums.length; i++) {
                if (median == null) {
                    if (nums[i - k] >= bigQueue.peek()) {
                        bigQueue.remove(nums[i - k]);
                        if (nums[i] >= smallQueue.peek()) {
                            bigQueue.add(nums[i]);
                        } else {
                            smallQueue.add(nums[i]);
                            bigQueue.add(smallQueue.poll());
                        }
                    } else {
                        smallQueue.remove(nums[i - k]);
                        if (nums[i] <= bigQueue.peek()) {
                            smallQueue.add(nums[i]);
                        } else {
                            bigQueue.add(nums[i]);
                            smallQueue.add(bigQueue.poll());
                        }
                    }
                    medianArray[i - k + 1] = (double) smallQueue.peek() / 2 + (double) bigQueue.peek() / 2;
                } else {
                    if (nums[i - k] == median) {
                        median = smallQueue.poll(); // small.size<big.size
                        if (median == null) {
                            median = nums[i];
                        } else if (nums[i] <= median) {
                            smallQueue.add(nums[i]);
                        } else {
                            bigQueue.add(nums[i]);
                            smallQueue.add(median);
                            median = bigQueue.poll();
                        }
                    } else if (nums[i - k] >= bigQueue.peek()) {
                        bigQueue.remove(nums[i - k]);// big.size<small.size
                        if (nums[i] >= median) {
                            bigQueue.add(nums[i]);
                        } else {
                            smallQueue.add(nums[i]);
                            bigQueue.add(median);
                            median = smallQueue.poll();
                        }
                    } else {
                        smallQueue.remove(nums[i - k]);// small.size<big.size
                        if (nums[i] <= median) {
                            smallQueue.add(nums[i]);
                        } else {
                            bigQueue.add(nums[i]);
                            smallQueue.add(median);
                            median = bigQueue.poll();
                        }
                    }
                    medianArray[i - k + 1] = median;
                }
            }
            return medianArray;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
