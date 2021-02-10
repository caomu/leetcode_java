//给定一个长度为 n 的整数数组 A 。 
//
// 假设 Bk 是数组 A 顺时针旋转 k 个位置后的数组，我们定义 A 的“旋转函数” F 为： 
//
// F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1]。 
//
// 计算F(0), F(1), ..., F(n-1)中的最大值。 
//
// 注意: 
//可以认为 n 的值小于 105。 
//
// 示例: 
//
// 
//A = [4, 3, 2, 6]
//
//F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
//F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
//F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
//F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
//
//所以 F(0), F(1), F(2), F(3) 中的最大值是 F(3) = 26 。
// 
// Related Topics 数学 
// 👍 65 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * F(k) = 0 * A[0] + 1 * A[1] + ... + (n-1) * A[n-1]
     * F(k+1) = 0 * A[n-1] + 1 * A[0] + 2 * A[1] + ... + (n-1) * A[n-2]
     * F(k+1) - F(k) = -(n-1) * A[n-1] + 1 * A[0] + 1 * A[1] + ... + 1 * A[n-2]
     * F(k+1) = F(k) - n * A[n-1] + 所有数的和
     * F(k+i) = F(k+i-1) - n * A[n-i] + 所有数的和
     *
     * @param A
     * @return
     */
    public int maxRotateFunction(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        return this.calcI(A, A.length - 1, Arrays.stream(A).sum(), Integer.MIN_VALUE)[1];
    }

    private int[] calcI(int[] A, int i, int sum, int max) {
        if (i == 0) {
            int result = 0;
            for (int j = 1; j < A.length; j++) {
                result += j * A[j];
            }
//            System.out.println("i:" + i + ",result:" + result + ",max:" + Math.max(result, max));
            return new int[]{result, Math.max(result, max)};
        }
        int[] result = this.calcI(A, i - 1, sum, max);
        result[0] = result[0] - A.length * A[A.length - i] + sum;
        result[1] = Math.max(result[0], result[1]);
//        System.out.println("i:" + i + ",result:" + result[0] + ",max:" + result[1]);
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
