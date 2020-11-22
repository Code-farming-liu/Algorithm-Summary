import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: Test89
 * Description: 岛屿的数量
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
 * 一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。
 * 你可以假设网格的四个边均被水包围。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * 输出: 3
 * <p>
 * @Author: Admin
 **/

public class Test89 {
    //DFS
    //将二维网格看成一个无向图，竖直或水平相邻的 1 之间有边。
    //
    //算法
    //
    //线性扫描整个二维网格，如果一个结点包含 1，则以其为根结点启动深度优先搜索。
    // 在深度优先搜索过程中，每个访问过的结点被标记为 0。
    // 计数启动深度优先搜索的根结点的数量，即为岛屿的数量。
    //
    void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }
        //将访问过的该点标记为0
        grid[r][c] = '0';
        //递归遍历该点的上下
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        //递归遍历该点的左右
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
//                      如果该点的值为‘1’说明该点没有被访问过，因此岛屿数量加一
                    ++num_islands;
                    dfs(grid, r, c);
                }
            }
        }

        return num_islands;
    }

    //    线性扫描整个二维网格，如果一个结点包含 1，
//     则以其为根结点启动广度优先搜索。将其放入队列中，
//     并将值设为 0 以标记访问过该结点。迭代地搜索队列中的每个结点，直到队列为空。
//
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;

        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    grid[r][c] = '0'; // mark as visited
                    Queue<Integer> queue = new LinkedList<>();
                    //也就是将对应的位置 加入队列  比如 3,6  3 * 二维数组的列 + 6 为这个点在表格中的位置
                    queue.add(r * nc + c);
                    while (!queue.isEmpty()) {
                        int id = queue.remove();
                        //3 * 二维数组的列 + 6  = 这个点在表格中的位置
                        //3 = 这个点在表格中的位置 / 二维数组的列
                        //6 = 这个点在表格中的位置 % 二维数组的列
                        int row = id / nc;
                        int col = id % nc;
                        //判断这个位置的上面一个数是不是‘1’ 如果是加入队列
                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            //同样加入的是位置
                            queue.add((row - 1) * nc + col);
                            //将该点设置为0
                            grid[row - 1][col] = '0';
                        }
                        //判断这个位置的下面一个数是不是‘1’ 如果是加入队列
                        if (row + 1 < nr && grid[row + 1][col] == '1') {
                            queue.add((row + 1) * nc + col);
                            grid[row + 1][col] = '0';
                        }
                        //判断这个位置的左面一个数是不是‘1’ 如果是加入队列
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            queue.add(row * nc + col - 1);
                            grid[row][col - 1] = '0';
                        }
                        //判断这个位置的右面一个数是不是‘1’ 如果是加入队列
                        if (col + 1 < nc && grid[row][col + 1] == '1') {
                            queue.add(row * nc + col + 1);
                            grid[row][col + 1] = '0';
                        }
                    }
                }
            }
        }
        return num_islands;
    }

    class UnionFind {
        int count; // # of connected components
        int[] parent;
        int[] rank;

        public UnionFind(char[][] grid) { // for problem 200
            count = 0;
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m * n];
            rank = new int[m * n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] == '1') {
                        parent[i * n + j] = i * n + j;
                        ++count;
                    }
                    rank[i * n + j] = 0;
                }
            }
        }

        //
        public int find(int i) { // path compression
            if (parent[i] != i) parent[i] = find(parent[i]);
            return parent[i];
        }

        public void union(int x, int y) { // union with rank
            int rootx = find(x);
            int rooty = find(y);
            if (rootx != rooty) {
                if (rank[rootx] > rank[rooty]) {
                    parent[rooty] = rootx;
                } else if (rank[rootx] < rank[rooty]) {
                    parent[rootx] = rooty;
                } else {
                    parent[rooty] = rootx;
                    rank[rootx] += 1;
                }
                --count;
            }
        }

        public int getCount() {
            return count;
        }
    }

    //
    public int numIslands1(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        UnionFind uf = new UnionFind(grid);
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    grid[r][c] = '0';
                    if (r - 1 >= 0 && grid[r - 1][c] == '1') {
                        uf.union(r * nc + c, (r - 1) * nc + c);
                    }
                    if (r + 1 < nr && grid[r + 1][c] == '1') {
                        uf.union(r * nc + c, (r + 1) * nc + c);
                    }
                    if (c - 1 >= 0 && grid[r][c - 1] == '1') {
                        uf.union(r * nc + c, r * nc + c - 1);
                    }
                    if (c + 1 < nc && grid[r][c + 1] == '1') {
                        uf.union(r * nc + c, r * nc + c + 1);
                    }
                }
            }
        }

        return uf.getCount();
    }
}