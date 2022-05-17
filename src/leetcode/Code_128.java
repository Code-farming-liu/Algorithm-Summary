package leetcode;


import java.util.Arrays;

/**
 * @ClassName: Code_128
 * @Description: 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 *  
 * <p>
 * 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 * <p>
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * @Author: Admin
 **/

public class Code_128 {
    public static int longestConsecutive1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        // max 最终结果, curr 当前长度, last 上个数字
        int max = 1, curr = 1, last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == last) {
                continue;
            }
            if (nums[i] == last + 1) {
                curr++; // 符合连续，长度 +1
            } else {
                max = Math.max(max, curr); // 连不上了，记录长度
                curr = 1; // 重新开始
            }
            last = nums[i];
        }
        max = Math.max(max, curr); // 别忘了最后一段的连续区间
        return max;
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        WeightedQuiclUnionUF1 uf = new WeightedQuiclUnionUF1(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 < nums.length && nums[i] + 1 == nums[i + 1]) {
                uf.union(nums[i], nums[i + 1]);
            }
        }
        System.out.println(uf.count());
        return uf.count() + 1;
    }


    public static void main(String[] args) {
        int[] nums = {9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6};
        longestConsecutive(nums);
    }
}
class WeightedQuiclUnionUF1 {
    private int[] ID;
    private int[] treeSize;
    private int count;

    public WeightedQuiclUnionUF1 (int N) {
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
            ID[root] = ID[ID[root]];
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
        count++;
    }
}