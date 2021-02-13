//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表 
// 👍 321 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		Map<Character, Integer> m = new HashMap<>();
		for (char c : s.toCharArray()) {
			if (m.containsKey(c)) {
				m.put(c, m.get(c) + 1);
			} else {
				m.put(c, 1);
			}
		}
		for (char c : t.toCharArray()) {
			if (m.containsKey(c)) {
				int count = m.get(c);
				if (count < 1) {
					return false;
				} else if (count == 1) {
					m.remove(c);
				} else {
					m.put(c, m.get(c) - 1);
				}
			} else {
				return false;
			}
		}
		if (m.size() == 0) {
			return true;
		}
		return false;
	}
}
//leetcode submit region end(Prohibit modification and deletion)
