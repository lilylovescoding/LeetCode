package linkedlist;

import array_arraylist.ElementDeduplication;

public class CountLength {
    public int count(ListNode head) {
        if (head == null) {
            return 0;
        }

        int count = 0;
        ListNode cur = head;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        CountLength c = new CountLength();
        int res = c.count(node1);
        System.out.println(res);

    }
}
