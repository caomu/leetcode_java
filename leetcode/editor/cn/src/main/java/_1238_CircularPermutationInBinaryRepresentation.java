//给你两个整数 n 和 start。你的任务是返回任意 (0,1,2,,...,2^n-1) 的排列 p，并且满足： 
//
// 
// p[0] = start 
// p[i] 和 p[i+1] 的二进制表示形式只有一位不同 
// p[0] 和 p[2^n -1] 的二进制表示形式也只有一位不同 
// 
//
// 
//
// 示例 1： 
//
// 输入：n = 2, start = 3
//输出：[3,2,0,1]
//解释：这个排列的二进制表示是 (11,10,00,01)
//     所有的相邻元素都有一位是不同的，另一个有效的排列是 [3,1,0,2]
// 
//
// 示例 2： 
//
// 输出：n = 3, start = 2
//输出：[2,6,7,5,4,0,1,3]
//解释：这个排列的二进制表示是 (010,110,111,101,100,000,001,011)
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 16 
// 0 <= start < 2^n 
// 
// Related Topics 数学 
// 👍 25 👎 0


import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class _1238_CircularPermutationInBinaryRepresentation {
    public static void main(String[] args) {
        Solution solution = new _1238_CircularPermutationInBinaryRepresentation().new Solution();
        List<Integer> res = solution.circularPermutation(4, 1);
        System.out.println(res);
        for (int r : res) {
            System.out.println(r + "\t" + Integer.toBinaryString(r));

        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private boolean checkOneBitDiff(int a, int b) {
            int xor = a ^ b;
            return (xor & (xor - 1)) == 0;
        }

        public List<Integer> circularPermutation(int n, int start) {
            int[] nums = IntStream.rangeClosed(0, n).map(i -> (int) Math.pow(2, i)).toArray();
            int len = (int) Math.pow(2, n);
            LinkedList<Integer> path = new LinkedList<>();
            path.add(start);
            int[] used = new int[len];
            used[start] = 1;
            return this.backtrack(nums, len, path, used);
        }

        private LinkedList<Integer> backtrack(int[] nums, int len, LinkedList<Integer> path, int[] used) {
            if (path.size() == len) {
                if (this.checkOneBitDiff(path.peekFirst(), path.peekLast())) {
                    return path;
                }
                return null;
            }
            LinkedList<Integer> res;
            for (int i = nums.length - 1; i >= 0; i--) {
                int current = path.peekLast();
                int next = current + nums[i];
                if (next >= 0 && next < len && used[next] == 0 && this.checkOneBitDiff(current, next)) {
                    path.addLast(next);
                    used[next] = 1;
//                System.out.println("  递归之前 => " + path);
                    res = this.backtrack(nums, len, path, used);
                    if (res != null) {
                        return res;
                    }
                    path.removeLast();
                    used[next] = 0;
                }
                next = path.peekLast() - nums[i];
                if (next >= 0 && next < len && used[next] == 0 && this.checkOneBitDiff(current, next)) {
                    path.addLast(next);
                    used[next] = 1;
                    res = this.backtrack(nums, len, path, used);
                    if (res != null) {
                        return res;
                    }
                    path.removeLast();
                    used[next] = 0;
                    //System.out.println("递归之后 => " + path);
                }
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}