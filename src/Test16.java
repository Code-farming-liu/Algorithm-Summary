/**
 * @ClassName: Test16
 * @Description: 题目描述
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * @Author: Admin
 **/

public class Test16 {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode resHead = new ListNode(0);
        ListNode res = resHead;
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val){
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