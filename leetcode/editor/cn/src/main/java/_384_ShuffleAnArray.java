//给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。 
//
// 实现 Solution class: 
//
// 
// Solution(int[] nums) 使用整数数组 nums 初始化对象 
// int[] reset() 重设数组到它的初始状态并返回 
// int[] shuffle() 返回数组随机打乱后的结果 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["Solution", "shuffle", "reset", "shuffle"]
//[[[1, 2, 3]], [], [], []]
//输出
//[null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
//
//解释
//Solution solution = new Solution([1, 2, 3]);
//solution.shuffle();    // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。例如，返回 [3, 
//1, 2]
//solution.reset();      // 重设数组到它的初始状态 [1, 2, 3] 。返回 [1, 2, 3]
//solution.shuffle();    // 随机返回数组 [1, 2, 3] 打乱后的结果。例如，返回 [1, 3, 2]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -106 <= nums[i] <= 106 
// nums 中的所有元素都是 唯一的 
// 最多可以调用 5 * 104 次 reset 和 shuffle 
// 
// 👍 117 👎 0


import com.caomu.util.Utils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class _384_ShuffleAnArray {
    public static void main(String[] args) {
        Solution solution = new _384_ShuffleAnArray().new Solution(Utils.stringToArray("[1,2,3]"));
        System.out.println(Arrays.toString(solution.shuffle()));
        solution.reset();
        System.out.println(Arrays.toString(solution.shuffle()));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<Integer> nums;
        private int[] originalNums;

        public Solution(int[] nums) {
            this.originalNums = nums;
            this.nums = Arrays.stream(nums).boxed().collect(Collectors.toList());
        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            return this.originalNums;
        }

        /**
         * Returns a random shuffling of the array.
         */
        public int[] shuffle() {
            List<Integer> tNums = new LinkedList(this.nums);
            int[] result = new int[this.nums.size()];
            int i = 0;
            while (!tNums.isEmpty()) {
                int idx = (int) (Math.random() * (tNums.size()));
                result[i++] = tNums.get(idx);
                tNums.remove(idx);
            }
            return result;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
//leetcode submit region end(Prohibit modification and deletion)

}


class Trie {
    Trie[] children;
    boolean isWord;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        this.children = new Trie[26];
        this.isWord = false;
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Trie curr = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new Trie();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Trie leaf = this.findLeafTrie(word);
        return leaf != null && leaf.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return this.findLeafTrie(prefix) != null;
    }

    private Trie findLeafTrie(String word) {
        Trie curr = this;
        for (int i = 0; i < word.length(); i++) {
            curr = curr.children[word.charAt(i) - 'a'];
            if (curr == null) {
                return null;
            }
        }
        return curr;
    }
}