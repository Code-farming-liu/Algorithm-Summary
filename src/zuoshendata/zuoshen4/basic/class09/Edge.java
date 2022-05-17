package zuoshendata.zuoshen4.basic.class09;

/**
 * @ClassName: Edge
 * @Description: TODO
 * @Author: Admin
 * @Date 2020/12/18 15:39
 **/

public class Edge {
    public int weight;
    public Node from;
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}