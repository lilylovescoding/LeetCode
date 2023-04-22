package package3_queue_stack_deque;

import java.util.Arrays;

public class QueueInOwn_Array {
    private int[] array;
    private int size;

    public QueueInOwn_Array(int cap) {
        array = new int[cap];
        size = 0;
    }

    public int[] offer(int ele){
        if(isFull()) {
            return array;
        }
        array[size] = ele;
        size++;
        return array;
    }

    public int peek() {
        return isEmpty() ? null : array[0];
    }

    public int[] poll() {
        if(isEmpty()) {
            return null;
        }
        array[0] = 0;
        size --;
        return array;
    }

    public int size() {
        return size;
    }

    public boolean isFull() {
        return size == array.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        QueueInOwn_Array s = new QueueInOwn_Array(3);
        s.offer(5);
        s.offer(2);
        s.offer(3);
        s.offer(4);
        System.out.println(Arrays.toString(s.array));

        System.out.println(s.peek());

        s.poll();
        System.out.println(Arrays.toString(s.array));
    }
}
