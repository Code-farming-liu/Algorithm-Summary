package zhenti.tengxun;

import java.util.Arrays;
import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
//        int t = 1;
        while (t > 0) {
            int n = scanner.nextInt();
            int[][] nums = new int[n][2];
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < 2; j++) {
                    nums[i][j] = scanner.nextInt();
                    max = Math.max(max, nums[i][j]);
                }
            }
//            int[][] nums = {
//                    {1, 2},
//                    {3, 4},
//                    {5, 6},
//                    {1, 6}
//            };
            UnionFind unionFind = new UnionFind(max + 1);
            for (int i = 0; i < nums.length; i++) {
                unionFind.unite(nums[i][0], nums[i][1]);
            }
            int count = 0;
            int[] parent = unionFind.size;
            for (int i = 1; i < parent.length; i++) {
                count = Math.max(count, parent[i]);
            }
            System.out.println(count);
            t--;
        }
    }
}

// 开启了路径压缩和按秩合并的并查集
class UnionFind {
    int[] parent;
    int[] size;
    // 当前连通分支数目
    int branchCount;

    public UnionFind(int n) {
        this.branchCount = n;
        this.parent = new int[n];
        this.size = new int[n];
        Arrays.fill(size, 1);
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        // 路径压缩
        return parent[x] == x ? x : (parent[x] = find(parent[x]));
    }

    public boolean unite(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) {
            return false;
        }
        // 按秩合并
        if (size[x] < size[y]) {
            int temp = x;
            x = y;
            y = temp;
        }
        parent[y] = x;
        size[x] += size[y];
        --branchCount;
        return true;
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    public int branchCount() {
        return branchCount;
    }
}
