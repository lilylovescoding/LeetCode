package package3_queue_stack_deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeByThreeStack {

    private Deque<Integer> left;
    private Deque<Integer> right;
    private Deque<Integer> buffer;

    public DequeByThreeStack() {
        left = new ArrayDeque<>();
        right = new ArrayDeque<>();
        buffer = new ArrayDeque<>();
    }

    public void offerFirst(int element) {
        left.offerFirst(element);
    }

    public void offerLast(int element) {
        right.offerFirst(element);
    }

    public Integer pollFirst() {
        move(right, left);
        return left.isEmpty() ? null : right.pollFirst();
    }

    public Integer pollLast() {
        move(left, right);
        return right.isEmpty() ? null : left.pollFirst();
    }

    public Integer peekFirst() {
        move(right, left);
        return left.isEmpty() ? null : left.peekFirst();
    }

    public Integer peekLast() {
        move(left, right);
        return right.isEmpty() ? null : right.peekFirst();
    }

    public int size() {
        return left.size() + right.size();
    }

    public boolean isEmpty() {
        return left.isEmpty() && right.isEmpty();
    }

    private void move(Deque<Integer> d1, Deque<Integer> d2) {
        if(!d2.isEmpty()) {
            return;
        }

        int halfsize = d1.size()/2;
        for(int i = 0; i < halfsize; i++) {
            buffer.offerFirst(d1.pollFirst());
        }
        while(!d1.isEmpty()) {
            d2.offerFirst(d1.pollFirst());
        }
        while(!buffer.isEmpty()) {
            d1.offerFirst(buffer.pollFirst());
        }
    }
}
