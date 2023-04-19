package package3_queue_stack_deque;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueInJava {
    public static void main(String[] args) {

        //1.ArrayDeque -> 常用
        Queue<Integer> queue = new ArrayDeque<>();

        //2.LinkedList -> 不常用
        Queue<Integer> queue2 = new LinkedList<>();

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        while(!queue.isEmpty()) {
            System.out.println(queue.peek());
            System.out.println(queue.poll());
        }

        System.out.println(queue.peek());
        System.out.println(queue.poll());
    }
}
