package leetcode;

/**
 * @ClassName: Test82
 * Description:排序链表
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 * <p>
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * <p>
 * @Author: Admin
 **/

public class Code_148 {
    /**
     * @param head
     * @Author: Admin
     * @Description: 思路描述
     * 我们采用归并排序的方法，先用快慢指针查找中点，然后从中点分割，
     * 在设置一个新的链表进行合并。
     * @return: ListNode
     */
    public ListNode sortList(ListNode head) {
        //说明遍历结束
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next, slow = head;
        //利用快慢指针寻找中点  1 2 3  slow = 1 fast = 2  fast.next = 3
        // 重新对fast进行赋值 fast = 3 slow = 2 fast.next != null  不满足条件 中点的下标就是 slow = 2
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //保存 中间节点的下一个节点 作为 右边的左边界条件
        ListNode tmp = slow.next;
        //slow.next 置为空 作为分割条件
        slow.next = null;
        //向左递归分解
        ListNode left = sortList(head);
        //向右递归分解
        ListNode right = sortList(tmp);
        //创建一个新的链表 指向新链表的头部
        ListNode h = new ListNode(0);
        //设置头指针 用于保留新链表的头位置
        ListNode res = h;
        //当左边 和 右边有值 进行合并
        while (left != null && right != null) {
            //左边的值小于右边 将左边的值加入到新的链表的下一个
            //对应的 left 向后移 进行遍历
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                //左边的值大于等于右边 将右边的值加入到新的链表的下一个
                //对应的 right 向后移 进行遍历
                h.next = right;
                right = right.next;
            }
            //新链表 对应的指针向后移
            h = h.next;
        }
        //将左和右 剩余的 元素添加到 新链表中
        h.next = left != null ? left : right;
        return res.next;
    }
}
