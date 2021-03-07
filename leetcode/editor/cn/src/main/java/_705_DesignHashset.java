//不使用任何内建的哈希表库设计一个哈希集合（HashSet）。
//
// 实现 MyHashSet 类：
//
//
// void add(key) 向哈希集合中插入值 key 。
// bool contains(key) 返回哈希集合中是否存在这个值 key 。
// void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
//
//
//
// 示例：
//
//
//输入：
//["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove
//", "contains"]
//[[], [1], [2], [1], [3], [2], [2], [2], [2]]
//输出：
//[null, null, null, true, false, null, true, null, false]
//
//解释：
//MyHashSet myHashSet = new MyHashSet();
//myHashSet.add(1);      // set = [1]
//myHashSet.add(2);      // set = [1, 2]
//myHashSet.contains(1); // 返回 True
//myHashSet.contains(3); // 返回 False ，（未找到）
//myHashSet.add(2);      // set = [1, 2]
//myHashSet.contains(2); // 返回 True
//myHashSet.remove(2);   // set = [1]
//myHashSet.contains(2); // 返回 False ，（已移除）
//
//
//
// 提示：
//
//
// 0 <= key <= 106
// 最多调用 104 次 add、remove 和 contains 。
//
//
//
//
// 进阶：你可以不使用内建的哈希集合库解决此问题吗？
// Related Topics 设计 哈希表
// 👍 89 👎 0


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public class _705_DesignHashset {

    private static final Logger logger = Logger.getLogger(_705_DesignHashset.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        MyHashSet myHashSet = new _705_DesignHashset().new MyHashSet();

        // assert solution == ;
        logger.warning(String.valueOf(myHashSet));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyHashSet {
        private List<Integer>[] bucketList;
        private int capacity;

        /**
         * Initialize your data structure here.
         */
        public MyHashSet() {
            this.capacity = 16;
            this.bucketList = new LinkedList[this.capacity];
            Arrays.fill(this.bucketList, new LinkedList<>());
        }

        public void add(int key) {
            List<Integer> bucket = this.bucketList[key % this.capacity];
            if (!bucket.contains(key)) {
                bucket.add(key);
            }
        }

        public void remove(int key) {
            List<Integer> bucket = this.bucketList[key % this.capacity];
            int index = bucket.indexOf(key);
            if (index >= 0) {
                bucket.remove(index);
            }
        }

        /**
         * Returns true if this set contains the specified element
         */
        public boolean contains(int key) {
            return this.bucketList[key % this.capacity].contains(key);
        }
    }

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
