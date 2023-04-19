package package3_queue_stack_deque;

import package2_linkedList.ListNode;

public class QueueInOwn_LinkedList {
    private ListNode head;
    private ListNode tail;
    private int size;

    public QueueInOwn_LinkedList() {

    }
    //  1 -> 2 -> 3 -> 4
    //  H              T
    //  R    H
    public Integer poll() {
        if(head == null) {
            return null;
        } else {
            ListNode result = head;
            head = head.next;
            result.next = null;
            size --;
            return result.val;
        }

    }


    // 1 -> 2 -> 3 -> 4 -> 5
    // H              T
    // H                   T
    public boolean offer(int ele) {
        if(head == null) {
            head = new ListNode(ele);
            tail = head;
        } else {
            tail.next = new ListNode(ele);
            tail = tail.next;
        }
        size ++;
        return true;
    }


    public Integer peek() {
        if(head == null) {
            return null;
        }
        return head.val;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }




}
