package package2_linkedList;

public class Palindrome {
    public boolean checkIfPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }

        ListNode mid = findMiddle(head);
        ListNode one = head;
        ListNode two = reverse(mid.next);

        while (two != null) {
            if(one.val != two.val) {
                return false;
            }
            one = one.next;
            two = two.next;
        }
        return true;

    }
    public ListNode findMiddle(ListNode head) {
        if(head == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        //ListNode node5 = new ListNode(2);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
       // node4.next = node5;

        Palindrome a = new Palindrome();
        boolean res = a.checkIfPalindrome(node1);

        System.out.println(res);
    }


}
