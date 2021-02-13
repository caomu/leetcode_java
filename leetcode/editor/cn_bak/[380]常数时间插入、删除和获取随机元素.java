//设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构。 
//
// 
// insert(val)：当元素 val 不存在时，向集合中插入该项。 
// remove(val)：元素 val 存在时，从集合中移除该项。 
// getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。 
// 
//
// 示例 : 
//
// 
//// 初始化一个空的集合。
//RandomizedSet randomSet = new RandomizedSet();
//
//// 向集合中插入 1 。返回 true 表示 1 被成功地插入。
//randomSet.insert(1);
//
//// 返回 false ，表示集合中不存在 2 。
//randomSet.remove(2);
//
//// 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
//randomSet.insert(2);
//
//// getRandom 应随机返回 1 或 2 。
//randomSet.getRandom();
//
//// 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
//randomSet.remove(1);
//
//// 2 已在集合中，所以返回 false 。
//randomSet.insert(2);
//
//// 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
//randomSet.getRandom();
// 
// Related Topics 设计 数组 哈希表 
// 👍 258 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

//leetcode submit region begin(Prohibit modification and deletion)
class RandomizedSet {
    private Random random;
    private ArrayList<Integer> list;
    private Map<Integer, Integer> map;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
//            System.out.println("insert: false");
            return false;
        }
        this.list.add(val);
        this.map.put(val, list.size() - 1);
//        System.out.println("insert:" + list);
//        System.out.println("insert:" + map);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
//            System.out.println("remove: false");
            return false;
        }
        int lastVal = list.get(list.size() - 1);
        int idx = map.get(val);
        list.set(idx, lastVal);
        map.put(lastVal, idx);
        map.remove(val);
        list.remove(list.size() - 1);
//        System.out.println("remove:" + list);
//        System.out.println("remove:" + map);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int res = list.get(random.nextInt(list.size()));
//        System.out.println("getRandom:" + list);
//        System.out.println("getRandom:" + map);
//        System.out.println("getRandom:" + res);
        return res;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
//leetcode submit region end(Prohibit modification and deletion)
