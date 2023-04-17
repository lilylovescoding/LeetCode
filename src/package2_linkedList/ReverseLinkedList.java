package package2_linkedList;

public class ReverseLinkedList {

    //迭代的写法
    public ListNode reverse(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode cur = head;

        while(cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    //递归的写法
    public ListNode reverse2(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverse2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        dayin(node1);

        ReverseLinkedList a = new ReverseLinkedList();
        ListNode res = a.reverse(node1);
        dayin(res);
    }

    private static void dayin(ListNode res){
        ListNode cur = res ;
        while(cur!=null){
            System.out.print(cur.val+"-->");
            cur=cur.next;
        }
        System.out.println();
    }


}
