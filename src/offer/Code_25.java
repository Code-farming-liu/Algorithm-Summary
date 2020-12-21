package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Test24
 * @Description: 复杂链表的复制
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另
 * 一个特殊指针random指向一个随机节点），
 * 请对此链表进行深拷贝，并返回拷贝后的头结点。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * @Author: Admin
 **/

public class Code_25 {
    /**
     * @param pHead
     * @Author: Admin
     * @Description: 思路描述：
     * 使用HashMap 辅助
     *
     * 我们用哈希表来解决这个问题
     * 首先创建一个哈希表，再遍历原链表，遍历的同时再不断创建新节点
     * 我们将原节点作为key，新节点作为value放入哈希表中
     *
     * 第二步我们再遍历原链表，这次我们要将新链表的next和random指针给设置上
     *
     * 原节点和新节点是一一对应的关系，所以
     *
     * map.get(原节点)，得到的就是对应的新节点
     * map.get(原节点.next)，得到的就是对应的新节点.next
     * map.get(原节点.random)，得到的就是对应的新节点.random
     * 所以，我们只需要再次遍历原链表，然后设置：
     * 新节点.next -> map.get(原节点.next)
     * 新节点.random -> map.get(原节点.random)
     * 这样新链表的next和random都被串联起来了
     * 最后，我们然后map.get(head)，也就是对应的新链表的头节点，就可以解决此问题了。
     * @return: RandomListNode
     */
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