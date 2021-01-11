//给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。 
//
// 示例 1: 
//
// 
//输入: [3, 2, 1]
//
//输出: 1
//
//解释: 第三大的数是 1.
// 
//
// 示例 2: 
//
// 
//输入: [1, 2]
//
//输出: 2
//
//解释: 第三大的数不存在, 所以返回最大的数 2 .
// 
//
// 示例 3: 
//
// 
//输入: [2, 2, 3, 1]
//
//输出: 1
//
//解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
//存在两个值为2的数，它们都排第二。
// 
// Related Topics 数组 
// 👍 197 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public int thirdMax(int[] nums) {
		if (nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		} else if (nums.length == 1) {
			return nums[0];
		}
		Integer[] res = new Integer[3];
		res[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (res[1] == null || res[2] == null || nums[i] > res[2]) {
				if (res[1] == null || nums[i] > res[1]) {
					if (nums[i] > res[0]) {
						res[2] = res[1];
						res[1] = res[0];
						res[0] = nums[i];
					} else if (nums[i] < res[0]) {
						res[2] = res[1];
						res[1] = nums[i];
					}
				} else if (nums[i] < res[1]) {
					res[2] = nums[i];
				}
			}
//			System.out.println(Arrays.stream(res).collect(Collectors.toList()));
		}
		return res[2] == null ? res[0] : res[2];
	}
}
//leetcode submit region end(Prohibit modification and deletion)
