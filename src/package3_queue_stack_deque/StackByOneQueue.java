package package3_queue_stack_deque;
import java.util.ArrayDeque;
import java.util.Queue;

public class StackByOneQueue {
    public int stackbyqueue(Queue<Integer> input) {
        int length = input.size();
        for(int i = 1; i < length; i++) {
            int cur = input.poll();
            input.offer(cur);
        }
        return input.poll();
    }

    public static void main(String[] args) {
        StackByOneQueue s = new StackByOneQueue();
        Queue<Integer> input = new ArrayDeque<>();
        input.offer(1);
        input.offer(2);
        input.offer(3);
        System.out.println(input);
        System.out.println(input.peek());

        int res = s.stackbyqueue(input);
        System.out.println(res);

        int res2 = s.stackbyqueue(input);
        System.out.println(res2);

        int res3 = s.stackbyqueue(input);
        System.out.println(res3);
    }
}
