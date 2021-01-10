//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 617 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> m = new HashMap<>();
		for (String str : strs) {
			int frequency[] = new int[26];
			for (char c : str.toCharArray()) {
				frequency[c - 'a']++;
			}
//			System.out.println(Arrays.toString(frequency));
			String f = Arrays.toString(frequency);
			List<String> l = m.getOrDefault(f, new ArrayList<>());
			l.add(str);
			m.put(f, l);
		}
		return new ArrayList(m.values());
	}
}
//leetcode submit region end(Prohibit modification and deletion)
