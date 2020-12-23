package leetcode;


/**
 * @ClassName: Test49
 * @Description: 两数相加
 * * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
 * * 并且它们的每个节点只能存储 一位 数字。
 * * <p>
 * * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * * <p>
 * * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * * <p>
 * * 示例：
 * * <p>
 * * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * * 输出：7 -> 0 -> 8
 * * 原因：342 + 465 = 807
 * @Author: Admin
 **/

public class Code_02 {
    /**
     * @param l1
     * @param l2
     * @Author: Admin
     * @Description: 思路描述：
     * 我们需要创建一个新的链表辅助我们遍历，我们只用判断两数之和。以及考虑进位
     * 我们可以使用 对应的和 除以 10 表示进位 例如 15 / 10 = 1 ---> 进位为1
     * 对应的 15 下一个链表中应该存储的数值 用 sum 对 10 取余数只能是 15 % 10 = 5 ---> 存储的元素为 5
     * 我们还要注意一点
     * 个位数与个位数相加 进位最多为 1 例如 9 + 9 = 18 ----- 18 / 10 = 1
     * 如果最后两位数 为 4 + 5 + 1 = 10 ---> 进位 为 1这个也需要加上对应的 进位 不能丢弃（惨痛的教训）
     * @return: ListNode
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //设置头结点
        ListNode head = new ListNode(0);
        //辅助遍历
        ListNode cur = head;
        //进位
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = (l1 == null) ? 0 : l1.val;
            int y = (l2 == null) ? 0 : l2.val;
            int sum = x + y + carry;
            //进位
            carry = sum / 10;
            //求链表中应该存储什么值
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            } else {
                l2 = l2.next;
            }
        }
        //如果最后一位进位还有值 直接加在后面即可 因为 个位数 相加进位最大只能是1
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        return head.next;
    }
}
