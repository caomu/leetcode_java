//给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其
//余元素是 emails 表示该账户的邮箱地址。 
//
// 现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为
//人们可能具有相同的名称。一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。 
//
// 合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是按字符 ASCII 顺序排列的邮箱地址。账户本身可以以任意顺序返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：
//accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnn
//ybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Ma
//ry", "mary@mail.com"]]
//输出：
//[["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  
//["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
//解释：
//第一个和第三个 John 是同一个人，因为他们有共同的邮箱地址 "johnsmith@mail.com"。 
//第二个 John 和 Mary 是不同的人，因为他们的邮箱地址没有被其他帐户使用。
//可以以任何顺序返回这些列表，例如答案 [['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
//['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']] 也是正确的
//。
// 
//
// 
//
// 提示： 
//
// 
// accounts的长度将在[1，1000]的范围内。 
// accounts[i]的长度将在[1，10]的范围内。 
// accounts[i][j]的长度将在[1，30]的范围内。 
// 
// Related Topics 深度优先搜索 并查集 
// 👍 205 👎 0


import java.util.*;
import java.util.stream.IntStream;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Set<Integer>> mailMap = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String mail = account.get(j);
                Set<Integer> numberSet = mailMap.getOrDefault(mail, new HashSet<>());
                numberSet.add(i);
                mailMap.put(account.get(j), numberSet);
            }
        }
        UnionFind uf = new UnionFind(accounts.size());
        for (Map.Entry<String, Set<Integer>> mail : mailMap.entrySet()) {
            Set<Integer> noSet = mail.getValue();
//            System.out.println(mail.getKey() + "\t" + Arrays.toString(noSet.toArray()));
            Iterator<Integer> it = noSet.iterator();
            int to = it.next();
            while (it.hasNext()) {
                int from = it.next();
                uf.union(to, from);
//                System.out.println("merge from: " + from + " to: " + to);
            }
        }
//        System.out.println(Arrays.toString(uf.getRoots()));
        Map<Integer, Set<String>> noMap = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            int no = uf.findRoot(i);
            Set<String> mailSet = noMap.getOrDefault(no, new TreeSet<>());
            List<String> account = accounts.get(i);
            mailSet.addAll(account.subList(1, account.size()));
            noMap.put(no, mailSet);
        }

        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<Integer, Set<String>> noEntry : noMap.entrySet()) {
            Set<String> mailSet = noEntry.getValue();
            List<String> accountList = new ArrayList<>(mailSet.size() + 1);
            accountList.add(accounts.get(noEntry.getKey()).get(0));
            accountList.addAll(mailSet);
            res.add(accountList);
        }

        return res;
    }

    private class UnionFind {
        private int[] roots;

        protected UnionFind(int n) {
            this.roots = IntStream.range(0, n).toArray();
        }

        protected int[] getRoots() {
            return this.roots;
        }

        protected void union(int p, int q) {
            roots[this.findRoot(p)] = this.findRoot(q);
        }

        protected void union(int... p) {
            for (int i = 1; i < p.length; i++) {
                this.union(p[i], p[0]);
            }
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

        protected boolean isConnected(int p, int q) {
            return this.findRoot(p) == this.findRoot(q);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
