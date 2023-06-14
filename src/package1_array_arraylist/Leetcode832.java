package package1_array_arraylist;

import package2_linkedList.ListNode;

//【翻转图像】
// 给定一个n x n的二进制矩阵image，先水平翻转图像，然后反转图像并返回结果。
// 水平翻转图片就是将图片的每一行都进行翻转，即逆序。反转图片的意思是图片中的0全部被1替换，1全部被0替换。
// 例如，水平翻转[1,1,0]的结果是[0,1,1]。反转[0,1,1]的结果是[1,0,0]。
// image = [[1,1,0],[1,0,1],[0,0,0]] => [[1,0,0],[0,1,0],[1,1,1]]
// image = [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]  =>  [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
public class Leetcode832 {
    //TC:O(n^2)   SC:O(1)
    public int[][] flipAndInvertImage(int[][] image) {
        for (int[] im : image) {
            int i = 0;
            int j = image[0].length - 1;
            while (i < j) {
                swap(im, i, j);
                i++;
                j--;
            }
            for(int k = 0; k < image[0].length; k++) {
                im[k] = im[k] == 0 ? 1 : 0;
            }
        }
        return image;
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Leetcode832 lee = new Leetcode832();
        int[][] image = {{1,1,0}, {1,0,1}, {0,0,0}};
        dayin(image);  //[[1,1,0], [1,0,1], [0,0,0]]
        int[][] res = lee.flipAndInvertImage(image);
        dayin(res);  //[[1,0,0], [0,1,0],[1,1,1]]
    }

    public static void dayin(int[][] res){
        for(int i = 0; i < res.length; i++) {
            for(int j = 0; j < res[0].length; j++){
                System.out.print(res[i][j]);
            }
            System.out.println();
        }
    }
}
