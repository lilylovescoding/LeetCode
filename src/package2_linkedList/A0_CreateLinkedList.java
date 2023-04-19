package package2_linkedList;

public class A0_CreateLinkedList {
    public class ListNode {
        int val;
        package2_linkedList.ListNode next;
        ListNode() {};
        ListNode(int val) { this.val = val;}
        ListNode(int val, package2_linkedList.ListNode next) { this.val = val; this.next = next;}
    }

    public static void main(String[] args) {
        package2_linkedList.ListNode node1 = new package2_linkedList.ListNode(1);
        package2_linkedList.ListNode node2 = new package2_linkedList.ListNode(2);
        package2_linkedList.ListNode node3 = new package2_linkedList.ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        dayin(node1);
    }

    private static void dayin(package2_linkedList.ListNode res){
        package2_linkedList.ListNode cur = res ;
        while(cur!=null){
            System.out.print(cur.val+"-->");
            cur=cur.next;
        }
        System.out.println();
    }
}
