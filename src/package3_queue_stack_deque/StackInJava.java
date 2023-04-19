package package3_queue_stack_deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class StackInJava {
    public static void main(String[] args) {
        //ArrayDeque写法 -> 常用
        Deque<Integer> stack = new ArrayDeque<>();
        //LinkedList写法 -> 很少用
        Deque<Integer> stack2 = new LinkedList<>();

        stack.offerFirst(1);
        stack.offerFirst(2);
        stack.offerFirst(3);

        while(!stack.isEmpty()) {
            System.out.println(stack.peekFirst());
            System.out.println(stack.pollFirst());
        }

        System.out.println(stack.peekFirst());
        System.out.println(stack.pollFirst());
    }
}
