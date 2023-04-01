package linkedlist;

public class Append {
    //在头部添加一个元素
    public ListNode appendHead(ListNode head, int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        return newNode;
    }

    //在尾部添加一个元素
    public ListNode appendTail(ListNode head, int val) {
        ListNode newNode = new ListNode(val);

        if(head == null) {
            return newNode;
        }

        ListNode cur = head;
        while(cur.next != null) {
            cur = cur.next;
        }
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


        //在头部添加一个元素
        Append h = new Append();
        ListNode res1 = h.appendHead(node1, 0);
        System.out.println(res1);   //打印链表的方法再找找

        //在尾部添加一个元素
        Append t = new Append();
        ListNode res2 = t.appendTail(node1, 4);
        System.out.println(res2);   //打印链表的方法再找找
    }


}
