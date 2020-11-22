import java.util.*;

/**
 * @ClassName: Test90
 * @Description: TODO
 * @Author: Admin
 * @Date 2020/11/22 14:21
 **/

public class Test90 {
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return false;
        }
        //邻接表表示
        HashSet<Integer>[] graph = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new HashSet<>();
        }
        //入度表
        int[] inDegree = new int[numCourses];
        //遍历prerequisites 将入度表和邻接表都填上
        for (int[] p : prerequisites) {
            graph[p[1]].add(p[0]);
            inDegree[p[0]]++;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.addLast(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            //当前入度为0的节点
            Integer inDegreeNode = queue.removeFirst();
            res.add(inDegreeNode);
            //从图中删除入度为0的结点
            //得到所有的后继课程，接下来把它们的入度都减一
            HashSet<Integer> nextCourses = graph[inDegreeNode];
            for (Integer nextCourse : nextCourses) {
                //每一个后继节点入度减一
                inDegree[nextCourse]--;
                //马上检测该节点的入度是否为0，如果为0，马上加入队列
                if (inDegree[nextCourse] == 0) {
                    queue.addLast(nextCourse);
                }
            }
        }
        if (res.size() == numCourses) {
            return true;
        } else {
            return false;
        }
    }
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        // Get the indegree and adjacency of every course.
        for (int[] cp : prerequisites) {
            indegrees[cp[0]]++;
            adjacency.get(cp[1]).add(cp[0]);
        }
        // Get all the courses with the indegree of 0.
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }
        // BFS TopSort.
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            for (int cur : adjacency.get(pre)) {
                if (--indegrees[cur] == 0) {
                    queue.add(cur);
                }
            }
        }
        return numCourses == 0;
    }

    /**
     * 借助一个标志列表 flags，用于判断每个节点 i （课程）的状态：
     * 未被 DFS 访问：i == 0；
     * 已被其他节点启动的 DFS 访问：i == -1；
     * 已被当前节点启动的 DFS 访问：i == 1。
     * 对 numCourses 个节点依次执行 DFS，判断每个节点起步 DFS 是否存在环，若存在环直接返回 False。DFS 流程；
     * 终止条件：
     * 当 flag[i] == -1，说明当前访问节点已被其他节点启动的 DFS 访问，无需再重复搜索，直接返回 True。
     * 当 flag[i] == 1，说明在本轮 DFS 搜索中节点 i 被第 2 次访问，即 课程安排图有环 ，直接返回 False。
     * 将当前访问节点 i 对应 flag[i] 置 1，即标记其被本轮 DFS 访问过；
     * 递归访问当前节点 i 的所有邻接节点 j，当发现环直接返回 False；
     * 当前节点所有邻接节点已被遍历，并没有发现环，则将当前节点 flag 置为 -1 并返回 True。
     * 若整个图 DFS 结束并未发现环，返回 True。
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        int[] flags = new int[numCourses];
        for (int[] cp : prerequisites) {
            adjacency.get(cp[1]).add(cp[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(adjacency, flags, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
        if (flags[i] == 1) {
            return false;
        }
        if (flags[i] == -1) {
            return true;
        }
        flags[i] = 1;
        for (Integer j : adjacency.get(i)) {
            if (!dfs(adjacency, flags, j)) {
                return false;
            }
        }
        flags[i] = -1;
        return true;
    }

}