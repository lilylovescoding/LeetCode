package linkedlist;

public class InsertNode {

    public ListNode insertNode(ListNode head, int target) {
        ListNode newNode = new ListNode(target);

        if(head == null) {
            return newNode;
        }

        if(target <= head.val) {
            newNode.next = head;
            return newNode;
        }

        ListNode cur = head;
        while(cur.next != null && cur.next.val < target) {
            cur = cur.next;
        }
        newNode.next = cur.next;
        cur.next = newNode;
        return head;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        InsertNode a = new InsertNode();
        ListNode res = a.insertNode(node1, 2);
        System.out.println(res);
    }
}
