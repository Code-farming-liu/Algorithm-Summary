package 二叉树

/**
给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10-5 以内的答案可以被接受。



示例 1：



输入：root = [3,9,20,null,null,15,7]
输出：[3.00000,14.50000,11.00000]
解释：第 0 层的平均值为 3,第 1 层的平均值为 14.5,第 2 层的平均值为 11 。
因此返回 [3, 14.5, 11] 。
示例 2:



输入：root = [3,9,20,15,7]
输出：[3.00000,14.50000,11.00000]

*/

func averageOfLevels(root *TreeNode) []float64 {
	result := make([]float64, 0)
	if root == nil {
		return result
	}
	queue := make([]*TreeNode, 0)
	queue = append(queue, root)
	for len(queue) > 0 {
		tmp := make([]int, 0)
		q := []*TreeNode{}
		length := len(queue)
		for i := 0; i < length; i++ {
			node := queue[i]
			tmp = append(tmp, node.Val)
			if node.Left != nil {
				q = append(q, node.Left)
			}
			if node.Right != nil {
				q = append(q, node.Right)
			}
		}
		queue = q
		sum := 0
		for _, n := range tmp {
			sum += n
		}
		result = append(result, float64(sum)/float64(len(tmp)))
	}
	return result
}
