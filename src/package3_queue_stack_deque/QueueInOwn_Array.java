package package3_queue_stack_deque;

public class QueueInOwn_Array {
    private int[] array;
    private int head;
    private int tail;
    private int size;

    public QueueInOwn_Array(int capacity) {
        array = new int[capacity];
    }

    public boolean offer(int ele){
        if(isFull()) {
            return false;
        }

        array[tail] = ele;
        tail = tail + 1 == array.length ? 0 : tail + 1;
        size++;
        return true;
    }

    public int peek() {
        return isEmpty() ? null : array[head];
    }

    public Integer poll() {
        if(isEmpty()) {
            return null;
        }
        int result = array[head];
        head = head + 1 == array.length ? 0 : head + 1;
        size --;
        return result;

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


}
