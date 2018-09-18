package Algorithm.Fundamental;

public class UnionFind {
    private int count;
    private int id[];
    private int size[];

    //成本模型: 数组访问次数
    private boolean connected(int p,int q) {
        return find(p) == find(q);
    }

    public UnionFind(int N) {
        count = N;
        id = new int[N];
        size = new int[N];

        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }

        for (int i = 0; i < size.length; i++) {
            size[i] = 1;
        }
    }

    public int count() {
        return count;
    }
/*

    public int find(int p) {
        return id[p];
    }

    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if (connected(p, q)) return;

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) id[ i] = qID;
        }
        count--;
    }
*/

    public int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) return;

        if (size[pRoot] < size[qRoot]) {
            id[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        } else {
            id[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }
        count--;
    }

    public void printAll() {
        for (int i = 0; i < id.length; i++) {
            System.out.print(id[i]);
            System.out.print(' ');
        }
    }
}
