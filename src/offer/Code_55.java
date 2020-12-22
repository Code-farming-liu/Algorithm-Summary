package offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: Test46
 * @Description: 链表中环的入口节点
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * @Author: Admin
 **/

public class Code_55 {
    /**
     * @param pHead
     * @Author: Admin
     * @Description: 思路描述：
     * 我们使用 set 集合辅助遍历 然后判断是否存在该节点，
     * 存在则直接返回
     * 否则 添加进去set集合
     * @return: offer.ListNode
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) {
            return pHead;
        }
        Set<ListNode> set = new HashSet<>();
        while (pHead != null) {
            if (set.contains(pHead)) {
                return pHead;
            } else {
                set.add(pHead);
            }
            pHead = pHead.next;
        }
        return pHead;
    }
}
