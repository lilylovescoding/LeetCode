package package2_linkedList;
import java.util.*;

//【环形链表】：给一个链表的头节点head，判断链表中是否有环
//head = [3,2,0,-4], pos = 1 => true
// head = [1], pos = -1 => false
public class Leetcode141 {

    //Method1:快慢指针  TC:O(n)   SC:O(1)
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;  //fast在head的next

        while(slow != fast) {
            if(fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    //Method2:哈希表   TC:O(n)   SC:O(n)
    public boolean hasCycle2(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        while(head != null) {
            if(!seen.contains(head)){
                seen.add(head);
            }else{
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args) {
        Leetcode141 lee = new Leetcode141();
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(0);
        ListNode d = new ListNode(-4);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = b;
        boolean res = lee.hasCycle2(a);
        System.out.println(res);
    }
}
