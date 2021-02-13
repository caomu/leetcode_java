//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。 
//
// 
//
// 示例： 
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
// 
//
// 
//
// 提示：你可以假定该字符串只包含小写字母。 
// Related Topics 哈希表 字符串 
// 👍 343 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public int firstUniqChar(String s) {
		int res = Integer.MAX_VALUE;
		Integer data[][] = new Integer[26][2];
		for (int i = 0; i < s.length(); i++) {
			int index = s.charAt(i) - 97;
			if (data[index][0] == null) {
				data[index][0] = i;
				data[index][1] = 1;
			} else {
				data[index][1]++;
			}
		}
		for (int i = 0; i < data.length; i++) {
			if (null != data[i][1] && data[i][1] == 1 && data[i][0] < res) {
				res = data[i][0];
			}
		}
		return res == Integer.MAX_VALUE ? -1 : res;

	}
}
//leetcode submit region end(Prohibit modification and deletion)
