package linkedlist;

import array_arraylist.ElementDeduplication;

public class FindElement {

    //找到index为k的元素
    public ListNode findindexofelement(ListNode head, int k) {
        if(head == null) {
            return head;
        }

        int index = 0;
        ListNode cur = head;
        while(cur != null) {
            if( index == k) {
                return cur;
            }
            cur = cur.next;
            index++;
        }
        return cur;
    }

    //找到链表的中点
    public ListNode findMiddleNode(ListNode head) {
        if(head == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        FindElement c = new FindElement();
        ListNode res = c.findindexofelement(node1, 2);
        System.out.println(res.val);

        FindElement m = new FindElement();
        ListNode resmid = m.findMiddleNode(node1);
        System.out.println(resmid.val);
    }
}
