package package2_linkedList;


public class ReorderLinkedList {
    public ListNode reorder(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMiddle(head);
        ListNode node1 = head;
        ListNode node2 = mid.next;
        mid.next = null;
        return merge(node1, reverse(node2));
    }

    public ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode merge(ListNode node1, ListNode node2) {

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while ( node1 != null || node2 != null) {
            cur.next = node1;
            node1= node1.next;
            cur.next.next = node2;
            node2 = node2.next;

            cur = cur.next.next;
        }
        if(node1 != null) {
            cur.next = node1;
        } else {
            cur.next = node2;
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        while(head != null ) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        dayin(head);

        ReorderLinkedList a = new ReorderLinkedList();
        ListNode res = a.reorder(head);
        dayin(res);
    }

    public static void dayin(ListNode head) {
        ListNode cur = head;
        while(cur != null) {
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
        System.out.println();
    }
}
