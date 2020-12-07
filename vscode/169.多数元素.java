/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 */

// @lc code=start
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;

class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> pool = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            pool.putIfAbsent(nums[i], 0);
            pool.put(nums[i], pool.get(nums[i]) + 1);
        }
        for (Entry<Integer, Integer> entry : pool.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }
        }
        return 0;
    }
}
// @lc code=end
