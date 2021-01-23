//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意： 
//
// 答案中不可以包含重复的四元组。 
//
// 示例： 
//
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics 数组 哈希表 双指针 
// 👍 704 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return new ArrayList<>();
        }
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if (nums[i] + nums[nums.length - 3] + nums[nums.length - 2] + nums[nums.length - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if (nums[i] + nums[j] + nums[nums.length - 2] + nums[nums.length - 1] < target) {
                    continue;
                }
                int t = target - nums[i] - nums[j];
                int k = j + 1;
//                System.out.println("i:" + i + "," + nums[i] + "\tj:" + j + "," + nums[j] + "\tk:" + k + "," + nums[k] + "\tt:" + t);
                int l = nums.length - 1;
                while (l > k) {
                    int tt = nums[k] + nums[l];
//                    System.out.println("i:" + i + "," + nums[i] + "\tj:" + j + "," + nums[j] + "\tk:" + k + "," + nums[k] + "\tl:" + l + "," + nums[l] + "\tt:" + t + "\ttt:" + tt);
                    if (tt > t) {
                        l--;
                    } else if (tt < t) {
                        k++;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        while (l > k && nums[k] == nums[k + 1]) {
                            k++;
                        }
                        k++;
                        while (l > k && nums[l] == nums[l - 1]) {
                            l--;
                        }
                        l--;
                    }
                }
            }
        }

        return new ArrayList<>(res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
