package package3_queue_stack_deque;


import java.util.Deque;
import java.util.LinkedList;

public class TwoStacksToSortNumbers {
//    public void sort(LinkedList<Integer> s1) {
//        if(s1 == null || s1.size() <= 1) {
//            return;
//        }
//        LinkedList<Integer> s2 = new LinkedList<>();
//        sort(s1, s2);
//    }

    //method1
    private Deque<Integer> sort(Deque<Integer> input, Deque<Integer> buffer) {
        //input: unsorted elements
        //buffer: (top part) buffer, (bottom part) sorted elements
        //step1: sort in ascending order and store result in buffer
        while(!input.isEmpty()) {
            int curMin = Integer.MAX_VALUE;
            int count = 0;

            while(!input.isEmpty()) {
                int cur = input.pollFirst();
                if( cur < curMin) {
                    curMin = cur;
                    count = 1;
                } else if(cur == curMin) {
                    count++;
                }
                buffer.offerFirst(cur);
            }

            while(!buffer.isEmpty() && buffer.peekFirst() >= curMin) {
                int tmp = buffer.pollFirst();
                if(tmp != curMin) {
                    input.offerFirst(tmp);
                }
            }

            while(count-- > 0){
                buffer.offerFirst(curMin);
            }
        }

        //step2: move result from buffer to input => descending order
        while(!buffer.isEmpty()) {
            input.offerFirst(buffer.pollFirst());
        }

        return input;
    }

    //TC: O(n^2)
    //SC: O(n)

    //method2
    public Deque<Integer> sort2(Deque<Integer> input, Deque<Integer> buffer) {
        int preMax = Integer.MAX_VALUE;
        while(input.peekFirst() < preMax) {
            int curMax = Integer.MIN_VALUE;
            int count = 0;

            while(!input.isEmpty() && input.peekFirst() < preMax) {
                int cur = input.pollFirst();
                if(cur > curMax) {
                    curMax = cur;
                    count = 1;
                } else if (cur == curMax) {
                    count++;
                }
                buffer.offerFirst(cur);
            }

            while(count-- > 0){
                input.offerFirst(curMax);
            }

            while(!buffer.isEmpty()) {
                int tmp = buffer.pollFirst();
                if(tmp != curMax) {
                    input.offerFirst(tmp);
                }
            }
            preMax = curMax;
        }
        return input;
    }

    //TC: O(n^2)
    //SC: O(n)

    public static void main(String[] args) {
        Deque<Integer> input = new LinkedList<>();
        Deque<Integer> buffer = new LinkedList<>();

        input.offerFirst(7);
        input.offerFirst(1);
        input.offerFirst(9);
        input.offerFirst(3);

        System.out.println(input);
        System.out.println(buffer);

//        SortNumbersInTwoStacks s = new SortNumbersInTwoStacks();
//        Deque<Integer> res = s.sort(input, buffer);

        TwoStacksToSortNumbers v = new TwoStacksToSortNumbers();
        Deque<Integer> ans = v.sort(input, buffer);

        System.out.println(ans);
    }
}
