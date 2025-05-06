package image

/*
*给你一个大小为 m x n 的二进制矩阵 grid 。

岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。

岛屿的面积是岛上值为 1 的单元格的数目。

计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。

示例 1：

输入：grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
输出：6
解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。
示例 2：

输入：grid = [[0,0,0,0,0,0,0,0]]
输出：0

提示：

m == grid.length
n == grid[i].length
1 <= m, n <= 50
grid[i][j] 为 0 或 1
*/
func maxAreaOfIslandDFS(grid [][]int) int {
	m := len(grid)
	n := len(grid[0])
	visited := make([][]bool, m)
	for i := 0; i < len(visited); i++ {
		visited[i] = make([]bool, n)
	}

	var dfs func(grid [][]int, visited [][]bool, i, j int, count []int)
	dfs = func(grid [][]int, visited [][]bool, i, j int, count []int) {
		if i < 0 || j < 0 || i >= m || j >= n {
			return
		}
		if visited[i][j] || grid[i][j] == 0 {
			return
		}
		visited[i][j] = true
		count[0]++
		dfs(grid, visited, i+1, j, count)
		dfs(grid, visited, i-1, j, count)
		dfs(grid, visited, i, j+1, count)
		dfs(grid, visited, i, j-1, count)
	}

	res := 0
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if !visited[i][j] && grid[i][j] == 1 {
				count := make([]int, 1)
				dfs(grid, visited, i, j, count)
				res = max(res, count[0])
			}
		}
	}
	return res
}

func maxAreaOfIsland(grid [][]int) int {
	m := len(grid)
	n := len(grid[0])
	visited := make([][]bool, m)
	for i := 0; i < len(visited); i++ {
		visited[i] = make([]bool, n)
	}

	type loc struct {
		X int
		Y int
	}
	res := 0
	var bfs func(i, j int, count []int)
	bfs = func(i, j int, count []int) {
		queue := make([]loc, 0)
		visited[i][j] = true
		count[0]++
		queue = append(queue, loc{X: i, Y: j})
		for len(queue) > 0 {
			cur := queue[0]
			queue = queue[1:]
			dirs := [][]int{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}
			for _, dir := range dirs {
				x := cur.X + dir[0]
				y := cur.Y + dir[1]
				if x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == 1 && !visited[x][y] {
					visited[x][y] = true
					queue = append(queue, loc{X: x, Y: y})
					count[0]++
				}
			}
		}
	}

	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if !visited[i][j] && grid[i][j] == 1 {
				count := make([]int, 1)
				bfs(i, j, count)
				res = max(res, count[0])
			}
		}
	}
	return res
}
