package zuoshendata.zuoshen4.basic.class06;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName: 并查集
 * @Description: TODO
 * @Author: Admin
 * @Date 2020/12/17 15:56
 **/

public class 并查集 {
    public static class Node {
        // 随便什么都可以
    }

    public static class UnionFindSet {
        // key ： child
        // value ： parent
        public HashMap<Node, Node> fatherMap = null;
        // 某个节点 所在集合有多少个节点
        public HashMap<Node, Integer> sizeMap = null;

        public UnionFindSet(List<Node> nodes) {
//            fatherMap = new HashMap<>();
//            sizeMap = new HashMap<>();
            makeSets(nodes);
        }

        private void makeSets(List<Node> nodes) {
//            fatherMap.clear();
//            sizeMap.clear();
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
            for (Node node : nodes) {
                fatherMap.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        private Node findHead(Node node) {
            Stack<Node> stack = new Stack<>();
            Node cur = node;
            Node parent = fatherMap.get(cur);
            while (cur != parent) {
                stack.push(cur);
                cur = parent;
                parent = fatherMap.get(cur);
            }

            while (!stack.isEmpty()) {
                fatherMap.put(stack.pop(), parent);
            }
            return parent;
//            Node father = fatherMap.get(node);
//            if (father != node) {
//                father = findHead(father);
//            }
//            fatherMap.put(node, father);
//            return father;
        }

        // 查询节点是否在同一个集合之中
        private boolean isSameSet(Node a, Node b) {
            return findHead(a) == findHead(b);
        }

        // 合并两个链表
        public void union(Node a, Node b) {
            if (a == null || b == null) {
                return;
            }
            Node aHead = findHead(a);
            Node bHead = findHead(b);
            if (aHead != bHead) {
                Integer aSetSize = sizeMap.get(aHead);
                Integer bSetSize = sizeMap.get(bHead);
                if (aSetSize <= bSetSize) {
                    fatherMap.put(aHead, bHead);
                    sizeMap.put(bHead, bSetSize + aSetSize);
                } else {
                    fatherMap.put(bHead, aHead);
                    sizeMap.put(aHead, bSetSize + aSetSize);
                }
            }
        }
    }
}

// 并查集
class UnionFind {
    int[] roots;
    int size; // 集合数量

    public UnionFind(int n) {
        roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }
        size = n;
    }

    public int find(int i) {
        if (i == roots[i]) {
            return i;
        }
        return roots[i] = find(roots[i]);
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot != qRoot) {
            roots[pRoot] = qRoot;
            size--;
        }
    }
}