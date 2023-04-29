package package3_queue_stack_deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinByStack {
    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public MinByStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public int min() {
        if(minStack.isEmpty()) {
            return -1;
        }
        return minStack.peekFirst();
    }

    public void push(int val) {
        stack.offerFirst(val);
        if(minStack.isEmpty() || val <= minStack.peekFirst()) {
            minStack.offerFirst(val);
        }
    }

    public int pop() {
        if(stack.isEmpty()) {
            return -1;
        }

        Integer result = stack.pollFirst();
        if(minStack.peekFirst().equals(result)) {
            minStack.pollFirst();
        }
        return result;
    }

    public int top() {
        if(stack.isEmpty()) {
            return -1;
        }
        return stack.peekFirst();
    }

    public static void main(String[] args) {
        MinByStack s = new MinByStack();
        s.push(3);
        s.push(1);
        int min = s.min();
        System.out.println(min);
    }
}
