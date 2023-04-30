package package5_heap;

public class PercolateUp_Down {

    private int[] array;

    private void percolateUp(int index) {
        while(index > 0) {
            int parentIndex = (index - 1)/2;

            if(array[index] < parentIndex) {
                swap(index, parentIndex);
            } else {
                break;
            }
            index = parentIndex;
        }
    }

    private void percolateDowm(int index) {

    }

    private void swap(int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
