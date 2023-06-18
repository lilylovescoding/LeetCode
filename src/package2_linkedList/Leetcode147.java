package package2_linkedList;

// [对链表进行插入排序]
// 给定单个链表的头 head ，使用 插入排序 对链表进行排序，并返回 排序后链表的头
public class Leetcode147 {
    //TC:O(n^2). SC:(1)
    public ListNode insertionSortList(ListNode head) {
        if(head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode index = head;
        ListNode cur = head.next;

        while(cur != null){

            if(index.val <= cur.val) {
                index = index.next;
            } else {
                ListNode prev = dummy;
                while(prev.next.val <= cur.val) {
                    prev = prev.next;
                }
                index.next = cur.next;
                cur.next = prev.next;
                prev.next = cur;
            }
            cur = index.next;
        }
        return dummy.next;
    }
}
