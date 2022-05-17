package leetcode;

/**
 * @ClassName: Code_990
 * @Description: 等式方程的可满足性
 * 给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
 *
 * 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。 
 *
 *  
 *
 * 示例 1：
 *
 * 输入：["a==b","b!=a"]
 * 输出：false
 * 解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。
 * 示例 2：
 *
 * 输入：["b==a","a==b"]
 * 输出：true
 * 解释：我们可以指定 a = 1 且 b = 1 以满足满足这两个方程。
 * 示例 3：
 *
 * 输入：["a==b","b==c","a==c"]
 * 输出：true
 * 示例 4：
 *
 * 输入：["a==b","b!=c","c==a"]
 * 输出：false
 * 示例 5：
 *
 * 输入：["c==c","b==d","x!=z"]
 * 输出：true
 *
 * @Author: Admin
 **/

public class Code_990 {
    public boolean equationsPossible(String[] equations) {
        int length = equations.length;
        WeightedQuiclUnionUF uf = new WeightedQuiclUnionUF(length + 1);
        for (int i = 0; i < length; i++) {
            char[] chars = equations[i].toCharArray();
            if (chars[2] == '=') {
                int val1 = chars[0] - 'a';
                int val2 = chars[3] - 'a';
                uf.union(val1, val2);
            }
        }

        for (int i = 0; i < length; i++) {
            char[] chars = equations[i].toCharArray();
            if (chars[1] == '!') {
                int val1 = chars[0] - 'a';
                int val2 = chars[3] - 'a';
                if (uf.connected(val1, val2)) {
                    return false;
                }
            }
        }
        return true;
    }
}
class WeightedQuiclUnionUF {
    private int[] ID;
    private int[] treeSize;
    private int count;

    public WeightedQuiclUnionUF (int N) {
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

    public int find(int i) {
        //查找当前树的根节点
        int root = i;
        while (root != ID[root]) {
            root = ID[root];
        }

        //路径压缩
        int next;
        while (i != ID[i]) {
            next = ID[i];
            ID[i] = root;
            i = next;
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
            ID[ID[p]] = ID[q];
        } else {
            ID[ID[q]] = ID[p];
        }
        count--;
    }
}