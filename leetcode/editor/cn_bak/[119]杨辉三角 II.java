//给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 3
//输出: [1,3,3,1]
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(k) 空间复杂度吗？ 
// Related Topics 数组 
// 👍 216 👎 0


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public List<Integer> getRow(int rowIndex) {
		int row1[] = new int[rowIndex + 1];
		int row2[] = new int[rowIndex + 1];
		for (int i = 0; i < rowIndex + 1; i++) {
			for (int j = 0; j < i + 1; j++) {
				if (j > 0 && j < i) {
					row2[j] = row1[j] + row1[j - 1];
				} else {
					row2[j] = 1;
				}
			}
			row1 = row2.clone();
		}
		return Arrays.stream(row1).boxed().collect(Collectors.toList());
	}
}
//leetcode submit region end(Prohibit modification and deletion)
