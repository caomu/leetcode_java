//给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算其所有整数的移动平均值。 
//
// 示例: 
//
// MovingAverage m = new MovingAverage(3);
//m.next(1) = 1
//m.next(10) = (1 + 10) / 2
//m.next(3) = (1 + 10 + 3) / 3
//m.next(5) = (10 + 3 + 5) / 3
// 
//
// 
// Related Topics 设计 队列 
// 👍 50 👎 0


import java.util.LinkedList;
import java.util.List;

public class _346_MovingAverageFromDataStream {
    public static void main(String[] args) {
        MovingAverage movingAverage = new _346_MovingAverageFromDataStream().new MovingAverage(3);
        System.out.println(movingAverage.next(1));
        System.out.println(movingAverage.next(10));
        System.out.println(movingAverage.next(3));
        System.out.println(movingAverage.next(5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MovingAverage {
        private List<Integer> list;
        private int size;

        /**
         * Initialize your data structure here.
         */
        public MovingAverage(int size) {
            this.size = size;
            this.list = new LinkedList<>();
        }

        public double next(int val) {
            if (this.list.size() == this.size) {
                this.list.remove(0);
            }
            this.list.add(val);
            return (double) this.list.stream().mapToInt(Integer::valueOf).sum() / (double) this.list.size();
        }
    }

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
//leetcode submit region end(Prohibit modification and deletion)

}