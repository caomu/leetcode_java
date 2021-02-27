//中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。 
//
// 例如， 
//
// [2,3,4] 的中位数是 3 
//
// [2,3] 的中位数是 (2 + 3) / 2 = 2.5 
//
// 设计一个支持以下两种操作的数据结构： 
//
// 
// void addNum(int num) - 从数据流中添加一个整数到数据结构中。 
// double findMedian() - 返回目前所有元素的中位数。 
// 
//
// 示例： 
//
// addNum(1)
//addNum(2)
//findMedian() -> 1.5
//addNum(3) 
//findMedian() -> 2 
//
// 进阶: 
//
// 
// 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？ 
// 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？ 
// 
// Related Topics 堆 设计 
// 👍 365 👎 0


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.logging.Logger;

public class _295_FindMedianFromDataStream {

    private static final Logger logger = Logger.getLogger(_295_FindMedianFromDataStream.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        MedianFinder medianFinder = new _295_FindMedianFromDataStream().new MedianFinder();

        // assert solution == ;
        medianFinder.addNum(-1);
        logger.warning(String.valueOf(medianFinder.findMedian()));
        medianFinder.addNum(-2);
        logger.warning(String.valueOf(medianFinder.findMedian()));
        medianFinder.addNum(-3);
        logger.warning(String.valueOf(medianFinder.findMedian()));
        medianFinder.addNum(-4);
        logger.warning(String.valueOf(medianFinder.findMedian()));
        medianFinder.addNum(-5);
        logger.warning(String.valueOf(medianFinder.findMedian()));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MedianFinder {
        private Integer mid;
        private PriorityQueue<Integer> bigQueue;
        private PriorityQueue<Integer> smallQueue;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            this.bigQueue = new PriorityQueue<>();
            this.smallQueue = new PriorityQueue<>(Comparator.reverseOrder());
        }

        public void addNum(int num) {
            if (this.bigQueue.isEmpty() && this.smallQueue.isEmpty() && this.mid == null) {
                this.mid = num;
            } else if (this.bigQueue.isEmpty() && this.smallQueue.isEmpty()) {
                this.bigQueue.offer(Math.max(this.mid, num));
                this.smallQueue.offer(Math.min(this.mid, num));
                this.mid = null;
            } else {
                int big = this.bigQueue.peek();
                int small = this.smallQueue.peek();
                if (this.mid == null) {
                    if (num <= big && num >= small) {
                        this.mid = num;
                    } else if (num > big) {
                        this.mid = this.bigQueue.poll();
                        this.bigQueue.offer(num);
                    } else {
                        this.mid = this.smallQueue.poll();
                        this.smallQueue.offer(num);
                    }
                } else {
                    if (num >= this.mid) {
                        this.bigQueue.offer(num);
                        this.smallQueue.offer(this.mid);
                    } else {
                        this.bigQueue.offer(this.mid);
                        this.smallQueue.offer(num);
                    }
                    this.mid = null;
                }
            }
        }

        public double findMedian() {
            return this.mid == null ? (double) (this.bigQueue.peek() + this.smallQueue.peek()) / 2 : this.mid;
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
