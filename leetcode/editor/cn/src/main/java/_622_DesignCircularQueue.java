//设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”
//。
//
// 循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环
//队列，我们能使用这些空间去存储新的值。
//
// 你的实现应该支持如下操作：
//
//
// MyCircularQueue(k): 构造器，设置队列长度为 k 。
// Front: 从队首获取元素。如果队列为空，返回 -1 。
// Rear: 获取队尾元素。如果队列为空，返回 -1 。
// enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
// deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
// isEmpty(): 检查循环队列是否为空。
// isFull(): 检查循环队列是否已满。
//
//
//
//
// 示例：
//
// MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
//circularQueue.enQueue(1);  // 返回 true
//circularQueue.enQueue(2);  // 返回 true
//circularQueue.enQueue(3);  // 返回 true
//circularQueue.enQueue(4);  // 返回 false，队列已满
//circularQueue.Rear();  // 返回 3
//circularQueue.isFull();  // 返回 true
//circularQueue.deQueue();  // 返回 true
//circularQueue.enQueue(4);  // 返回 true
//circularQueue.Rear();  // 返回 4
//
//
//
// 提示：
//
//
// 所有的值都在 0 至 1000 的范围内；
// 操作数将在 1 至 1000 的范围内；
// 请不要使用内置的队列库。
//
// Related Topics 设计 队列
// 👍 182 👎 0

import com.caomu.util.Utils;

import java.sql.Timestamp;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * create time: 2021-04-20 09:39:35
 */
public class _622_DesignCircularQueue {

    private static final Logger logger = Logger.getLogger(_622_DesignCircularQueue.class.toString());
    private static final long START_TIMESTAMP = Timestamp.valueOf("2021-04-20 09:39:35").getTime();

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();

        MyCircularQueue myCircularQueue = new _622_DesignCircularQueue().new MyCircularQueue(3);
//        Utils.reflectCallingFunction(myCircularQueue, "[\"enQueue\",\"enQueue\",\"enQueue\",\"enQueue\",\"Rear\",\"isFull\",\"deQueue\",\"enQueue\",\"Rear\"]", "[[1],[2],[3],[4],[],[],[],[4],[]]");

        myCircularQueue = new _622_DesignCircularQueue().new MyCircularQueue(8);
        Utils.reflectCallingFunction(myCircularQueue, "[\"enQueue\",\"enQueue\",\"enQueue\",\"enQueue\",\"deQueue\",\"deQueue\",\"isEmpty\",\"isEmpty\",\"Rear\",\"Rear\",\"deQueue\"]",
                "[[3],[9],[5],[0],[],[],[],[],[],[],[]]");
        logger.log(Level.INFO, "time cost: [{0}] ms", (System.currentTimeMillis() - startTimeMillis));
        logger.log(Level.INFO, "solution cost: [{0}]", Duration.ofSeconds(
                (System.currentTimeMillis() - START_TIMESTAMP) / 1000));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyCircularQueue {
        private int[] queue;
        private int tail;

        public MyCircularQueue(int k) {
            this.queue = new int[k];
            this.tail = -1;
        }

        public boolean enQueue(int value) {
            if (this.isFull()) {
                return false;
            } else {
                this.tail++;
                this.queue[this.tail] = value;
                return true;
            }
        }

        public boolean deQueue() {
            if (this.isEmpty()) {
                return false;
            } else {
                this.tail--;
                for (int i = 0; i <= this.tail; i++) {
                    this.queue[i] = this.queue[i + 1];
                }
                return true;
            }
        }

        public int Front() {
            return this.tail < 0 ? -1 : this.queue[0];
        }

        public int Rear() {
            return this.tail < 0 ? -1 : this.queue[this.tail];
        }

        public boolean isEmpty() {
            return this.tail < 0;
        }

        public boolean isFull() {
            return this.tail == this.queue.length - 1;
        }
    }

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
