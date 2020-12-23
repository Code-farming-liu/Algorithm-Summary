package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @ClassName: Test91
 * Description: 课程表 II
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 * <p>
 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 * <p>
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2, [[1,0]]
 * 输出: [0,1]
 * 解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 * 示例 2:
 * <p>
 * 输入: 4, [[1,0],[2,0],[3,1],[3,2]]
 * 输出: [0,1,2,3] or [0,2,1,3]
 * 解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 *      因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
 * 说明:
 * <p>
 * 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * <p>
 * @Author: Admin 
 **/

public class Code_210 {
    //拓扑排序
    /**
     * 1、在开始排序前，扫描对应的存储空间（使用邻接表），将入度为 0 的结点放入队列。
     * <p>
     * 2、只要队列非空，就从队首取出入度为 0 的结点，将这个结点输出到结果集中，并且将这个结点的所有邻接结点（它指向的结点）的入度减 11，在减 11 以后，如果这个被减 11 的结点的入度为 00 ，就继续入队。
     * <p>
     * 3、当队列为空的时候，检查结果集中的顶点个数是否和课程数相等即可。
     * <p>
     * （思考这里为什么要使用队列？如果不用队列，还可以怎么做，会比用队列的效果差还是更好？）
     * <p>
     * 在代码具体实现的时候，除了保存入度为 0 的队列，我们还需要两个辅助的数据结构：
     * <p>
     * 1、邻接表：通过结点的索引，我们能够得到这个结点的后继结点；
     * <p>
     * 2、入度数组：通过结点的索引，我们能够得到指向这个结点的结点个数。
     * <p>
     * 这个两个数据结构在遍历题目给出的邻边以后就可以很方便地得到。
     */
    public int[] findOrder1(int numCourses, int[][] prerequisites) {
        // 先处理极端情况
        if (numCourses <= 0) {
            return new int[0];
        }
        // 邻接表表示
        HashSet<Integer>[] graph = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new HashSet<>();
        }
        // 入度表
        int[] inDegree = new int[numCourses];
        // 遍历 prerequisites 的时候，把 邻接表 和 入度表 都填上
        for (int[] p : prerequisites) {
            //因为[a,b] 代表b是课程 a的先修课程。这可以用一条 有向边 b ➔ a 表示。 所以应该是p[1] -> p[0]
            graph[p[1]].add(p[0]);
            inDegree[p[0]]++;//对应的入度加一
        }
        //队列保存入度为0的结点
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.addLast(i);
            }
        }
        //结果集合
        ArrayList<Integer> res = new ArrayList<>();

        while (!queue.isEmpty()) {
            // 当前入度为 0 的结点
            Integer inDegreeNode = queue.removeFirst();
            // 加入结果集中
            res.add(inDegreeNode);
            // 下面从图中删去
            // 得到所有的后继课程，接下来把它们的入度全部减去 1
            HashSet<Integer> nextCourses = graph[inDegreeNode];
            for (Integer nextCourse : nextCourses) {
                inDegree[nextCourse]--;
                // 马上检测该结点的入度是否为 0，如果为 0，马上加入队列
                if (inDegree[nextCourse] == 0) {
                    queue.addLast(nextCourse);
                }
            }
        }
        // 如果结果集中的数量不等于结点的数量，就不能完成课程任务，这一点是拓扑排序的结论
        int resLen = res.size();
        if (resLen == numCourses) {
            int[] ret = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                ret[i] = res.get(i);
            }
            return ret;
        } else {
            return new int[0];
        }
    }

    /**
     * 第 1 步：构建逆邻接表；
     * <p>
     * 第 2 步：递归处理每一个还没有被访问的结点，具体做法很简单：对于一个结点来说，先输出指向它的所有顶点，再输出自己。
     * <p>
     * 第 3 步：如果这个顶点还没有被遍历过，就递归遍历它，把所有指向它的结点都输出了，再输出自己。
     * 注意：当访问一个结点的时候，应当先递归访问它的前驱结点，直至前驱结点没有前驱结点为止。
     *
     * @param
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            // 连课程数目都没有，就根本没有办法完成练习了，根据题意应该返回空数组
            return new int[0];
        }
        int plen = prerequisites.length;
        if (plen == 0) {
            // 没有有向边，则表示不存在课程依赖，任务一定可以完成
            int[] ret = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                ret[i] = i;
            }
            return ret;
        }
        int[] marked = new int[numCourses];
        // 初始化有向图 begin
        HashSet<Integer>[] graph = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new HashSet<>();
        }
        // 初始化有向图 end
        // 有向图的 key 是前驱结点，value 是后继结点的集合
        for (int[] p : prerequisites) {
            graph[p[1]].add(p[0]);
        }
        // 使用 Stack 或者 List 记录递归的顺序，这里使用 Stack
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, graph, marked, stack)) {
                // 注意方法的语义，如果图中存在环，表示课程任务不能完成，应该返回空数组
                return new int[0];
            }
        }
        // 在遍历的过程中，一直 dfs 都没有遇到已经重复访问的结点，就表示有向图中没有环
        // 所有课程任务可以完成，应该返回 true
        // 下面这个断言一定成立，这是拓扑排序告诉我们的结论
        assert stack.size() == numCourses;
        int[] ret = new int[numCourses];
        // 想想要怎么得到结论，我们的 dfs 是一致将后继结点进行 dfs 的
        // 所以压在栈底的元素，一定是那个没有后继课程的结点
        // 那个没有前驱的课程，一定在栈顶，所以课程学习的顺序就应该是从栈顶到栈底
        // 依次出栈就好了
        for (int i = 0; i < numCourses; i++) {
            ret[i] = stack.pop();
        }
        return ret;
    }

    /**
     * 注意这个 dfs 方法的语义
     *
     * @param i      当前访问的课程结点
     * @param graph
     * @param marked 如果 == 1 表示正在访问中，如果 == 2 表示已经访问完了
     * @return true 表示图中存在环，false 表示访问过了，不用再访问了
     */
    private boolean dfs(int i,
                        HashSet<Integer>[] graph,
                        int[] marked,
                        Stack<Integer> stack) {
        // 如果访问过了，就不用再访问了
        if (marked[i] == 1) {
            // 从正在访问中，到正在访问中，表示遇到了环
            return true;
        }
        if (marked[i] == 2) {
            // 表示在访问的过程中没有遇到环，这个节点访问过了
            return false;
        }
        // 走到这里，是因为初始化呢，此时 marked[i] == 0
        // 表示正在访问中
        marked[i] = 1;
        // 后继结点的集合
        HashSet<Integer> successorNodes = graph[i];
        for (Integer successor : successorNodes) {
            if (dfs(successor, graph, marked, stack)) {
                // 层层递归返回 true ，表示图中存在环
                return true;
            }
        }
        // i 的所有后继结点都访问完了，都没有存在环，则这个结点就可以被标记为已经访问结束
        // 状态设置为 2
        marked[i] = 2;
        stack.add(i);
        // false 表示图中不存在环
        return false;
    }
}
