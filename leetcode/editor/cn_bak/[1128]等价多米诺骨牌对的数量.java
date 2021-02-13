//给你一个由一些多米诺骨牌组成的列表 dominoes。 
//
// 如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。 
//
// 形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 
//b==c。 
//
// 在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i,
// j) 的数量。 
//
// 
//
// 示例： 
//
// 输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= dominoes.length <= 40000 
// 1 <= dominoes[i][j] <= 9 
// 
// Related Topics 数组 
// 👍 76 👎 0


import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] hashtable = new int[100];
        AtomicInteger result = new AtomicInteger();
        Arrays.stream(dominoes).forEach(d -> {
            int hash = Math.max(d[0], d[1]) * 10 + Math.min(d[0], d[1]);
            result.addAndGet(hashtable[hash]);
//            System.out.println("d[0]:" + d[0] + ",d[1]:" + d[1] + ",hash:" + hash);
            hashtable[hash]++;
        });
        return result.intValue();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
