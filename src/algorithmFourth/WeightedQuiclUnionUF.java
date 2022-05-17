package algorithmFourth;

/**
 * @ClassName: WeightedQuiclUnionUF
 * @Description: 加权快速合并(最优并查集)
 * @Author: Admin
 * @Date 2021/5/7 21:45
 **/

public class WeightedQuiclUnionUF {
    private int[] ID;
    private int[] treeSize;
    private int count;

    public WeightedQuiclUnionUF (int N) {
        count = N;
        ID = new int[N];
        treeSize = new int[N];
        for (int i = 0; i < N; i++) {
            ID[i] = i;
            treeSize[i] = 1;
        }
    }

    public int count() {
        return count;
    }

    public int find(int root) {
        //查找当前树的根节点
        while (root != ID[root]) {
            root = ID[root];
        }
        return root;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        if (find(p) == find(q)) {
            return;
        }
        if (treeSize[p] < treeSize[q]) { //小树链接到大树上
            //在调用find后，　路径被压缩，　因此ID[p]即为根节点, 同理ID[q]也为根节点
            ID[p] = q;
            treeSize[q] += treeSize[p];
        } else {
            ID[q] = p;
            treeSize[p] += treeSize[q];
        }
        count--;
    }
}