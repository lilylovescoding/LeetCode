package package2_linkedList;

public class RemoveEle {
    public ListNode removeNode(ListNode head, int target) {
        if(head == null) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode cur = head;

        while(cur != null) {
            if(cur.val == target) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        dayin(node1);

        RemoveEle a = new RemoveEle();
        ListNode res = a.removeNode(node1, 2);
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
