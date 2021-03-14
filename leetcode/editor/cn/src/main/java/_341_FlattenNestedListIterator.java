//给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
//
// 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
//
//
//
// 示例 1:
//
// 输入: [[1,1],2,[1,1]]
//输出: [1,1,2,1,1]
//解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
//
// 示例 2:
//
// 输入: [1,[4,[6]]]
//输出: [1,4,6]
//解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
//
// Related Topics 栈 设计
// 👍 201 👎 0


import com.caomu.util.NestedInteger;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.logging.Logger;

/**
 * create time: 2021-03-14 17:49:51
 */
public class _341_FlattenNestedListIterator {

    private static final Logger logger = Logger.getLogger(_341_FlattenNestedListIterator.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        NestedIterator nestedIterator = new _341_FlattenNestedListIterator().new NestedIterator(null);

        // assert solution == ;
        logger.warning(String.valueOf(nestedIterator));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     * <p>
     * // @return true if this NestedInteger holds a single integer, rather than a nested list.
     * public boolean isInteger();
     * <p>
     * // @return the single integer that this NestedInteger holds, if it holds a single integer
     * // Return null if this NestedInteger holds a nested list
     * public Integer getInteger();
     * <p>
     * // @return the nested list that this NestedInteger holds, if it holds a nested list
     * // Return null if this NestedInteger holds a single integer
     * public List<NestedInteger> getList();
     * }
     */
    public class NestedIterator implements Iterator<Integer> {
        private Iterator<Integer> iterator;

        public NestedIterator(List<NestedInteger> nestedList) {
            Queue<Integer> queue = new LinkedList<>();
            this.initQueue(nestedList, queue);
            this.iterator = queue.iterator();
        }

        private void initQueue(List<NestedInteger> nestedList, Queue<Integer> queue) {
            for (NestedInteger nestedInteger : nestedList) {
                if (nestedInteger.isInteger()) {
                    queue.offer(nestedInteger.getInteger());
                } else {
                    this.initQueue(nestedInteger.getList(), queue);
                }
            }
        }

        @Override
        public Integer next() {
            return this.iterator.next();
        }

        @Override
        public boolean hasNext() {
            return this.iterator.hasNext();
        }
    }

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
