//package package3_queue_stack_deque;
//
//import java.util.ArrayDeque;
//import java.util.Deque;
//
//public class ThreeStacksToSortNumbers {
//
//    public void sort(Deque<Integer> input, Deque<Integer> buffer, Deque<Integer> result) {
//
//        int Min = Integer.MAX_VALUE;
//
//        while(!input.isEmpty()) {
//            int cur = input.pollFirst();
//            if(cur < Min) {
//                Min = cur;
//            }
//            buffer.push(cur);
//        }
//
//        while(!buffer.isEmpty()) {
//           int tmp = buffer.pollFirst();
//           if(tmp != Min) {
//               input.offerFirst(tmp);
//           }else{
//               result.offerFirst(tmp);
//           }
//        }
//
//        result.offerFirst(Min);
//    }
//
//    public static void main(String[] args) {
//        ThreeStacksToSortNumbers s = new ThreeStacksToSortNumbers();
//
//        s.sort();
//    }
//}
