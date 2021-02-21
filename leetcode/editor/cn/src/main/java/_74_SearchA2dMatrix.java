//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -104 <= matrix[i][j], target <= 104 
// 
// Related Topics 数组 二分查找 
// 👍 318 👎 0


import com.caomu.util.Utils;

public class _74_SearchA2dMatrix {
    public static void main(String[] args) {
        Solution solution = new _74_SearchA2dMatrix().new Solution();
        System.out.println(solution.searchMatrix(Utils.stringTo2DArray("[[1,3,5,7],[10,11,16,20],[23,30,34,60]]"), 13));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            return this.searchMatrix(matrix, target, 0, 0);
        }

        private boolean searchMatrix(int[][] matrix, int target, int i, int j) {
            // check if can end
            if (matrix[i][j] == target) {
                return true;
            }
            // dig into next depth
            if (j < matrix[0].length - 1 && matrix[i][j] < target) {
                return this.searchMatrix(matrix, target, i, j + 1);
            } else if ((matrix[i][j] > target || j == matrix[0].length - 1) && i < matrix.length - 1 &&
                       matrix[i + 1][0] <= target) {
                return this.searchMatrix(matrix, target, i + 1, 0);
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}