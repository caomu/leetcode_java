//对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。 
//
// 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：A = [1,2,0,0], K = 34
//输出：[1,2,3,4]
//解释：1200 + 34 = 1234
// 
//
// 示例 2： 
//
// 输入：A = [2,7,4], K = 181
//输出：[4,5,5]
//解释：274 + 181 = 455
// 
//
// 示例 3： 
//
// 输入：A = [2,1,5], K = 806
//输出：[1,0,2,1]
//解释：215 + 806 = 1021
// 
//
// 示例 4： 
//
// 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
//输出：[1,0,0,0,0,0,0,0,0,0,0]
//解释：9999999999 + 1 = 10000000000
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 10000 
// 0 <= A[i] <= 9 
// 0 <= K <= 10000 
// 如果 A.length > 1，那么 A[0] != 0 
// 
// Related Topics 数组 
// 👍 84 👎 0


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        int kk = K;

        List<Integer> kList = new ArrayList<>();
        while (kk != 0) {
            kList.add(kk % 10);
            kk /= 10;
        }
//        System.out.println(klist);
        List<Integer> res = new ArrayList<>();
        boolean up = false;
        int resL = Math.max(kList.size(), A.length);
        for (int i = 0; i < resL; i++) {
            int a = i < A.length ? A[A.length - i - 1] : 0;
            int b = i < kList.size() ? kList.get(i) : 0;
            int c = a + b + (up ? 1 : 0);
            if (c >= 10) {
                c %= 10;
                up = true;
            } else {
                up = false;
            }
            res.add(c);
//            System.out.println("a:" + a + "\tb:" + b + "\tc:" + c + res);
        }
        if (up) {
            res.add(1);
        }
        Collections.reverse(res);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
