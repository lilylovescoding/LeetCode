package package3_queue_stack_deque;

import package2_linkedList.ListNode;

public class QueueInOwn_LinkedList {
    private ListNode head;
    private ListNode tail;
    private int size;

    public QueueInOwn_LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public ListNode offer(int ele) {
        if(head == null) {
            head = new ListNode(ele);
            tail = head;
        } else {
            tail.next = new ListNode(ele);
            tail = tail.next;
        }
        size ++;
        return head;
    }

    public Integer peek() {
        if(head == null) {
            return null;
        }
        return head.val;
    }

    public ListNode poll() {
        if(head == null) {
            return null;
        } else {
            ListNode result = head;
            head = head.next;
            result.next = null;
            size --;
            return head;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        QueueInOwn_LinkedList s = new QueueInOwn_LinkedList();
        dayin(s.head);

        s.offer(1);
        s.offer(2);
        s.offer(3);
        dayin(s.head);

        int peek = s.peek();
        System.out.println(peek);

        s.poll();
        dayin(s.head);
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
