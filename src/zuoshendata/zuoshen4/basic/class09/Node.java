package zuoshendata.zuoshen4.basic.class09;

import java.util.ArrayList;

/**
 * @ClassName: class09
 * @Description: 点结构的描述
 * @Author: Admin
 * @Date 2020/12/18 15:37
 **/

public class Node {
    public int value;
    public int in;
    public int out;
    public ArrayList<Node> nexts;
    public ArrayList<Edge> edges;

    public Node(int value) {
        this.value = value;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}