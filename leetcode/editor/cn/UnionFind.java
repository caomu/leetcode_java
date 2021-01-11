import java.util.stream.IntStream;

/**
 * @author : CAOMU
 * @version : 1.0
 * @project : leetcode_java
 * @since : 2021/01/11, 月, 15:15
 */
public class UnionFind {
    private int[] roots;

    protected UnionFind(int N) {
        this.roots = IntStream.range(0, N).toArray();
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
