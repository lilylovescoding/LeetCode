package package3_queue_stack_deque;

import package2_linkedList.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class  QueueByTwoStacks {
    private LinkedList<Integer> input;
    private LinkedList<Integer> output;

    public QueueByTwoStacks() {
        input = new LinkedList<Integer>();
        output = new LinkedList<Integer>();
    }

    public Integer poll() {
        move();
        return output.isEmpty() ? null : output.pollFirst();
    }

    public void offer(int value) {
        input.offerFirst(value);
    }

    public Integer peek() {
        move();
        return output.isEmpty() ? null : output.peekFirst();
    }

    private void move() {
        if(output.isEmpty()) {
            while(!input.isEmpty()) {
                output.offerFirst(input.pollFirst());
            }
        }
    }

    public int size() {
        return input.size() + output.size();
    }

    public boolean isEmpty() {
        return input.size() == 0 && output.size() == 0;
    }


    public static void main(String[] args) {
        QueueByTwoStacks s = new QueueByTwoStacks();

        s.offer(1);
        s.offer(2);
        s.offer(3);

        System.out.println(s.input);

        System.out.println(s.peek());
    }
}
