package package3_queue_stack_deque;

import package2_linkedList.ListNode;

public class StackInOwn_LinkedList {
    private ListNode head;
    private int size;

    public StackInOwn_LinkedList() {
        this.head = null;
        this.size = 0;
    }


    //实现pop方法
    public Integer pop() {
        if(head == null) {
            return null;
        }

        ListNode result = head;
        head = head.next;
        result.next = null;
        size--;
        return result.val;
    }

    //实现peek方法
    public Integer peek() {
        if(head == null) {
            return null;
        }
        return head.val;
    }

    //实现push方法
    public boolean push(int element) {

        ListNode newHead = new ListNode(element);
        newHead.next = head;
        head = newHead;
        size++;
        return true;
    }

//    public int size() {
//        return size;
//    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {

        StackInOwn_LinkedList a = new StackInOwn_LinkedList();
        boolean res1 = a.push(2);
        boolean res11 = a.push(4);
        System.out.println(res1);

        int res2 = a.peek();
        System.out.println(res2);

        int res3 = a.pop();
        System.out.println(res3);


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
