package leetcode;

/**
 * @ClassName: Code_23
 * @Description: 合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 * <p>
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：lists = [[]]
 * 输出：[]
 * @Author: Admin
 **/

public class Code_23 {

    /**
     * @param lists
     * @Author: Admin
     * @Description: 思路描述：
     * 我们使用一个新的链表来保存合并的链表，每次将该链表和链表数组中的链表进行合并，合并的方法可以采用合并两个排序链表
     * <p>
     * 使用遍历的方式，逐个合并两个有序链表。
     * @return: leetcode.ListNode
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode res = null;
        for (int i = 0; i < lists.length; i++) {
            res = mergeTwoLists(res, lists[i]);
        }
        return res;
    }

    /**
     * @param res
     * @param list
     * @Author: Admin
     * @Description: 合并两个有序链表。
     * 我们使用一个新的链表进行辅助
     * <p>
     * 1. l1.val < l2.val  , 将l1的连接到新的链表的后面，l1 = l1.next
     * 2. l1.val >= l2.val, 将l2的连接到新的链表的后面，l2 = l2.next
     * <p>
     * 最后将剩余部分的链表连接到新的链表的后面，因为链表长度不一样，导致l1结束了l2有剩余
     * @return: leetcode.ListNode
     */
    private static ListNode mergeTwoLists(ListNode res, ListNode list) {
        if (res == null || list == null) {
            return res != null ? res : list;
        }
        ListNode head = new ListNode(0);
        ListNode cur = head;
        ListNode p1 = res;
        ListNode p2 = list;

        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                cur.next = p1;
                p1 = p1.next;
            } else {
                cur.next = p2;
                p2 = p2.next;
            }
            cur = cur.next;
        }
        cur.next = p1 == null ? p2 : p1;
        return head.next;
    }

    /**
     * @param lists
     * @Author: Admin
     * @Description: 采用分治的方法进行合并
     * @return: leetcode.ListNode
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        if (left > right) {
            return null;
        }
        int mid = (left + right) >> 1;
        return mergeTwoLists(merge(lists, left, mid), merge(lists, mid + 1, right));
    }


}