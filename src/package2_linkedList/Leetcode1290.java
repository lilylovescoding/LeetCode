package package2_linkedList;

//【二进制链表转整数】：给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。请你返回该链表所表示数字的 十进制值
// head = [1,0,1] => 5 [转换方法：101 => 1*2^2 + 0:2^1 + 1*2^0 = 5]
// head = [0] => 0
// head = [1] => 1
// head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0] => 18880
// head = [0,0] => 0
public class Leetcode1290 {
    //TC:O(n)  SC:O(1)
    public int getDecimalValue(ListNode head) {
        ListNode cur = head;
        int res = 0;
        while(cur != null) {
            res = res * 2 + cur.val;
            cur = cur.next;
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode1290 lee = new Leetcode1290();
        ListNode head = new ListNode(1);
        ListNode a = new ListNode(0);
        ListNode b = new ListNode(1);
        head.next = a;
        a.next = b;
        dayin(head);  //1-->0-->1-->
        int res = lee.getDecimalValue(head);
        System.out.println(res); //5
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
