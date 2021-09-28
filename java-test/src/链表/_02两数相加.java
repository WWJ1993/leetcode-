package 链表;
/*
* 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。

请你将两个数相加，并以相同形式返回一个表示和的链表。

你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

 

示例 1：


输入：l1 = [2,4,3], l2 = [5,6,4]
输出：[7,0,8]
解释：342 + 465 = 807.
示例 2：

输入：l1 = [0], l2 = [0]
输出：[0]
示例 3：

输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
输出：[8,9,9,9,0,0,0,1]
 

提示：

每个链表中的节点数在范围 [1, 100] 内
0 <= Node.val <= 9
题目数据保证列表表示的数字不含前导零

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-two-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class _02两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return  l1;
        ListNode newHead = new ListNode(0);
        ListNode nextNode = newHead;
        int carry = 0;
        while (l1 != null ||l2 != null){
            int v1 = 0,v2 =0;
            if (l1 != null){
                v1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                v2 = l2.val;
                l2 = l2.next;
            }
            int sum = v1+v2+carry;
            carry = sum/10;
            nextNode.next = new ListNode(sum%10);
            nextNode = nextNode.next;
        }
        if (carry>0) nextNode.next = new ListNode(carry);
        return newHead.next;
    }
}
