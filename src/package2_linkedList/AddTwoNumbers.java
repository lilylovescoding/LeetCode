package package2_linkedList;

public class AddTwoNumbers {
    public ListNode add(ListNode one, ListNode two) {
        ListNode a = reverse(one);
        ListNode b = reverse(two);

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int val = 0;

        while(a != null || b != null || val != 0) {
            if(a != null) {
                val += a.val;
                a = a.next;
            }
            if(b != null) {
                val += b.val;
                b = b.next;
            }

            cur.next = new ListNode(val % 10);
            val = val/10;
            cur = cur.next;
        }
        return reverse(dummy.next);
    }

    public ListNode reverse(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;

        while(head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }


    public static void main(String[] args) {
        ListNode one = new ListNode(3);
        ListNode one2 = new ListNode(4);
        ListNode one3 = new ListNode(2);
        one.next = one2;
        one2.next = one3;
        one3.next = null;

        ListNode two = new ListNode(4);
        ListNode two2 = new ListNode(6);
        ListNode two3 = new ListNode(5);
        two.next = two2;
        two2.next = two3;
        two3.next = null;

        dayin(one);
        dayin(two);

        AddTwoNumbers a = new AddTwoNumbers();
        ListNode res = a.add(one, two);
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
