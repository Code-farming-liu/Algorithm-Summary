import java.util.*;

/**
 * @ClassName: Test94
 * Description: 二叉搜索树中第k小的元素
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * <p>
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 *    2
 * 输出: 1
 * <p>
 * @Author: Admin
 **/

public class Test94 {
    public int kthSmallest1(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<TreeNode> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                list.add(node);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i).val;
        }
        Arrays.sort(res);
        return res[k - 1];
    }
    //中序遍历二叉搜索树
    public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) {
            return arr;
        }
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
        return arr;
    }
    //返回结果
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
        Collections.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
        return  k > nums.size() ? 0 : nums.get(k - 1);
//        return nums.get(k - 1);
    }

    public int kthSmallest2(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (true) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if (--k == 0) {
                return root.val;
            }
            root = root.right;
        }
    }


    int index = 0;
    TreeNode KthNode(TreeNode pRoot, int k){
        if(pRoot != null){ //中序遍历寻找第k个
            TreeNode node = KthNode(pRoot.left,k);
            if(node != null) {
                return node;
            }
            index++;
            if(index == k) {
                return pRoot;
            }
            node = KthNode(pRoot.right,k);
            if(node != null) {
                return node;
            }
        }
        return null;
    }

}