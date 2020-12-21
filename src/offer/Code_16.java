package offer;

/**
 * @ClassName: Test16
 * @Description: 合并两个排序链表
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * @Author: Admin
 **/

public class Code_16 {
    /**
     * @param list1
     * @param list2
     * @Author: Admin
     * @Description: 思路描述：
     * 我们首先从题目中可以知道，是两个排序的链表，我们可以使用双指针加一个辅助的链表辅助遍历
     * 我们设置 p1 = list1,p2 = list2
     * 之后判断对应的值的大小，
     * 如果list1.val <= list2.val 将对应的list1加入到新链表中，
     * 否则将list2加入到新的链表中
     * 注意我们考虑一种情况 list1的长度小于list2长度，因此list1结束之后并不代表结束，
     * 而是需要将另一个链表中剩余部分加入到新的链表中，最后返回新的链表
     * @return: offer.ListNode
     */
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode resHead = new ListNode(0);
        ListNode res = resHead;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                res.next = list1;
                list1 = list1.next;
            } else {
                res.next = list2;
                list2 = list2.next;
            }
            res = res.next;
        }
        res.next = list1 == null ? list2 : list1;
        return resHead.next;
    }
}