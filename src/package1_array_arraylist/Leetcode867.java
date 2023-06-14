package package1_array_arraylist;

//【转置矩阵】：给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵
// 矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
// matrix = [[1,2,3],[4,5,6],[7,8,9]] => [[1,4,7],[2,5,8],[3,6,9]]
// matrix = [[1,2,3],[4,5,6]] => [[1,4],[2,5],[3,6]]
public class Leetcode867 {

    //TC:O(mn)  SC:O(1)
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] swap = new int[n][m];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                swap[j][i] = matrix[i][j];
            }
        }
        return swap;
    }

    public static void main(String[] args) {
        Leetcode867 lee = new Leetcode867();
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] res = lee.transpose(matrix);
        dayin(res);  //147258369
    }

    public static void dayin(int[][] res){
        for(int i = 0; i < res.length; i++) {
            for(int j = 0; j < res[0].length; j++){
                System.out.print(res[i][j]);
            }
        }
    }
}
