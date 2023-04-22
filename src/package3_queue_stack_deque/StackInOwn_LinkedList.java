package package3_queue_stack_deque;
import package2_linkedList.ListNode;

public class StackInOwn_LinkedList {
    private ListNode head;
    private int size;

    public StackInOwn_LinkedList() {
        this.head = null;
        this.size = 0;
    }

    //实现push方法
    public ListNode push(int element) {
        ListNode newHead = new ListNode(element);
        newHead.next = head;
        head = newHead;
        size++;
        return head;
    }

    //实现peek方法
    public Integer peek() {
        if(head == null) {
            return null;
        }
        return head.val;
    }

    //实现pop方法
    public ListNode pop() {
        if(head == null) {
            return null;
        }

        ListNode result = head;
        head = head.next;
        result.next = null;
        size--;
        return result;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        StackInOwn_LinkedList a = new StackInOwn_LinkedList();
        dayin(a.head);
        a.push(1);
        a.push(2);
        a.push(3);

        dayin(a.head);
        System.out.println(a.peek());
        a.pop();
        dayin(a.head);
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
