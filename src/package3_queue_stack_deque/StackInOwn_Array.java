package package3_queue_stack_deque;

public class StackInOwn_Array {

    private int[] array;
    private int head;
    private int size;

    public StackInOwn_Array(int cap) {
        array = new int[cap];
        head = -1;
    }

    public boolean push(int ele) {
        if(isFull()) {
            return false;
        }
        array[++head] = ele;  //先++再赋值
        return true;
    }

    public Integer pop() {
        return isEmpty()? null : array[head--];  //先return再--
    }

    public Integer peek() {
        return isEmpty() ? null : array[head];
    }

    public int size() {
        return head + 1;
    }

    public boolean isEmpty() {
        return size() == 0;
    }


    public boolean isFull() {
        return size() == array.length;
    }

    public static void main(String[] args) {


    }
}
