package package1_array_arraylist;

import java.util.Arrays;

public class A0_CreateArray {

    public static void main(String[] args){
        int[] arr1 = new int[5];
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {1,2,3,4,5};
        System.out.println(Arrays.toString(arr2));

        int[][] matrix1 = new int[3][3];
        int[][] matrix2 = {{1,2,3}, {4,5,6}};
    }
}
