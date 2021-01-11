//给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。 
//
//
// 你可以 任意多次交换 在 pairs 中任意一对索引处的字符。 
//
// 返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。 
//
// 
//
// 示例 1: 
//
// 输入：s = "dcab", pairs = [[0,3],[1,2]]
//输出："bacd"
//解释： 
//交换 s[0] 和 s[3], s = "bcad"
//交换 s[1] 和 s[2], s = "bacd"
// 
//
// 示例 2： 
//
// 输入：s = "dcab", pairs = [[0,3],[1,2],[0,2]]
//输出："abcd"
//解释：
//交换 s[0] 和 s[3], s = "bcad"
//交换 s[0] 和 s[2], s = "acbd"
//交换 s[1] 和 s[2], s = "abcd" 
//
// 示例 3： 
//
// 输入：s = "cba", pairs = [[0,1],[1,2]]
//输出："abc"
//解释：
//交换 s[0] 和 s[1], s = "bca"
//交换 s[1] 和 s[2], s = "bac"
//交换 s[0] 和 s[1], s = "abc"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10^5 
// 0 <= pairs.length <= 10^5 
// 0 <= pairs[i][0], pairs[i][1] < s.length 
// s 中只含有小写英文字母 
// 
// Related Topics 并查集 数组 
// 👍 135 👎 0


import java.util.*;
import java.util.stream.IntStream;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        UnionFind uf = new UnionFind(s.length());
        int[] roots = uf.getRoots();
        pairs.forEach(pair -> uf.union(pair.get(0), pair.get(1)));

        Map<Integer, List<Integer>> key = new HashMap<>();

//        System.out.println(Arrays.toString(roots));
        for (int i = 0; i < roots.length; i++) {
            int root = uf.findRoot(i);
            List<Integer> list = key.getOrDefault(root, new ArrayList<>());
            list.add(i);
            key.put(root, list);
        }
        char[] res = new char[s.length()];

//        System.out.println(key.values());
        for (List<Integer> indexs : key.values()) {
            List<Character> list = new ArrayList<>();
            indexs.forEach(i -> list.add(s.charAt(i)));
//            System.out.println(list);
            Collections.sort(list);
            Collections.sort(indexs);
//            System.out.println(list);
            Iterator<Integer> it = indexs.iterator();
            Iterator<Character> itSet = list.iterator();
            while (it.hasNext()) {
                int i = it.next();
                char c = itSet.next();
                res[i] = c;
            }
        }

        return new String(res);
    }

    private class UnionFind {
        private int[] roots;

        protected UnionFind(int N) {
            this.roots = IntStream.range(0, N).toArray();
        }

        protected int[] getRoots() {
            return this.roots;
        }

        protected void union(int p, int q) {
            roots[this.findRoot(p)] = this.findRoot(q);
        }

        protected int findRoot(int i) {
            int root = i;
            while (root != roots[root]) {
                root = roots[root];
            }
            int t;
            while (i != roots[root]) {
                t = roots[i];
                roots[i] = root;
                i = t;
            }
            return root;
        }

        protected boolean connected(int p, int q) {
            return this.findRoot(p) == this.findRoot(q);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
