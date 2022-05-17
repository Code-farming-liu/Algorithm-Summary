package zhenti.wangyi;

import java.util.Arrays;
import java.util.Scanner;

// A公司和B公司有n个合作的子项目，每个子项目由A公司和B公司各一名员工参与。一名员工可以参与多个子项目。
//
//一个员工如果担任了该项目的项目经理，它需要对所参与的该项目负责。一个员工也可以负责多个项目。
//
//A公司和B公司需要保证所有子项目都能有人负责，问最少需要指定几名项目经理？
//
//输入描述:
//第一行为A公司的的人员id列表， 0< id数量 < 10000，用空格切分
//第二行为B公司的人员id列表， 0< id数量 < 10000，用空格切分
//第三行为有已经有多少个匹配数子项目合作关系n
//下面有n行，每一行为每个子项目的合作对应关系，为两个id，第一个为A公司的员工id，第二个为B公司的员工id，用空格区分
//
//输出描述:
//一个整数，A公司和B公司合起来至少需要指定几名项目经理
//
//输入例子1:
//0 1 2
//3 4 5
//6
//0 4
//0 3
//1 3
//1 4
//2 5
//2 4
//
//输出例子1:
//3
//
//例子说明1:
//可行的一个保留人员方案是留下0,1,2即可，这样即可保证所有的子项目都有人cover到。
public class Main01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        int n = scanner.nextInt();
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = scanner.nextInt();
            nums[i][1] = scanner.nextInt();
        }
        UnionFind2 unionFind2 = new UnionFind2(n);
        for (int i = 0; i < n; i++) {
            unionFind2.unite(nums[i][0], nums[i][1]);
        }
        System.out.println(unionFind2.branchCount);
    }
}
// 开启了路径压缩和按秩合并的并查集
class UnionFind2 {
    int[] parent;
    int[] size;
    // 当前连通分支数目
    int branchCount;

    public UnionFind2(int n) {
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
