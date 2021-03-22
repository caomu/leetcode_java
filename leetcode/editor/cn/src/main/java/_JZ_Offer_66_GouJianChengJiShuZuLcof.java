//给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[
//i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
//
//
//
// 示例:
//
//
//输入: [1,2,3,4,5]
//输出: [120,60,40,30,24]
//
//
//
// 提示：
//
//
// 所有元素乘积之和不会溢出 32 位整数
// a.length <= 100000
//
// 👍 96 👎 0


import java.util.Arrays;
import java.util.logging.Logger;

/**
 * create time: 2021-03-22 23:11:51
 */
public class _JZ_Offer_66_GouJianChengJiShuZuLcof {

    private static final Logger logger = Logger.getLogger(_JZ_Offer_66_GouJianChengJiShuZuLcof.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _JZ_Offer_66_GouJianChengJiShuZuLcof().new Solution();

//         assert solution == ;
        logger.warning(Arrays.toString(solution.constructArr(new int[]{1, 2, 3, 4, 5})));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] constructArr(int[] a) {
            if (a.length == 0) {
                return new int[0];
            } else if (a.length == 1) {
                return new int[]{0};
            }
            int[] prefixMultiple = new int[a.length];
            prefixMultiple[0] = a[0];
            for (int i = 1; i < a.length; i++) {
                prefixMultiple[i] = a[i] * prefixMultiple[i - 1];
            }
            int[] suffixMultiple = new int[a.length];
            suffixMultiple[a.length - 1] = a[a.length - 1];
            for (int i = a.length - 2; i >= 0; i--) {
                suffixMultiple[i] = a[i] * suffixMultiple[i + 1];
            }
            int[] constructArr = new int[a.length];
            for (int i = 1; i < a.length - 1; i++) {
                constructArr[i] = prefixMultiple[i - 1] * suffixMultiple[i + 1];
            }
            constructArr[0] = suffixMultiple[1];
            constructArr[a.length - 1] = prefixMultiple[a.length - 2];
            return constructArr;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
