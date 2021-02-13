//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。 
//
// 
// 
// 实现 LRUCache 类： 
//
// 
// LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
//限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
// 
//
// 
// 
// 
//
// 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 3000 
// 0 <= value <= 104 
// 最多调用 3 * 104 次 get 和 put 
// 
// Related Topics 设计 
// 👍 1109 👎 0


import java.util.LinkedHashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {
    private final Map<Integer, Node> map;
    private final Integer capacity;
    private final Node first;
    private final Node end;

    public LRUCache(int capacity) {
        first = new Node(null, null, null, null);
        end = new Node(first, null, null, null);
        first.next = end;
        map = new LinkedHashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            move2First(node);
//            System.out.println("get key:" + key + "\tfirst.next.key:" + first.next.key
//                    + "\tfirst.next.value:" + first.next.value + "\tmap:" + map + "\tend.prev.key:" + end.prev.key + "\tend.prev.value:" + end.prev.value);
            return node.value;
        }
        return -1;
    }

    private void move2First(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = first;
        node.next = first.next;
        first.next.prev = node;
        first.next = node;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            move2First(node);
        } else {
            Node node = new Node(first, key, value, first.next);
            first.next.prev = node;
            first.next = node;
            map.put(key, node);
        }
//        System.out.println("put key:" + key + "\tvalue:" + value + "\tfirst.next.key:" + first.next.key
//                + "\tfirst.next.value:" + first.next.value + "\tmap:" + map + "\tend.prev.key:" + end.prev.key + "\tend.prev.value:" + end.prev.value);

        if (map.size() > capacity) {
            Node node = map.get(end.prev.key);
            node.prev.next = end;
            end.prev = node.prev;
            map.remove(node.key);
        }
//        System.out.println("put key:" + key + "\tvalue:" + value + "\tfirst.next.key:" + first.next.key + "\tfirst.next.value:" + first.next.value + "\tmap:" + map + "\tend.prev.key:" + end.prev.key + "\tend.prev.value:" + end.prev.value);
    }

    private static class Node {
        Integer key;
        Integer value;
        Node next;
        Node prev;

        Node(Node prev, Integer key, Integer value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        @Override
        public String toString() {
            return "[prev key:" + this.prev.key + "\tprev value:" + this.prev.value
                    + "\tvalue:" + this.value + "\tnext key:" + this.next.key + "\tnext value:" + this.next.value + "]";
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
