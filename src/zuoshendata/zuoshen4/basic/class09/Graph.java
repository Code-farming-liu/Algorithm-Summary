package zuoshendata.zuoshen4.basic.class09;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @ClassName: Graph
 * @Description: TODO
 * @Author: Admin
 * @Date 2020/12/18 15:49
 **/

public class Graph {
    public HashMap<Integer, Node> nodes;
    public HashSet<Edge> edges;

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}