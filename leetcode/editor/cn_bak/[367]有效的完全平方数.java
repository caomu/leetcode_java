//给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。 
//
// 说明：不要使用任何内置的库函数，如 sqrt。 
//
// 示例 1： 
//
// 输入：16
//输出：True 
//
// 示例 2： 
//
// 输入：14
//输出：False
// 
// Related Topics 数学 二分查找 
// 👍 189 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        int maxSqrt = (int) Math.sqrt(Integer.MAX_VALUE);
        int low = 0, high = Math.min(num / 2, maxSqrt);
        while (low <= high) {
            int middle = (low + high) >> 1;
            int s = middle * middle;
            if (s > num) {
                high--;
            } else if (s == num) {
                return true;

            } else {
                low++;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
