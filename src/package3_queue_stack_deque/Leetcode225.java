package package3_queue_stack_deque;
import java.util.*;

//【用两个队列实现栈】：使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）
//TC:O(n)  SC:O(n)
class Leetcode225 {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public Leetcode225() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q2.offer(x);
        while(!q1.isEmpty()){
            q2.offer(q1.poll());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() {
        return q1.poll();
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        Leetcode225 lt = new Leetcode225();
        lt.push(8);
        lt.push(6);
        lt.push(4);
        System.out.println(lt.top());  //4
        System.out.println(lt.pop());  //4
        System.out.println(lt.empty()); //false
        System.out.println(lt.pop());  //6
        System.out.println(lt.pop());  //8
        System.out.println(lt.empty());  //true
    }
}
