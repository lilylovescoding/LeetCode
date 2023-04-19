package package3_queue_stack_deque;

import java.sql.SQLOutput;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class DequeInJava {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        Deque<Integer> deque2 = new LinkedList<>();

        deque.offerFirst(1);
        deque.offerFirst(2);
        deque.offerLast(4);
        deque.offerLast(5);

        int size = deque.size();
        for(int i = 0; i < size; i++) {
            if(i % 2 == 0) {
                System.out.println(deque.peekFirst());
                System.out.println(deque.pollFirst());
            } else {
                System.out.println(deque.peekLast());
                System.out.println(deque.pollLast());
            }
        }

        System.out.println(deque.peekFirst());
        System.out.println(deque.pollFirst());
        System.out.println(deque.peekLast());
        System.out.println(deque.pollLast());

    }
}
