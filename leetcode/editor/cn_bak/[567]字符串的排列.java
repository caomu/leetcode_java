//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。 
//
// 换句话说，第一个字符串的排列之一是第二个字符串的子串。 
//
// 示例1: 
//
// 
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
// 
//
// 
//
// 示例2: 
//
// 
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
// 
//
// 
//
// 注意： 
//
// 
// 输入的字符串只包含小写字母 
// 两个字符串的长度都在 [1, 10,000] 之间 
// 
// Related Topics 双指针 Sliding Window 
// 👍 249 👎 0


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Integer, Integer> freqMap = new ConcurrentHashMap<>();
        s1.chars().forEach(i -> freqMap.put(i, freqMap.getOrDefault(i, 0) + 1));
        for (int i = 0; i < s2.length() - s1.length() + 1; i++) {
            Integer c = (int) s2.charAt(i);
            if (freqMap.containsKey(c)) {
                Map<Integer, Integer> freqMap1 = new HashMap<>(freqMap);
                for (int j = i; j < i + s1.length() + 1 && j < s2.length(); j++) {
                    Integer c1 = (int) s2.charAt(j);
                    if (!freqMap1.containsKey(c1)) {
                        if (freqMap1.isEmpty()) {
                            return true;
                        } else {
                            break;
                        }
                    } else {
                        if (freqMap1.get(c1) > 1) {
                            freqMap1.put(c1, freqMap1.get(c1) - 1);
                        } else {
                            freqMap1.remove(c1);
                        }
                        if (j == s2.length() - 1 && freqMap1.isEmpty()) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
