package package2_linkedList;

import java.util.HashSet;
import java.util.Set;

//相交链表
//给你两个单链表的头节点headA和headB，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回null
public class Leetcode160 {
    //Method1:哈希表  TC:O(m+n)   SC:O(m) [m:headA长度 n:headB长度]
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }

        Set<ListNode> seen = new HashSet<>();
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        while(cur1 != null) {
            seen.add(cur1);
            cur1 = cur1.next;
        }

        while(cur2 != null){
            if(seen.contains(cur2)) {
                return cur2;
            }
            cur2 = cur2.next;
        }
        return null;
    }

    //Method2:双指针  TC:O(m+n)   SC:O(1) [m:headA长度 n:headB长度]
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        while(cur1 != cur2) {
            if(cur1 == null){
                cur1 = headB;
            } else {
                cur1 = cur1.next;
            }

            if(cur2 == null) {
                cur2 = headA;
            } else {
                cur2 = cur2.next;
            }
        }
        return cur1;
    }

    public static void main(String[] args) {
        Leetcode160 lee = new Leetcode160();

        ListNode headA = new ListNode(4);
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(8);
        ListNode f = new ListNode(4);
        headA.next = a;
        a.next = b;
        b.next = f;

        ListNode headB = new ListNode(5);
        ListNode c = new ListNode(6);
        ListNode d = new ListNode(1);
        ListNode e = new ListNode(8);
        ListNode g = new ListNode(4);
        headB.next = c;
        c.next = d;
        d.next = e;
        e.next = g;

        ListNode res = lee.getIntersectionNode2(headA, headB);
        System.out.println(res);
    }
}
