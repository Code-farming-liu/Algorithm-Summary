package algorithmFourth;

/**
 * @ClassName: UF
 * @Description: 并查集的模板
 * @Author: Admin
 * @Date 2021/5/6 20:21
 **/

public class UF {
    // 分量Id(以触点作为索引)
    private int[] id;
    // 连通分量的数量
    private int count;

    public UF(int N) {
        // 初始化分量数组id
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }
    // 统计连通分量的数量
    public int count() {
        return count;
    }

    // 判断两个连通分量是否连接
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    // 查看p所在的连通分量
//    public int find(int p) {
//        return id[p];
//    }

    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }
//    public void union(int p, int q) {
//        int pId = find(p);
//        int qId = find(q);
//
//        // 如果p和q已经在相同的分量之中则不需要采取任何行动
//        if (pId == qId) {
//            return;
//        }
//        for (int i = 0; i < id.length; i++) {
//            if (id[i] == pId) {
//                id[i] = qId;
//            }
//        }
//        count--;
//    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        // 如果p和q已经在相同的分量之中则不需要采取任何行动
        if (pRoot == qRoot) {
            return;
        }
        id[pRoot] = qRoot;
        count--;
    }

    public static void main(String[] args) {
        UF uf = new UF(9);
        System.out.println(uf.find(5));
    }
}