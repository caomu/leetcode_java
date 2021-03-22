//你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有
//版本都是错的。
//
// 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
//
// 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误
//的版本。你应该尽量减少对调用 API 的次数。
//
// 示例:
//
// 给定 n = 5，并且 version = 4 是第一个错误的版本。
//
//调用 isBadVersion(3) -> false
//调用 isBadVersion(5) -> true
//调用 isBadVersion(4) -> true
//
//所以，4 是第一个错误的版本。 
// Related Topics 二分查找
// 👍 265 👎 0


import java.util.logging.Logger;

/**
 * create time: 2021-03-21 15:43:41
 */
public class _278_FirstBadVersion {

    private static final Logger logger = Logger.getLogger(_278_FirstBadVersion.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _278_FirstBadVersion().new Solution();

        // assert solution == ;
        logger.warning(String.valueOf(solution.firstBadVersion(2147483647)));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    public class VersionControl {
        protected boolean isBadVersion(int version) {
            return version >= 2147483647;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

    public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int left = 1;
            int right = n;
            int mid;
            while (left <= right) {
                mid = left + ((right - left) >> 1);
//                System.out.println("left:" + left + "\tright:" + right + "\tmid:" + mid);
                boolean isMidBadVersion = this.isBadVersion(mid);
                if ((mid > 1 && !isMidBadVersion) || (mid == 1 && !isMidBadVersion)) {
                    left = mid + 1;
                } else if (mid > 1) {
                    // isMidBadVersion == true
                    boolean isPrevBacVersion = this.isBadVersion(mid - 1);
                    if (isPrevBacVersion) {
                        right = mid - 1;
                    } else {
                        return mid;
                    }
                } else if (mid == 1) {
                    // isMidBadVersion == true
                    return 1;
                }
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
