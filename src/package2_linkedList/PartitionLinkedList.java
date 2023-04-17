package package2_linkedList;

public class PartitionLinkedList {
    public ListNode partition(ListNode head, int target) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);

        ListNode curSmall = small;
        ListNode curLarge = large;

        while(head != null) {
            if(head.val < target) {
                curSmall.next = head;
                curSmall = curSmall.next;
            } else {
                curLarge.next = head;
                curLarge = curLarge.next;
            }
            head = head.next;
        }
        curSmall.next = large.next;
        curLarge.next = null;
        return small.next;

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(7);
        ListNode node3 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        dayin(node1);

        PartitionLinkedList a = new PartitionLinkedList();
        ListNode res = a.partition(node1, 5);

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
