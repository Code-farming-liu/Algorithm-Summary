package image

/**
给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。

此外，你可以假设该网格的四条边均被水包围。



示例 1：

输入：grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
输出：1
示例 2：

输入：grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
输出：3


提示：

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] 的值为 '0' 或 '1'
*/

func numIslandsDFS(grid [][]byte) int {
	m := len(grid)
	n := len(grid[0])
	visited := make([][]bool, m)
	for i := 0; i < len(visited); i++ {
		visited[i] = make([]bool, n)
	}

	var dfs func(grid [][]byte, visited [][]bool, i, j int)
	dfs = func(grid [][]byte, visited [][]bool, i, j int) {
		if i < 0 || j < 0 || i >= m || j >= n {
			return
		}
		if visited[i][j] || grid[i][j] == '0' {
			return
		}
		visited[i][j] = true
		dfs(grid, visited, i+1, j)
		dfs(grid, visited, i-1, j)
		dfs(grid, visited, i, j+1)
		dfs(grid, visited, i, j-1)
	}

	res := 0
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if !visited[i][j] && grid[i][j] == '1' {
				dfs(grid, visited, i, j)
				res++
			}
		}
	}
	return res
}

type loc struct {
	X int
	Y int
}

func numIslands(grid [][]byte) int {
	m := len(grid)
	n := len(grid[0])
	visited := make([][]bool, m)
	for i := 0; i < len(visited); i++ {
		visited[i] = make([]bool, n)
	}

	var bfs func(i, j int)
	bfs = func(i, j int) {
		queue := make([]loc, 0)
		queue = append(queue, loc{X: i, Y: j})
		visited[i][j] = true
		for len(queue) > 0 {
			cur := queue[0]
			queue = queue[1:]
			dirs := [][]int{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}
			for _, dir := range dirs {
				x := cur.X + dir[0]
				y := cur.Y + dir[1]
				if x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == '1' && !visited[x][y] {
					visited[x][y] = true
					queue = append(queue, loc{X: x, Y: y})
				}
			}
		}
	}
	res := 0
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if !visited[i][j] && grid[i][j] == '1' {
				bfs(i, j)
				res++
			}
		}
	}
	return res
}
