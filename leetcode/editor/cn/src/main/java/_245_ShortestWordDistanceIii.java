//给定一个单词列表和两个单词 word1 和 word2，返回列表中这两个单词之间的最短距离。 
//
// word1 和 word2 是有可能相同的，并且它们将分别表示为列表中两个独立的单词。 
//
// 示例: 
//假设 words = ["practice", "makes", "perfect", "coding", "makes"]. 
//
// 输入: word1 = “makes”, word2 = “coding”
//输出: 1
// 
//
// 输入: word1 = "makes", word2 = "makes"
//输出: 3
// 
//
// 注意: 
//你可以假设 word1 和 word2 都在列表里。 
// Related Topics 数组 
// 👍 25 👎 0


import java.util.ArrayList;
import java.util.List;

public class _245_ShortestWordDistanceIii {
    public static void main(String[] args) {
        Solution solution = new _245_ShortestWordDistanceIii().new Solution();
        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shortestWordDistance(String[] words, String word1, String word2) {
            List<Integer> idx1List = new ArrayList<>();
            List<Integer> idx2List = new ArrayList<>();
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(word1)) {
                    idx1List.add(i);
                }
                if (words[i].equals(word2)) {
                    idx2List.add(i);
                }
            }
            int min = Integer.MAX_VALUE;
            int i = 0;
            int j = 0;

            while (i < idx1List.size() && j < idx2List.size()) {
                int idx1 = idx1List.get(i);
                int idx2 = idx2List.get(j);
                if (idx1 == idx2) {
                    i++;
                    continue;
                }
                min = Math.min(min, Math.abs(idx1 - idx2));
                if (min == 1) {
                    return 1;
                }
                if (idx1 > idx2) {
                    j++;
                } else if (idx1 < idx2) {
                    i++;
                }
            }
            return min;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}