//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 回溯算法 
// 👍 1553 👎 0


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        Queue<Struct> q = new LinkedList<>(); // 核心数据结构
        Struct s = new Struct();
        s.str = "(";
        s.lCnt++;
        q.offer(s); // 将起点加入队列

        for (int i = 0; i < 2 * n - 1; i++) {
            /* 将当前队列中的所有节点向四周扩散 */
            int width = q.size();
            for (int j = 0; j < width; j++) {
                Struct cur = q.poll();
                /* 将 cur 的相邻节点加入队列 */
                if (cur.lCnt < n) {
                    q.offer(new Struct(cur.str + "(", cur.lCnt + 1, cur.rCnt));
                }
                if (cur.rCnt < cur.lCnt) {
                    q.offer(new Struct(cur.str + ")", cur.lCnt, cur.rCnt + 1));
                }
            }
        }
        return q.stream().map(i -> i.str).collect(Collectors.toList());
    }

    private static class Struct {
        protected String str;
        protected int lCnt;
        protected int rCnt;


        protected Struct() {
            this.str = "";
            this.lCnt = 0;
            this.rCnt = 0;
        }

        protected Struct(String str, int lCnt, int rCnt) {
            this.str = str;
            this.lCnt = lCnt;
            this.rCnt = rCnt;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
