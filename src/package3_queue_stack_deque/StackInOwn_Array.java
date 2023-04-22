package package3_queue_stack_deque;

import java.util.Arrays;

public class StackInOwn_Array {
    private int[] array;
    private int head;

    public StackInOwn_Array(int cap) {
        array = new int[cap];
        head = -1;
    }

    //实现push方法
    public int[] push(int ele) {
        if(isFull()) {
            return array;
        }
        array[++head] = ele;  //先++再赋值
        return array;
    }

    //实现pop方法
    public Integer pop() {
        return isEmpty()? null : array[head--];  //先return再--
    }

    //实现peek方法
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
        StackInOwn_Array s = new StackInOwn_Array(5);
        System.out.println(Arrays.toString(s.array));

        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(Arrays.toString(s.array));

        int peek = s.peek();
        System.out.println(peek);

        int pop = s.pop();
        System.out.println(pop);
    }
}
