package leetcode;

// https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree/solution/xiang-xin-ke-xue-xi-lie-xiang-jie-zhi-gu-e3y9/
public class Code_331 {
    // in 每个节点的入度
    // out 每个节点的出度
    // m 有值节点个数
    // n 空节点个数

    // 2m >= in + 1 => in <= 2m - 1
    //
    //m >= out / 2 => out <= 2m
    //
    // in < out 恒成立
    public boolean isValidSerialization(String preorder) {
        String[] split = preorder.split(",");
        int n = split.length;
        int in = 0, out = 0;
        for (int i = 0; i < n; i++) {
            if (!split[i].equals("#")) {
                out += 2;
            }
            if (i != 0) {
                in++;
            }
            // 没有遍历结束恒成立
            if (i != n - 1 && out <= in) {
                return false;
            }
        }
        return in == out;
    }
}
