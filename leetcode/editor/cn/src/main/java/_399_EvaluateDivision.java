//给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values
//[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。 
//
// 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj =
// ? 的结果作为答案。 
//
// 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替
//代这个答案。 
//
// 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"]
//,["b","a"],["a","e"],["a","a"],["x","x"]]
//输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
//解释：
//条件：a / b = 2.0, b / c = 3.0
//问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
//结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
// 
//
// 示例 2： 
//
// 
//输入：equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], quer
//ies = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
//输出：[3.75000,0.40000,5.00000,0.20000]
// 
//
// 示例 3： 
//
// 
//输入：equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a
//","c"],["x","y"]]
//输出：[0.50000,2.00000,-1.00000,-1.00000]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= equations.length <= 20 
// equations[i].length == 2 
// 1 <= Ai.length, Bi.length <= 5 
// values.length == equations.length 
// 0.0 < values[i] <= 20.0 
// 1 <= queries.length <= 20 
// queries[i].length == 2 
// 1 <= Cj.length, Dj.length <= 5 
// Ai, Bi, Cj, Dj 由小写英文字母与数字组成 
// 
// Related Topics 并查集 图 
// 👍 465 👎 0


import com.caomu.util.Utils;

import java.util.*;

public class _399_EvaluateDivision {
    public static void main(String[] args) {
        Solution solution = new _399_EvaluateDivision().new Solution();
        System.out.println(Arrays.toString(solution.calcEquation(Utils.stringTo2DStringList("[[\"a\",\"b\"],[\"b\",\"c\"]]"),
                new double[]{2.0, 3.0},
                Utils.stringTo2DStringList("\t[[\"a\",\"c\"],[\"b\",\"a\"],[\"a\",\"e\"],[\"a\",\"a\"],[\"x\",\"x\"]]"))));
    }

    //leetcode submit region begin(Prohibit modification and deletion)


    class Solution {
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            Map<String, Map.Entry<String, Double>> roots = new HashMap<>();
            for (int i = 0; i < equations.size(); i++) {
                List<String> equation = equations.get(i);
                if (roots.containsKey(equation.get(0))) {
                    Map.Entry<String, Double> root0 = this.findRoot(roots, equation.get(0));
                    if (!roots.containsKey(equation.get(1))) {
                        roots.put(equation.get(1), Map.entry(root0.getKey(),
                                root0.getValue() / values[i]));
                    } else {
                        Map.Entry<String, Double> root1 = this.findRoot(roots, equation.get(1));
                        roots.put(root1.getKey(), Map.entry(root0.getKey(),
                                root0.getValue() / (values[i] * root1.getValue())));
                    }
                } else {
                    if (!roots.containsKey(equation.get(1))) {
                        roots.put(equation.get(1), Map.entry(equation.get(1), 1.0D));
                    }
                    roots.put(equation.get(0), Map.entry(equation.get(1), values[i]));
                }
            }
            double[] result = new double[queries.size()];
            for (int i = 0; i < queries.size(); i++) {
                List<String> query = queries.get(i);
                Map.Entry<String, Double> root0 = this.findRoot(roots, query.get(0));
                Map.Entry<String, Double> root1 = this.findRoot(roots, query.get(1));
                if (root0 == null || root1 == null ||
                    !Objects.equals(root0.getKey(), root1.getKey())) {
                    result[i] = -1d;
                } else {
                    result[i] = root0.getValue() / root1.getValue();
                }
            }
            return result;
        }

        private Map.Entry<String, Double> findRoot(Map<String, Map.Entry<String, Double>> roots, String key) {
            if (!roots.containsKey(key)) {
                return null;
            }
            String aboveKey = key;
            Map.Entry<String, Double> above = roots.get(aboveKey);
            while (!Objects.equals(above.getKey(), aboveKey)) {
                aboveKey = above.getKey();
                Double value = above.getValue();
                above = roots.get(aboveKey);
                above = Map.entry(above.getKey(), above.getValue() * value);
            }
            return above;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}