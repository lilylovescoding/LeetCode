package package3_queue_stack_deque;

import java.util.*;

//【用两个栈实现队列】：使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）
//TC:均摊O(1)  SC:O(n)
public class Leetcode232 {
    Deque<Integer> s1;
    Deque<Integer> s2;

    public Leetcode232() {
        s1 = new ArrayDeque<>();
        s2 = new ArrayDeque<>();
    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        if(s2.isEmpty()) {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    public int peek() {
        if(s2.isEmpty()) {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    public static void main(String[] args) {
        Leetcode232 lt = new Leetcode232();
        lt.push(1);  //[1]
        lt.push(2);  //[1,2]
        lt.push(3);  //[1,2,3]
        System.out.println(lt.peek());  //1
        System.out.println(lt.pop());   //1
        System.out.println(lt.empty());  //false
        System.out.println(lt.pop());  //2
        System.out.println(lt.pop());  //3
        System.out.println(lt.empty());  //true
    }
}
