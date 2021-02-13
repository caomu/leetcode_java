//集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，导致集合丢失了一个整数并且有一个元素重
//复。 
//
// 给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,2,4]
//输出: [2,3]
// 
//
// 注意: 
//
// 
// 给定数组的长度范围是 [2, 10000]。 
// 给定的数组是无序的。 
// 
// Related Topics 哈希表 数学 
// 👍 143 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public int[] findErrorNums(int[] nums) {
		int[] res = new int[nums.length];
		int p = -1, n = 0;
		for (int i = 0; i < nums.length; i++) {
			if (0 == res[nums[i] - 1]) {
				res[nums[i] - 1] = 1;
			} else {
				n = nums[i];
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (0 == res[i]) {
				p = i;
				break;
			}
		}
		return new int[]{n, p + 1};
	}
}
//leetcode submit region end(Prohibit modification and deletion)
