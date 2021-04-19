//设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针
///引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
//
// 在链表类中实现这些功能：
//
//
// get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
// addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
// addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
// addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val 的节点。如果 index 等于链表的长度，则该节点将附加
//到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
// deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
//
//
//
//
// 示例：
//
// MyLinkedList linkedList = new MyLinkedList();
//linkedList.addAtHead(1);
//linkedList.addAtTail(3);
//linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
//linkedList.get(1);            //返回2
//linkedList.deleteAtIndex(1);  //现在链表是1-> 3
//linkedList.get(1);            //返回3
//
//
//
//
// 提示：
//
//
// 所有val值都在 [1, 1000] 之内。
// 操作次数将在 [1, 1000] 之内。
// 请不要使用内置的 LinkedList 库。
//
// Related Topics 设计 链表
// 👍 228 👎 0


import com.caomu.util.Utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.ParseException;
import java.time.Duration;
import java.util.Arrays;
import java.util.logging.Logger;

/**
 * create time: 2021-04-18 09:32:41
 */
public class _707_DesignLinkedList {

    private static final Logger logger = Logger.getLogger(_707_DesignLinkedList.class.toString());
    private static final long startTimestamp = Timestamp.valueOf("2021-04-18 09:32:41").getTime();

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ParseException {
        long startTimeMillis = System.currentTimeMillis();

        MyLinkedList obj = new _707_DesignLinkedList().new MyLinkedList();
        obj.addAtHead(1);
        obj.addAtTail(3);
        obj.addAtIndex(1, 2);
        logger.warning(String.valueOf(obj.get(1)));
        assert obj.get(1) == 2;
        obj.deleteAtIndex(1);
        logger.warning(String.valueOf(obj.get(1)));
        assert obj.get(1) == 3;

        obj = new _707_DesignLinkedList().new MyLinkedList();
        obj.addAtHead(7);
        obj.addAtHead(2);
        obj.addAtHead(1);
        obj.addAtIndex(3, 0);
        obj.deleteAtIndex(2);
        obj.addAtHead(6);
        obj.addAtTail(4);
        logger.warning(String.valueOf(obj.get(4)));
        assert obj.get(4) == 4;
        obj.addAtHead(4);
        obj.addAtIndex(5, 0);
        obj.addAtHead(6);

        obj = new _707_DesignLinkedList().new MyLinkedList();
        obj.addAtHead(1);
        obj.addAtTail(3);
        obj.addAtIndex(1, 2);
        logger.warning(String.valueOf(obj.get(1)));
        assert obj.get(1) == 2;
        obj.deleteAtIndex(0);
        logger.warning(String.valueOf(obj.get(0)));
        assert obj.get(0) == 2;

        obj = new _707_DesignLinkedList().new MyLinkedList();
        obj.addAtIndex(0, 10);
        obj.addAtIndex(0, 20);
        obj.addAtIndex(1, 30);
        logger.warning(String.valueOf(obj.get(0)));
        assert obj.get(0) == 20;

        obj = new _707_DesignLinkedList().new MyLinkedList();
        obj.addAtHead(4);
        logger.warning(String.valueOf(obj.get(1)));
//        assert obj.get(1) == 20;
        obj.addAtHead(1);
        obj.addAtHead(5);
        obj.deleteAtIndex(3);
        obj.addAtHead(7);
        logger.warning(String.valueOf(obj.get(3)));
        logger.warning(String.valueOf(obj.get(3)));
        logger.warning(String.valueOf(obj.get(3)));
        obj.addAtHead(1);
        obj.deleteAtIndex(4);

        obj = new _707_DesignLinkedList().new MyLinkedList();
        String[] methods = new String[]{"addAtHead", "addAtTail", "addAtTail", "get", "get", "addAtTail", "addAtIndex", "addAtHead", "addAtHead", "addAtTail", "addAtTail", "addAtTail", "addAtTail", "get", "addAtHead", "addAtHead", "addAtIndex", "addAtIndex", "addAtHead", "addAtTail", "deleteAtIndex", "addAtHead", "addAtHead", "addAtIndex", "addAtTail", "get", "addAtIndex", "addAtTail", "addAtHead", "addAtHead", "addAtIndex", "addAtTail", "addAtHead", "addAtHead", "get", "deleteAtIndex", "addAtTail", "addAtTail", "addAtHead", "addAtTail", "get", "deleteAtIndex", "addAtTail", "addAtHead", "addAtTail", "deleteAtIndex", "addAtTail", "deleteAtIndex", "addAtIndex", "deleteAtIndex", "addAtTail", "addAtHead", "addAtIndex", "addAtHead", "addAtHead", "get", "addAtHead", "get", "addAtHead", "deleteAtIndex", "get", "addAtHead", "addAtTail", "get", "addAtHead", "get", "addAtTail", "get", "addAtTail", "addAtHead", "addAtIndex", "addAtIndex", "addAtHead", "addAtHead", "deleteAtIndex", "get", "addAtHead", "addAtIndex", "addAtTail", "get", "addAtIndex", "get", "addAtIndex", "get", "addAtIndex", "addAtIndex", "addAtHead", "addAtHead", "addAtTail", "addAtIndex", "get", "addAtHead", "addAtTail", "addAtTail", "addAtHead", "get", "addAtTail", "addAtHead", "addAtTail", "get", "addAtIndex"};
        int[][] params = Utils.stringTo2DArray("[[84],[2],[39],[3],[1],[42],[1,80],[14],[1],[53],[98],[19],[12],[2],[16],[33],[4,17],[6,8],[37],[43],[11],[80],[31],[13,23],[17],[4],[10,0],[21],[73],[22],[24,37],[14],[97],[8],[6],[17],[50],[28],[76],[79],[18],[30],[5],[9],[83],[3],[40],[26],[20,90],[30],[40],[56],[15,23],[51],[21],[26],[83],[30],[12],[8],[4],[20],[45],[10],[56],[18],[33],[2],[70],[57],[31,24],[16,92],[40],[23],[26],[1],[92],[3,78],[42],[18],[39,9],[13],[33,17],[51],[18,95],[18,33],[80],[21],[7],[17,46],[33],[60],[26],[4],[9],[45],[38],[95],[78],[54],[42,86]]");
        Class clazz = MyLinkedList.class;
        for (int i = 0; i < methods.length; i++) {
            System.out.println("method:" + methods[i] + "\tparams:" + Arrays.toString(params[i]));
            Method method = null;
            if (params[i].length == 1) {
                method = clazz.getDeclaredMethod(methods[i], int.class);
                method.invoke(obj, params[i][0]);
            } else if (params[i].length == 2) {
                method = clazz.getDeclaredMethod(methods[i], int.class, int.class);
                method.invoke(obj, params[i][0], params[i][1]);
            }
        }

        logger.info("system time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");

        Duration duration = Duration.ofSeconds((System.currentTimeMillis() - startTimestamp) / 1000);
        logger.info("solution time cost: [" + duration.toString() + "]");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyLinkedList {
        private ListNode head;
        private ListNode tail;
        private int length;

        /**
         * Initialize your data structure here.
         */
        public MyLinkedList() {
            this.length = 0;
        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         */
        public int get(int index) {
            if (this.head == null || index >= this.length || index < 0) {
                return -1;
            }
            ListNode node = this.head;
            while (node != null) {
                if (index == 0) {
                    break;
                }
                index--;
                node = node.next;
            }
            return node.val;
        }

        /**
         * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
         */
        public void addAtHead(int val) {
            ListNode node = new ListNode(val);
            node.next = this.head;
            this.head = node;
            if (this.tail == null) {
                this.tail = node;
            }
            this.length++;
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {
            ListNode node = new ListNode(val);
            if (this.tail == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }
            this.length++;
            this.tail = node;
        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
         */
        public void addAtIndex(int index, int val) {
            ListNode node = new ListNode(val);
            if (this.head == null && index == 0) {
                this.tail = node;
                this.head = node;
            } else if (this.head != null && index == this.length) {
                this.tail.next = node;
                this.tail = node;
            } else if (this.head != null && index == 0) {
                node.next = this.head;
                this.head = node;
            } else if (this.head != null && index < this.length && index > 0) {
                ListNode indexNode = this.head;
                while (indexNode != null) {
                    index--;
                    if (index == 0) {
                        node.next = indexNode.next;
                        indexNode.next = node;
                        break;
                    }
                    indexNode = indexNode.next;
                }
            } else {
                return;
            }
            this.length++;

        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {
            if (this.head == null || index >= this.length || index < 0) {
                return;
            } else if (index == 0) {
                this.head = this.head.next;
            } else {
                ListNode node = this.head;
                while (node != null) {
                    index--;
                    if (index == 0) {
                        if (node.next != null) {
                            node.next = node.next.next;
                            if (node.next == null) {
                                this.tail = node;
                            }
                        }
                        break;
                    }
                    node = node.next;
                }
            }
            this.length--;
        }

    }

    class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
