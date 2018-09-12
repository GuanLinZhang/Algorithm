package Algorithm.Chapter1;

public class UnionFind {
    private int count;
    private int id[];


    //成本模型: 数组访问次数
    private boolean connected(int p,int q) {
        return find(p) == find(q);
    }

    public UnionFind(int N) {
        count = N;
        id = new int[N];

        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    public int count() {
        return count;
    }

    public int find(int p) {
        return id[p];
    }

    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if (connected(p, q)) return;

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) id[i] = qID;
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
