package package2_linkedList;
//【反转链表】：给你单链表的头节点 head ，请你反转链表，并返回反转后的链表
// head = [1,2,3,4,5] => [5,4,3,2,1]
// head = [1,2] => [2,1]
// head = []  =>  []
public class Leetcode206 {
    //TC:O(n)   SC:O(1)
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
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

    public static void main(String[] args) {
        Leetcode206 lee = new Leetcode206();
        ListNode head = new ListNode(1);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(4);
        head.next = a;
        a.next = b;
        b.next = c;
        c.next = null;
        dayin(head); //1-->2-->3-->4-->
        ListNode res = lee.reverseList(head);
        dayin(res); //4-->3-->2-->1-->
    }

    public static void dayin(ListNode head) {
        ListNode cur = head;
        while(cur != null) {
            System.out.print(cur.val+"-->");
            cur = cur.next;
        }
        System.out.println();
    }
}
