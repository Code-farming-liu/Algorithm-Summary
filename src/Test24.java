import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Test24
 * @Description: 题目描述
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另
 * 一个特殊指针random指向一个随机节点），
 * 请对此链表进行深拷贝，并返回拷贝后的头结点。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * @Author: Admin
 **/

public class Test24 {
    public RandomListNode Clone(RandomListNode pHead) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode temp = pHead;
        while (temp != null) {
            map.put(temp, new RandomListNode(temp.label));
            temp = temp.next;
        }
        temp = pHead;
        while (temp != null) {
            RandomListNode node = map.get(temp);
            if (temp.next != null) {
                node.next = map.get(temp.next);
            }
            if (temp.random != null) {
                node.random = map.get(temp.random);
            }
            temp = temp.next;
        }
        return map.get(pHead);
    }
}