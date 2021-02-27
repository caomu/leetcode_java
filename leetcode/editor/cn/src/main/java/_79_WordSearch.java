//给定一个二维网格和一个单词，找出该单词是否存在于网格中。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例: 
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true
//给定 word = "SEE", 返回 true
//给定 word = "ABCB", 返回 false 
//
// 
//
// 提示： 
//
// 
// board 和 word 中只包含大写和小写英文字母。 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 1 <= word.length <= 10^3 
// 
// Related Topics 数组 回溯算法 
// 👍 794 👎 0


import java.util.logging.Logger;

public class _79_WordSearch {

    private static final Logger logger = Logger.getLogger(_79_WordSearch.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _79_WordSearch().new Solution();

        assert solution.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}}, "ABCCED") == true;
//        logger.warning(String.valueOf(solution.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'}}, "ABCCED")));
        assert solution.exist(new char[][]{{'a'}}, "a") == true;
//        logger.warning(String.valueOf(solution.exist(new char[][]{{'a'}}, "a")));
        assert solution.exist(new char[][]{{'a', 'a'}}, "aaa") == false;
        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] deltas = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        public boolean exist(char[][] board, String word) {
            char[] wordArray = word.toCharArray();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (this.exist(board, wordArray, 0, i, j, new boolean[board.length][board[0].length])) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean exist(char[][] board, char[] wordArray, int wordPosition, int i, int j, boolean[][] visited) {
            if (board[i][j] != wordArray[wordPosition]) {
                return false;
            }
            if (wordPosition == wordArray.length - 1) {
                return true;
            }
            visited[i][j] = true;
            boolean exist = false;
            for (int[] delta : this.deltas) {
                int nextI = i + delta[0];
                int nextJ = j + delta[1];
                if (nextI < 0 || nextI == board.length || nextJ < 0 || nextJ == board[0].length ||
                    visited[nextI][nextJ]) {
                    continue;
                }
                if (this.exist(board, wordArray, wordPosition + 1, nextI, nextJ, visited)) {
                    exist = true;
                    break;
                }
            }
            visited[i][j] = false;
            return exist;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
