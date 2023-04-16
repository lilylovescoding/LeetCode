package package111_contest20230416;

import package1_array_arraylist.ElementDeduplication;

import java.util.Arrays;

public class Solution6376 {
    //我的解法
//    public int[] rowAndMaximumOnes(int[][] mat) {
//        int x = mat.length;
//        int y = mat[0].length;
//
//        int[] count = new int[x];
//        int[] res = new int[2];
//
//        for(int i = 0; i < x; i++) {
//            for(int j = 0; j < y; j++) {
//                for(int z = 0; z < x; z++) {
//                    count[z] += mat[i][j];
//                }
//            }
//        }
//    }

    //chatGPT的解法
    public int[] rowAndMaximumOnes2(int[][] mat) {
        int maxOnes = 0;
        int maxIndex = 0;

        for(int i = 0; i < mat.length; i++) {
            int ones = 0;
            for(int j = 0; j < mat[i].length; j++) {
                if(mat[i][j] == 1) {
                    ones++;
                }
            }
            if(ones > maxOnes) {
                maxOnes = ones;
                maxIndex = i;
            }
        }
        return new int[]{maxIndex, maxOnes};
    }

    public static void main(String[] args){
        int[][] nums = {{0}, {0},{0}};
        Solution6376 a = new Solution6376();
        int[] res = a.rowAndMaximumOnes2(nums);
        System.out.println(Arrays.toString(res));
    }
}
