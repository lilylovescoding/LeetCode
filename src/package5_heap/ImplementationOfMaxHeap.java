package package5_heap;

import java.util.Comparator;

//public class ImplementationOfMaxHeap {
////    private int[] array;
////    private int size;
////    private Comparator<E> comparator;
//
////    public ImplementationOfMaxHeap(int[] array, Comparator<E> comparator) {
////        if(array == null || array.length <= 1) {
////            throw new IllegalArgumentException("input array can not be null or empty");
////        }
////
////        this.array = array;
////        size = array.length;
////        this.comparator = comparator;
////        heapify();
////    }
////
////    public void percolateUp(int index) {
////        while(index > 0) {
////            int parentIndex = (index - 1)/2;
////            if(comparator.compare(array[parentIndex] > array[index]) > 0) {
////                swap(parentIndex, index);
////            } else {
////                break;
////            }
////            index = parentIndex;
////        }
//    }
//}
