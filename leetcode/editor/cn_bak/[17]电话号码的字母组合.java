//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 深度优先搜索 递归 字符串 回溯算法 
// 👍 1063 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	private Map<Character, List<String>> phoneMap = new HashMap<>() {
		{
			put('2', new ArrayList<>() {
				{
					add("a");
					add("b");
					add("c");
				}
			});
			put('3', new ArrayList<>() {
				{
					add("d");
					add("e");
					add("f");
				}
			});
			put('4', new ArrayList<>() {
				{
					add("g");
					add("h");
					add("i");
				}
			});
			put('5', new ArrayList<>() {
				{
					add("j");
					add("k");
					add("l");
				}
			});
			put('6', new ArrayList<>() {
				{
					add("m");
					add("n");
					add("o");
				}
			});
			put('7', new ArrayList<>() {
				{
					add("p");
					add("q");
					add("r");
					add("s");
				}
			});
			put('8', new ArrayList<>() {
				{
					add("t");
					add("u");
					add("v");
				}
			});
			put('9', new ArrayList<>() {
				{
					add("w");
					add("x");
					add("y");
					add("z");
				}
			});
		}
	};

	public List<String> letterCombinations(String digits) {
		if (digits.length() == 0) {
			return new ArrayList<>();
		}
		// 递归的终止条件
		if (digits.length() == 1) {
			return phoneMap.get(digits.charAt(0));
		}

		// 处理当前层逻辑
		List<String> res = new ArrayList<>();
		for (String s : phoneMap.get(digits.charAt(0))) {
			for (String p : letterCombinations(digits.substring(1))) {
				res.add(s + p);
			}
		}
		return res;

	}
}
//leetcode submit region end(Prohibit modification and deletion)
