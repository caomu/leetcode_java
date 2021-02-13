//给一非空的单词列表，返回前 k 个出现次数最多的单词。 
//
// 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。 
//
// 示例 1： 
//
// 
//输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
//输出: ["i", "love"]
//解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
//    注意，按字母顺序 "i" 在 "love" 之前。
// 
//
// 
//
// 示例 2： 
//
// 
//输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k
// = 4
//输出: ["the", "is", "sunny", "day"]
//解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
//    出现次数依次为 4, 3, 2 和 1 次。
// 
//
// 
//
// 注意： 
//
// 
// 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。 
// 输入的单词均由小写字母组成。 
// 
//
// 
//
// 扩展练习： 
//
// 
// 尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。 
// 
// Related Topics 堆 字典树 哈希表 
// 👍 196 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
//        System.out.println(map);
        Queue<String> queue = new PriorityQueue<>((w1, w2) -> map.get(w1).equals(map.get(w2)) ? w2.compareTo(w1) : map.get(w1).compareTo(map.get(w2)));
//        for (String w : map.keySet()) {
//            queue.offer(w);
//            System.out.println(queue + "\t" + queue.peek());
//        }
//        System.out.println("---------------");
        map.keySet().forEach(w -> {
            queue.offer(w);
//            System.out.println(queue + "\t" + queue.peek());
            if (queue.size() > k) {
                queue.poll();
            }
        });
//        System.out.println("---------------");
        List<String> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            res.add(queue.poll());
//            System.out.println(res);
        }

//        System.out.println(res);
        Collections.reverse(res);
//        System.out.println(res);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
