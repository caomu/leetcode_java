//给定一个 n × n 的二维矩阵表示一个图像。 
//
// 将图像顺时针旋转 90 度。 
//
// 说明： 
//
// 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。 
//
// 示例 1: 
//
// 给定 matrix = 
//[
//  [1,2,3],
//  [4,5,6],
//  [7,8,9]
//],
//
//原地旋转输入矩阵，使其变为:
//[
//  [7,4,1],
//  [8,5,2],
//  [9,6,3]
//]
// 
//
// 示例 2: 
//
// 给定 matrix =
//[
//  [ 5, 1, 9,11],
//  [ 2, 4, 8,10],
//  [13, 3, 6, 7],
//  [15,14,12,16]
//], 
//
//原地旋转输入矩阵，使其变为:
//[
//  [15,13, 2, 5],
//  [14, 3, 4, 1],
//  [12, 6, 8, 9],
//  [16, 7,10,11]
//]
// 
// Related Topics 数组 
// 👍 752 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n <= 1) {
            return;
        }
//        for (int[] line : matrix) {
//            System.out.println(Arrays.toString(line));
//        }
        boolean even = (n & 1) == 0;
        int l = even ? n / 2 : (n / 2 + 1);
//        System.out.println("even:" + even + "\tl:" + l);
        for (int i = 0; i < (l - (even ? 0 : 1)); i++) {
            for (int j = 0; j < l; j++) {
                int t = matrix[i][j];
//                System.out.println("i:" + i + "\tj:" + j);
                int x = 2 * (l - (even ? 0 : 1)) - j - (even ? 1 : 0);
                int y = 2 * (l - (even ? 0 : 1)) - i - (even ? 1 : 0);
                matrix[i][j] = matrix[x][i];
                matrix[x][i] = matrix[y][x];
                matrix[y][x] = matrix[j][y];
                matrix[j][y] = t;
//                for (int[] line : matrix) {
//                    System.out.println(Arrays.toString(line));
//                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
