/*
 * @lc app=leetcode.cn id=13 lang=java
 *
 * [13] 罗马数字转整数
 */

// @lc code=start
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
	public int romanToInt(String s) {
		int res = 0;

		res += appearNumber(s, "IV") * 4 + appearNumber(s, "IX") * 9 + appearNumber(s, "XL") * 40
				+ appearNumber(s, "XC") * 90 + appearNumber(s, "CD") * 400 + appearNumber(s, "CM") * 900;
		s = s.replaceAll("IV", "").replaceAll("IX", "").replaceAll("XL", "").replaceAll("XC", "").replaceAll("CD", "")
				.replaceAll("CM", "");
		// System.out.println(s);
		res += appearNumber(s, "I") + appearNumber(s, "V") * 5 + appearNumber(s, "X") * 10 + appearNumber(s, "L") * 50
				+ appearNumber(s, "C") * 100 + appearNumber(s, "D") * 500 + appearNumber(s, "M") * 1000;
		return res;
	}

	private int appearNumber(String srcText, String findText) {
		int count = 0;
		Pattern p = Pattern.compile(findText);
		Matcher m = p.matcher(srcText);
		while (m.find()) {
			count++;
		}
		return count;
	}
}
// @lc code=end
