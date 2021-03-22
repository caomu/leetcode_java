//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
//
//
//
// 参考以下这颗二叉搜索树：
//
//      5
//    / \
//   2   6
//  / \
// 1   3
//
// 示例 1：
//
// 输入: [1,6,3,2,5]
//输出: false
//
// 示例 2：
//
// 输入: [1,3,2,6,5]
//输出: true
//
//
//
// 提示：
//
//
// 数组长度 <= 1000
//
// 👍 224 👎 0


import java.util.logging.Logger;

/**
 * create time: 2021-03-22 22:31:37
 */
public class _JZ_Offer_33_ErChaSouSuoShuDeHouXuBianLiXuLieLcof {

    private static final Logger logger = Logger.getLogger(_JZ_Offer_33_ErChaSouSuoShuDeHouXuBianLiXuLieLcof.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _JZ_Offer_33_ErChaSouSuoShuDeHouXuBianLiXuLieLcof().new Solution();

//        assert solution.verifyPostorder(new int[]{1, 6, 3, 2, 5}) == false;
//        assert solution.verifyPostorder(new int[]{1, 3, 2, 6, 5}) == true;
        assert solution.verifyPostorder(new int[]{7, 4, 6, 5}) == false;
//        logger.warning(String.valueOf(solution));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean verifyPostorder(int[] postorder) {
            if (postorder.length == 0) {
                return true;
            }
            return this.verifyPostorder(postorder, 0, postorder.length - 1);
        }

        private boolean verifyPostorder(int[] postorder, int start, int end) {
            if (end == start) {
                return true;
            }
            if (postorder[start] > postorder[end]) {
                for (int i = start + 1; i <= end - 1; i++) {
                    if (postorder[i] <= postorder[end]) {
                        return false;
                    }
                }
                return this.verifyPostorder(postorder, start, end - 1);
            }
            int mid = -1;
            for (int i = start + 1; i <= end - 1; i++) {
                if (postorder[i] > postorder[end] && postorder[end] > postorder[i - 1] && mid == -1) {
                    mid = i;
                } else if (mid != -1 && postorder[i] < postorder[end]) {
                    return false;
                }
            }
            if (mid == -1) {
                return this.verifyPostorder(postorder, start, end - 1);
            } else {
                return this.verifyPostorder(postorder, start, mid - 1) &&
                       this.verifyPostorder(postorder, mid, end - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
