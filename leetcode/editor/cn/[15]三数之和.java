//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2849 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums.length < 3) {
			return res;
		}
		Arrays.sort(nums);
//		System.out.println(Arrays.toString(nums));
		int l = nums.length;
		for (int i = 0; i < l - 2; i++) {
			if (nums[i] > 0) {
				break;
			}
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int k = (l - 1);
			for (int j = i + 1; j < l - 1; j++) {
				if (nums[i] + nums[j] > 0) {
					break;
				}
				if (j > i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}
//				System.out.println(i + "->" + nums[i] + "\t" + j + "->" + nums[j] + "\t" + k + "->" + nums[k]);
				int sum = 1;
				while (sum > 0 && k > j) {
					sum = nums[i] + nums[j] + nums[k];
//					System.out.println("sum=" + sum + ":\t" + i + "->" + nums[i] + "\t" + j + "->" + nums[j] + "\t" + k + "->" + nums[k]);
					if (sum > 0) {
						k--;
					}
				}
				if (sum == 0) {
//					System.out.println("sum=0:\t" + i + "->" + nums[i] + "\t" + j + "->" + nums[j] + "\t" + k + "->" + nums[k]);
					res.add(Arrays.asList(nums[i], nums[j], nums[k]));
				}
			}
		}
		return res;
	}
}
//leetcode submit region end(Prohibit modification and deletion)
