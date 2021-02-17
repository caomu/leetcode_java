//不使用任何内建的哈希表库设计一个哈希映射 
//
// 具体地说，你的设计应该包含以下的功能 
//
// 
// put(key, value)：向哈希映射中插入(键,值)的数值对。如果键对应的值已经存在，更新这个值。 
// get(key)：返回给定的键所对应的值，如果映射中不包含这个键，返回-1。 
// remove(key)：如果映射中存在这个键，删除这个数值对。 
// 
//
// 
//示例： 
//
// MyHashMap hashMap = new MyHashMap();
//hashMap.put(1, 1);          
//hashMap.put(2, 2);         
//hashMap.get(1);            // 返回 1
//hashMap.get(3);            // 返回 -1 (未找到)
//hashMap.put(2, 1);         // 更新已有的值
//hashMap.get(2);            // 返回 1 
//hashMap.remove(2);         // 删除键为2的数据
//hashMap.get(2);            // 返回 -1 (未找到) 
// 
//
// 
//注意： 
//
// 
// 所有的值都在 [0, 1000000]的范围内。 
// 操作的总数目在[1, 10000]范围内。 
// 不要使用内建的哈希库。 
// 
// Related Topics 设计 哈希表 
// 👍 116 👎 0


import java.util.LinkedList;
import java.util.List;

public class _706_DesignHashmap {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyHashMap {
        private List<Integer> keys;
        private List<Integer> values;

        /**
         * Initialize your data structure here.
         */
        public MyHashMap() {
            this.keys = new LinkedList<>();
            this.values = new LinkedList<>();
        }

        /**
         * value will always be non-negative.
         */
        public void put(int key, int value) {
            if (this.keys.contains(key)) {
                this.values.set(this.keys.indexOf(key), value);
            } else {
                this.keys.add(key);
                this.values.add(value);
            }
        }

        /**
         * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
         */
        public int get(int key) {
            if (!this.keys.contains(key)) {
                return -1;
            }
            return this.values.get(this.keys.indexOf(key));
        }

        /**
         * Removes the mapping of the specified value key if this map contains a mapping for the key
         */
        public void remove(int key) {
            if (this.keys.contains(key)) {
                int idx = this.keys.indexOf(key);
                this.keys.remove(idx);
                this.values.remove(idx);
            }
        }
    }

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
//leetcode submit region end(Prohibit modification and deletion)

}