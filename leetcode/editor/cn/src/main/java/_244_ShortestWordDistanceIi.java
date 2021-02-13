//请设计一个类，使该类的构造函数能够接收一个单词列表。然后再实现一个方法，该方法能够分别接收两个单词 word1 和 word2，并返回列表中这两个单词之间的
//最短距离。您的方法将被以不同的参数调用 多次。 
//
// 示例: 
//假设 words = ["practice", "makes", "perfect", "coding", "makes"] 
//
// 输入: word1 = “coding”, word2 = “practice”
//输出: 3
// 
//
// 输入: word1 = "makes", word2 = "coding"
//输出: 1 
//
// 注意: 
//你可以假设 word1 不等于 word2, 并且 word1 和 word2 都在列表里。 
// Related Topics 设计 哈希表 
// 👍 35 👎 0


import com.caomu.util.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _244_ShortestWordDistanceIi {
    public static void main(String[] args) {
        WordDistance wordDistance = new _244_ShortestWordDistanceIi().new WordDistance(Utils.stringToStringArray(""));
        System.out.println(wordDistance);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class WordDistance {

        private Map<String, List<Integer>> wordIndexMap;

        public WordDistance(String[] words) {
            this.wordIndexMap = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                List<Integer> wordIndex = this.wordIndexMap.getOrDefault(word, new ArrayList<>());
                wordIndex.add(i);
                this.wordIndexMap.put(word, wordIndex);
            }
        }

        public int shortest(String word1, String word2) {
            List<Integer> idx1List = this.wordIndexMap.get(word1);
            List<Integer> idx2List = this.wordIndexMap.get(word2);
            int min = Integer.MAX_VALUE;
            int i = 0;
            int j = 0;

            while (i < idx1List.size() && j < idx2List.size()) {
                int idx1 = idx1List.get(i);
                int idx2 = idx2List.get(j);
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

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
//leetcode submit region end(Prohibit modification and deletion)

}