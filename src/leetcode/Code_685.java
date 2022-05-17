package leetcode;

/**
 * @ClassName: Code_685
 * @Description: 冗余连接
 * 在本问题中，有根树指满足以下条件的 有向 图。该树只有一个根节点，所有其他节点都是该根节点的后继。该树除了根节点之外的每一个节点都有且只有一个父节点，而根节点没有父节点。
 *
 * 输入一个有向图，该图由一个有着 n 个节点（节点值不重复，从 1 到 n）的树及一条附加的有向边构成。附加的边包含在 1 到 n 中的两个不同顶点间，这条附加的边不属于树中已存在的边。
 *
 * 结果图是一个以边组成的二维数组 edges 。 每个元素是一对 [ui, vi]，用以表示 有向 图中连接顶点 ui 和顶点 vi 的边，其中 ui 是 vi 的一个父节点。
 *
 * 返回一条能删除的边，使得剩下的图是有 n 个节点的有根树。若有多个答案，返回最后出现在给定二维数组的答案。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：edges = [[1,2],[1,3],[2,3]]
 * 输出：[2,3]
 * 示例 2：
 *
 *
 * 输入：edges = [[1,2],[2,3],[3,4],[4,1],[1,5]]
 * 输出：[4,1]
 *
 * @Author: Admin
 **/

public class Code_685 {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        // 边的条数（在这个问题里等于结点个数）
        int len = edges.length;
        // 步骤 1：预处理入度数组（记录指向某个结点的边的条数）
        int[] inDegree = new int[len + 1];
        for (int[] edge : edges) {
            inDegree[edge[1]]++;
        }

        // 步骤 2：先尝试删除构成入度为 2 的边，看看是否形成环
        for (int i = len - 1; i >= 0; i--) {
            if (inDegree[edges[i][1]] == 2) {
                // 如果不构成环，这条边就是要去掉的那条边
                if (!judgeCircle(edges, len, i)) {
                    return edges[i];
                }
            }
        }

        // 步骤 3：再尝试删除构成入度为 1 的边，看看是否形成环
        for (int i = len - 1; i >= 0; i--) {
            if (inDegree[edges[i][1]] == 1) {
                // 如果不构成环，这条边就是要去掉的那条边
                if (!judgeCircle(edges, len, i)) {
                    return edges[i];
                }
            }
        }
        throw new IllegalArgumentException("输入不符合要求。");
    }

    /**
     * 将 removeEdgeIndex 去掉以后，剩下的有向边是否构成环
     *
     * @param edges
     * @param len             结点总数（从 1 开始，因此初始化的时候 + 1）
     * @param removeEdgeIndex 删除的边的下标
     * @return 构成环，返回 true
     */
    private boolean judgeCircle(int[][] edges, int len, int removeEdgeIndex) {
        UnionFind unionFind = new UnionFind(len + 1);
        for (int i = 0; i < len; i++) {
            if (i == removeEdgeIndex) {
                continue;
            }
            if (!unionFind.union(edges[i][0], edges[i][1])) {
                // 合并失败，表示 edges[i][0] 和 edges[i][1] 在一个连通分量里，即构成了环
                return true;
            }
        }
        return false;
    }

    private class UnionFind {
        // 代表元法
        private int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while (x != parent[x]) {
                // 路径压缩（隔代压缩）
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        /**
         * @param x
         * @param y
         * @return 如果合并成功返回 true
         */
        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return false;
            }
            parent[rootX] = rootY;
            return true;
        }
    }
}