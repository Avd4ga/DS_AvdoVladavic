package week13;

public class UnionFind {
    private final int[] sets;

    public UnionFind(int n) {
        sets = new int[n];
        for (int i = 0; i < n; i++) {
            sets[i] = i;
        }
    }

    public int find(int u) {
        return sets[u];
    }

    public void union(int u, int w) {
        int rootU = find(u);
        int rootW = find(w);

        for (int i = 0; i < sets.length; i++) {
            if (sets[i] == rootU) {
                sets[i] = rootW;
            }
        }
    }

    public boolean connected(int u, int w) {
        return find(u) == find(w);
    }
}