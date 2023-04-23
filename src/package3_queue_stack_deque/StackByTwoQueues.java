package package3_queue_stack_deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackByTwoQueues {
    public int stackbyqueues(Deque<Integer> input, Deque<Integer> buffer) {
        int res = 0;
        while (!input.isEmpty()) {
            res = input.peekFirst();
            while(!input.isEmpty()) {
                int cur = input.pollFirst();
                if (cur != res) {
                    buffer.offerFirst(cur);
                }
            }

        }

        while(!buffer.isEmpty()) {
            int tmp = buffer.pollFirst();
            input.offerFirst(tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        StackByTwoQueues s = new StackByTwoQueues();
        Deque<Integer> input;
        Deque<Integer> buffer = new ArrayDeque<>();
        input = new ArrayDeque<>();
        input.offerFirst(8);
        input.offerFirst(4);
        input.offerFirst(6);
        System.out.println(input);

        int ans = s.stackbyqueues(input, buffer);
        System.out.println(ans);
        System.out.println(input);

        int ans2 = s.stackbyqueues(input, buffer);
        System.out.println(ans2);
        System.out.println(input);
    }
}
