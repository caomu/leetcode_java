//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,-1], k = 1
//输出：[1,-1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [9,11], k = 2
//输出：[11]
// 
//
// 示例 5： 
//
// 
//输入：nums = [4,-2], k = 2
//输出：[4] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// -104 <= nums[i] <= 104 
// 1 <= k <= nums.length 
// 
// Related Topics 堆 Sliding Window 
// 👍 686 👎 0


import java.util.ArrayDeque;
import java.util.Deque;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	private void cleanQ(Deque<Integer> q, int[] nums, int i) {
		while (!q.isEmpty() && nums[q.peekFirst()] < nums[i]) {
			q.removeFirst();
		}
		while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
			q.removeLast();
		}
		q.add(i);
	}

	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums.length == 0 || k == 0) {
			return null;
		}
		Deque<Integer> q = new ArrayDeque<>(k);
		for (int i = 0; i < k; i++) {
//			System.out.println(q.peekFirst());
			cleanQ(q, nums, i);
//			System.out.println(q.toString());
		}
		int[] res = new int[nums.length - k + 1];
		res[0] = nums[q.peekFirst()];
//		System.out.println(q.toString() + "\t" + Arrays.toString(res));
		for (int i = k; i < nums.length; i++) {
			if (q.peek() == (i - k)) {
				q.removeFirst();
			}
			cleanQ(q, nums, i);
			res[i - k + 1] = nums[q.peekFirst()];
//			System.out.println(q.toString() + "\t" + Arrays.toString(res));
		}
		return res;
	}
}
//leetcode submit region end(Prohibit modification and deletion)
