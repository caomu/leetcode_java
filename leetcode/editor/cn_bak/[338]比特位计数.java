//给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。 
//
// 示例 1: 
//
// 输入: 2
//输出: [0,1,1] 
//
// 示例 2: 
//
// 输入: 5
//输出: [0,1,1,2,1,2] 
//
// 进阶: 
//
// 
// 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？ 
// 要求算法的空间复杂度为O(n)。 
// 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。 
// 
// Related Topics 位运算 动态规划 
// 👍 478 👎 0


import java.util.stream.IntStream;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        IntStream.range(1, num + 1).forEach(i -> this.bit(res, i));
        return res;
    }

    /**
     * 把数组的第n位放上答案
     *
     * @param res
     * @param n
     * @return　第n位的答案
     */
    private int bit(int[] res, int n) {
        // 递归的终止条件
        if (0 != res[n] || 0 == n) {
            return res[n];
        }

        // 处理当前层逻辑

        // 下探到下一层
        res[n] = this.bit(res, n & (n - 1)) + 1;
        return res[n];
        // 清理当前层

    }
}
//leetcode submit region end(Prohibit modification and deletion)
