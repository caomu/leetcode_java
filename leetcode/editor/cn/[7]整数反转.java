//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 
//
// 注意： 
//
// 
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -231 <= x <= 231 - 1 
// 
// Related Topics 数学 
// 👍 2449 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
        long res;
        if (x < 0) {
            res = Long.parseLong("-" + new StringBuilder(String.valueOf(x).substring(1)).reverse());
        } else {
            res = Long.parseLong(new StringBuilder(String.valueOf(x)).reverse().toString());
        }
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
