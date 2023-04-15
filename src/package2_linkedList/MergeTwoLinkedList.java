package package2_linkedList;

public class MergeTwoLinkedList {
    public ListNode merge(ListNode one, ListNode two) {

        if(one == null || two == null) {
            return one == null ? two : one;
        }

        ListNode curOne = one;
        ListNode curTwo = two;

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while(curOne != null && curTwo != null) {
            if(curOne.val < curTwo.val) {
                cur.next = curOne;
                curOne = curOne.next;
            } else {
                cur.next = curTwo;
                curTwo = curTwo.next;
            }
            cur = cur.next;
        }

        if(curOne != null) {
            cur.next = curOne;
        }
        if(curTwo != null) {
            cur.next = curTwo;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);

        one.next = node2;
        node2.next = node3;
        node3.next = null;

        ListNode two = new ListNode(2);
        ListNode node4 = new ListNode(3);

        two.next = node4;
        node4.next = null;


        MergeTwoLinkedList a = new MergeTwoLinkedList();
        ListNode res = a.merge(one, two);
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
