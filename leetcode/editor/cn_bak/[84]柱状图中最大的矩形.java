//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。 
//
// 
//
// 
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。 
//
// 
//
// 示例: 
//
// 输入: [2,1,5,6,2,3]
//输出: 10 
// Related Topics 栈 数组 
// 👍 1112 👎 0


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//	public static void main(String[] args) {
//		new Solution().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
//	}

	public int largestRectangleArea(int[] heights) {
		Stack<Integer> s = new Stack<>();
		int largest = 0;
		for (int h : heights) {
//			System.out.println(Arrays.toString(s.toArray()));
			s.push(h);
			Stack<Integer> s1 = (Stack<Integer>) s.clone();
//			System.out.println(Arrays.toString(s1.toArray()));
			int len = 1, min = Integer.MAX_VALUE;
			while (!s1.empty() && s1.peek() > 0) {
				int t = s1.pop();
//				System.out.println(t);
				min = t < min ? t : min;
				int area = min * len;
				largest = largest > area ? largest : area;
				len++;
			}
		}
		return largest;
	}
}
//leetcode submit region end(Prohibit modification and deletion)
