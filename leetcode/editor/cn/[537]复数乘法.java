//给定两个表示复数的字符串。 
//
// 返回表示它们乘积的字符串。注意，根据定义 i2 = -1 。 
//
// 示例 1: 
//
// 
//输入: "1+1i", "1+1i"
//输出: "0+2i"
//解释: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i ，你需要将它转换为 0+2i 的形式。
// 
//
// 示例 2: 
//
// 
//输入: "1+-1i", "1+-1i"
//输出: "0+-2i"
//解释: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i ，你需要将它转换为 0+-2i 的形式。 
// 
//
// 注意: 
//
// 
// 输入字符串不包含额外的空格。 
// 输入字符串将以 a+bi 的形式给出，其中整数 a 和 b 的范围均在 [-100, 100] 之间。输出也应当符合这种形式。 
// 
// Related Topics 数学 字符串 
// 👍 51 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String complexNumberMultiply(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int[] r1 = this.splitString(a);
        int[] r2 = this.splitString(b);
        return sb.append(r1[0] * r2[0] - r1[1] * r2[1]).append('+').append(
                r1[0] * r2[1] + r1[1] * r2[0]).append('i').toString();
    }

    private int[] splitString(String s) {
        int[] res = new int[2];
        int plusIdx = s.indexOf('+');
//        System.out.println("a:" + s.substring(0, plusIdx) + "\tb:" + s.substring(plusIdx + 1, s.length() - 1));
        res[0] = Integer.parseInt(s.substring(0, plusIdx));
        res[1] = Integer.parseInt(s.substring(plusIdx + 1, s.length() - 1));
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
