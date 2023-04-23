package package3_queue_stack_deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class ThreeStacksToSortNumbers {

    //从大到小
    public void sort(Deque<Integer> input, Deque<Integer> buffer, Deque<Integer> result) {
        while(!input.isEmpty()) {
            int Min = Integer.MAX_VALUE;

            while(!input.isEmpty()) {
                int cur = input.pollFirst();
                if(cur < Min) {
                    Min = cur;
                }
                buffer.push(cur);
            }

            while(!buffer.isEmpty()) {
                int tmp = buffer.pollFirst();
                if(tmp != Min) {
                    input.offerFirst(tmp);
                } else {
                    result.offerFirst(Min);
                }
            }
        }
    }

    //从小到大
    public void sort2(Deque<Integer> input, Deque<Integer> buffer, Deque<Integer> result) {
        while(!input.isEmpty()) {
            int Max = Integer.MIN_VALUE;

            while(!input.isEmpty()) {
                int cur = input.pollFirst();
                if(cur > Max) {
                    Max = cur;
                }
                buffer.offerFirst(cur);
            }

            while (!buffer.isEmpty()) {
                int tmp = buffer.pollFirst();
                if(tmp != Max) {
                    input.offerFirst(tmp);
                } else {
                    result.offerFirst(tmp);
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreeStacksToSortNumbers s = new ThreeStacksToSortNumbers();
        Deque<Integer> input = new ArrayDeque<>();
        input.offerFirst(8);
        input.offerFirst(4);
        input.offerFirst(6);
        System.out.println(input);

        Deque<Integer> buffer = new ArrayDeque<>();
        Deque<Integer> result = new ArrayDeque<>();
//        s.sort(input, buffer, result);
//        System.out.println(result);

        s.sort2(input, buffer, result);
        System.out.println(result);
    }
}
