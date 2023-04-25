package package3_queue_stack_deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class StackByOneQueue {
    public int stackbyqueue(Queue<Integer> input) {
        while(!input.isEmpty()) {
            int cur = input.poll();
            input.offer(cur);

        }
        return input.poll();
    }

    public static void main(String[] args) {
        StackByOneQueue s = new StackByOneQueue();
        Queue<Integer> input = new ArrayDeque<>();
        s.stackbyqueue(input);
    }
}
